package com.mycompany.myapp.web.rest;

import static com.mycompany.myapp.domain.UsuarioAsserts.*;
import static com.mycompany.myapp.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.domain.Usuario;
import com.mycompany.myapp.domain.enumeration.TipoPlano;
import com.mycompany.myapp.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link UsuarioResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class UsuarioResourceIT {

    private static final TipoPlano DEFAULT_PLANO = TipoPlano.GRATUITO;
    private static final TipoPlano UPDATED_PLANO = TipoPlano.BRONZE;

    private static final Instant DEFAULT_DATA_REGISTRO = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATA_REGISTRO = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/usuarios";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUsuarioMockMvc;

    private Usuario usuario;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Usuario createEntity(EntityManager em) {
        Usuario usuario = new Usuario().plano(DEFAULT_PLANO).dataRegistro(DEFAULT_DATA_REGISTRO);
        return usuario;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Usuario createUpdatedEntity(EntityManager em) {
        Usuario usuario = new Usuario().plano(UPDATED_PLANO).dataRegistro(UPDATED_DATA_REGISTRO);
        return usuario;
    }

    @BeforeEach
    public void initTest() {
        usuario = createEntity(em);
    }

    @Test
    @Transactional
    void createUsuario() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Usuario
        var returnedUsuario = om.readValue(
            restUsuarioMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(usuario)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            Usuario.class
        );

        // Validate the Usuario in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertUsuarioUpdatableFieldsEquals(returnedUsuario, getPersistedUsuario(returnedUsuario));
    }

    @Test
    @Transactional
    void createUsuarioWithExistingId() throws Exception {
        // Create the Usuario with an existing ID
        usuario.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restUsuarioMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(usuario)))
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllUsuarios() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get all the usuarioList
        restUsuarioMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(usuario.getId().intValue())))
            .andExpect(jsonPath("$.[*].plano").value(hasItem(DEFAULT_PLANO.toString())))
            .andExpect(jsonPath("$.[*].dataRegistro").value(hasItem(DEFAULT_DATA_REGISTRO.toString())));
    }

    @Test
    @Transactional
    void getUsuario() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get the usuario
        restUsuarioMockMvc
            .perform(get(ENTITY_API_URL_ID, usuario.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(usuario.getId().intValue()))
            .andExpect(jsonPath("$.plano").value(DEFAULT_PLANO.toString()))
            .andExpect(jsonPath("$.dataRegistro").value(DEFAULT_DATA_REGISTRO.toString()));
    }

    @Test
    @Transactional
    void getUsuariosByIdFiltering() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        Long id = usuario.getId();

        defaultUsuarioFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultUsuarioFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultUsuarioFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllUsuariosByPlanoIsEqualToSomething() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get all the usuarioList where plano equals to
        defaultUsuarioFiltering("plano.equals=" + DEFAULT_PLANO, "plano.equals=" + UPDATED_PLANO);
    }

    @Test
    @Transactional
    void getAllUsuariosByPlanoIsInShouldWork() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get all the usuarioList where plano in
        defaultUsuarioFiltering("plano.in=" + DEFAULT_PLANO + "," + UPDATED_PLANO, "plano.in=" + UPDATED_PLANO);
    }

    @Test
    @Transactional
    void getAllUsuariosByPlanoIsNullOrNotNull() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get all the usuarioList where plano is not null
        defaultUsuarioFiltering("plano.specified=true", "plano.specified=false");
    }

    @Test
    @Transactional
    void getAllUsuariosByDataRegistroIsEqualToSomething() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get all the usuarioList where dataRegistro equals to
        defaultUsuarioFiltering("dataRegistro.equals=" + DEFAULT_DATA_REGISTRO, "dataRegistro.equals=" + UPDATED_DATA_REGISTRO);
    }

    @Test
    @Transactional
    void getAllUsuariosByDataRegistroIsInShouldWork() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get all the usuarioList where dataRegistro in
        defaultUsuarioFiltering(
            "dataRegistro.in=" + DEFAULT_DATA_REGISTRO + "," + UPDATED_DATA_REGISTRO,
            "dataRegistro.in=" + UPDATED_DATA_REGISTRO
        );
    }

    @Test
    @Transactional
    void getAllUsuariosByDataRegistroIsNullOrNotNull() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get all the usuarioList where dataRegistro is not null
        defaultUsuarioFiltering("dataRegistro.specified=true", "dataRegistro.specified=false");
    }

    @Test
    @Transactional
    void getAllUsuariosByInternalUserIsEqualToSomething() throws Exception {
        User internalUser;
        if (TestUtil.findAll(em, User.class).isEmpty()) {
            usuarioRepository.saveAndFlush(usuario);
            internalUser = UserResourceIT.createEntity(em);
        } else {
            internalUser = TestUtil.findAll(em, User.class).get(0);
        }
        em.persist(internalUser);
        em.flush();
        usuario.setInternalUser(internalUser);
        usuarioRepository.saveAndFlush(usuario);
        Long internalUserId = internalUser.getId();
        // Get all the usuarioList where internalUser equals to internalUserId
        defaultUsuarioShouldBeFound("internalUserId.equals=" + internalUserId);

        // Get all the usuarioList where internalUser equals to (internalUserId + 1)
        defaultUsuarioShouldNotBeFound("internalUserId.equals=" + (internalUserId + 1));
    }

    private void defaultUsuarioFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultUsuarioShouldBeFound(shouldBeFound);
        defaultUsuarioShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultUsuarioShouldBeFound(String filter) throws Exception {
        restUsuarioMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(usuario.getId().intValue())))
            .andExpect(jsonPath("$.[*].plano").value(hasItem(DEFAULT_PLANO.toString())))
            .andExpect(jsonPath("$.[*].dataRegistro").value(hasItem(DEFAULT_DATA_REGISTRO.toString())));

        // Check, that the count call also returns 1
        restUsuarioMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultUsuarioShouldNotBeFound(String filter) throws Exception {
        restUsuarioMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restUsuarioMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingUsuario() throws Exception {
        // Get the usuario
        restUsuarioMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingUsuario() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the usuario
        Usuario updatedUsuario = usuarioRepository.findById(usuario.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedUsuario are not directly saved in db
        em.detach(updatedUsuario);
        updatedUsuario.plano(UPDATED_PLANO).dataRegistro(UPDATED_DATA_REGISTRO);

        restUsuarioMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedUsuario.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedUsuario))
            )
            .andExpect(status().isOk());

        // Validate the Usuario in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedUsuarioToMatchAllProperties(updatedUsuario);
    }

    @Test
    @Transactional
    void putNonExistingUsuario() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        usuario.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(put(ENTITY_API_URL_ID, usuario.getId()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(usuario)))
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchUsuario() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        usuario.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(usuario))
            )
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamUsuario() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        usuario.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(usuario)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Usuario in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateUsuarioWithPatch() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the usuario using partial update
        Usuario partialUpdatedUsuario = new Usuario();
        partialUpdatedUsuario.setId(usuario.getId());

        partialUpdatedUsuario.dataRegistro(UPDATED_DATA_REGISTRO);

        restUsuarioMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedUsuario.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedUsuario))
            )
            .andExpect(status().isOk());

        // Validate the Usuario in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertUsuarioUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedUsuario, usuario), getPersistedUsuario(usuario));
    }

    @Test
    @Transactional
    void fullUpdateUsuarioWithPatch() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the usuario using partial update
        Usuario partialUpdatedUsuario = new Usuario();
        partialUpdatedUsuario.setId(usuario.getId());

        partialUpdatedUsuario.plano(UPDATED_PLANO).dataRegistro(UPDATED_DATA_REGISTRO);

        restUsuarioMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedUsuario.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedUsuario))
            )
            .andExpect(status().isOk());

        // Validate the Usuario in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertUsuarioUpdatableFieldsEquals(partialUpdatedUsuario, getPersistedUsuario(partialUpdatedUsuario));
    }

    @Test
    @Transactional
    void patchNonExistingUsuario() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        usuario.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, usuario.getId()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(usuario))
            )
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchUsuario() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        usuario.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(usuario))
            )
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamUsuario() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        usuario.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(usuario)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Usuario in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteUsuario() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the usuario
        restUsuarioMockMvc
            .perform(delete(ENTITY_API_URL_ID, usuario.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return usuarioRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected Usuario getPersistedUsuario(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId()).orElseThrow();
    }

    protected void assertPersistedUsuarioToMatchAllProperties(Usuario expectedUsuario) {
        assertUsuarioAllPropertiesEquals(expectedUsuario, getPersistedUsuario(expectedUsuario));
    }

    protected void assertPersistedUsuarioToMatchUpdatableProperties(Usuario expectedUsuario) {
        assertUsuarioAllUpdatablePropertiesEquals(expectedUsuario, getPersistedUsuario(expectedUsuario));
    }
}

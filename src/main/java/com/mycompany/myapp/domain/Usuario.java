package com.mycompany.myapp.domain;

import com.mycompany.myapp.domain.enumeration.TipoPlano;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Usuario.
 */
@Entity
@Table(name = "usuario")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "plano")
    private TipoPlano plano;

    @Column(name = "data_registro")
    private Instant dataRegistro;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    private User internalUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Usuario id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPlano getPlano() {
        return this.plano;
    }

    public Usuario plano(TipoPlano plano) {
        this.setPlano(plano);
        return this;
    }

    public void setPlano(TipoPlano plano) {
        this.plano = plano;
    }

    public Instant getDataRegistro() {
        return this.dataRegistro;
    }

    public Usuario dataRegistro(Instant dataRegistro) {
        this.setDataRegistro(dataRegistro);
        return this;
    }

    public void setDataRegistro(Instant dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public User getInternalUser() {
        return this.internalUser;
    }

    public void setInternalUser(User user) {
        this.internalUser = user;
    }

    public Usuario internalUser(User user) {
        this.setInternalUser(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usuario)) {
            return false;
        }
        return getId() != null && getId().equals(((Usuario) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Usuario{" +
            "id=" + getId() +
            ", plano='" + getPlano() + "'" +
            ", dataRegistro='" + getDataRegistro() + "'" +
            "}";
    }
}

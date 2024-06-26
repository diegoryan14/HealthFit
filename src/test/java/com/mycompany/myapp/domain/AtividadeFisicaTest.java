package com.mycompany.myapp.domain;

import static com.mycompany.myapp.domain.AtividadeFisicaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AtividadeFisicaTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AtividadeFisica.class);
        AtividadeFisica atividadeFisica1 = getAtividadeFisicaSample1();
        AtividadeFisica atividadeFisica2 = new AtividadeFisica();
        assertThat(atividadeFisica1).isNotEqualTo(atividadeFisica2);

        atividadeFisica2.setId(atividadeFisica1.getId());
        assertThat(atividadeFisica1).isEqualTo(atividadeFisica2);

        atividadeFisica2 = getAtividadeFisicaSample2();
        assertThat(atividadeFisica1).isNotEqualTo(atividadeFisica2);
    }
}

package com.mycompany.myapp.domain;

import static com.mycompany.myapp.domain.ConsultaEspecialistaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConsultaEspecialistaTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConsultaEspecialista.class);
        ConsultaEspecialista consultaEspecialista1 = getConsultaEspecialistaSample1();
        ConsultaEspecialista consultaEspecialista2 = new ConsultaEspecialista();
        assertThat(consultaEspecialista1).isNotEqualTo(consultaEspecialista2);

        consultaEspecialista2.setId(consultaEspecialista1.getId());
        assertThat(consultaEspecialista1).isEqualTo(consultaEspecialista2);

        consultaEspecialista2 = getConsultaEspecialistaSample2();
        assertThat(consultaEspecialista1).isNotEqualTo(consultaEspecialista2);
    }
}

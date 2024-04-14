package com.mycompany.myapp.domain;

import static com.mycompany.myapp.domain.DietaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DietaTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Dieta.class);
        Dieta dieta1 = getDietaSample1();
        Dieta dieta2 = new Dieta();
        assertThat(dieta1).isNotEqualTo(dieta2);

        dieta2.setId(dieta1.getId());
        assertThat(dieta1).isEqualTo(dieta2);

        dieta2 = getDietaSample2();
        assertThat(dieta1).isNotEqualTo(dieta2);
    }
}

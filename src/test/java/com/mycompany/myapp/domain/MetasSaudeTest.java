package com.mycompany.myapp.domain;

import static com.mycompany.myapp.domain.MetasSaudeTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetasSaudeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MetasSaude.class);
        MetasSaude metasSaude1 = getMetasSaudeSample1();
        MetasSaude metasSaude2 = new MetasSaude();
        assertThat(metasSaude1).isNotEqualTo(metasSaude2);

        metasSaude2.setId(metasSaude1.getId());
        assertThat(metasSaude1).isEqualTo(metasSaude2);

        metasSaude2 = getMetasSaudeSample2();
        assertThat(metasSaude1).isNotEqualTo(metasSaude2);
    }
}

package com.mycompany.myapp.domain;

import com.mycompany.myapp.domain.enumeration.StatusConsulta;
import com.mycompany.myapp.domain.enumeration.TipoEspecialista;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ConsultaEspecialista.
 */
@Entity
@Table(name = "consulta_especialista")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ConsultaEspecialista implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_especialista")
    private TipoEspecialista tipoEspecialista;

    @Column(name = "data_horario_consulta")
    private Instant dataHorarioConsulta;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_consulta")
    private StatusConsulta statusConsulta;

    @ManyToOne(fetch = FetchType.LAZY)
    private User internalUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ConsultaEspecialista id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEspecialista getTipoEspecialista() {
        return this.tipoEspecialista;
    }

    public ConsultaEspecialista tipoEspecialista(TipoEspecialista tipoEspecialista) {
        this.setTipoEspecialista(tipoEspecialista);
        return this;
    }

    public void setTipoEspecialista(TipoEspecialista tipoEspecialista) {
        this.tipoEspecialista = tipoEspecialista;
    }

    public Instant getDataHorarioConsulta() {
        return this.dataHorarioConsulta;
    }

    public ConsultaEspecialista dataHorarioConsulta(Instant dataHorarioConsulta) {
        this.setDataHorarioConsulta(dataHorarioConsulta);
        return this;
    }

    public void setDataHorarioConsulta(Instant dataHorarioConsulta) {
        this.dataHorarioConsulta = dataHorarioConsulta;
    }

    public StatusConsulta getStatusConsulta() {
        return this.statusConsulta;
    }

    public ConsultaEspecialista statusConsulta(StatusConsulta statusConsulta) {
        this.setStatusConsulta(statusConsulta);
        return this;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public User getInternalUser() {
        return this.internalUser;
    }

    public void setInternalUser(User user) {
        this.internalUser = user;
    }

    public ConsultaEspecialista internalUser(User user) {
        this.setInternalUser(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConsultaEspecialista)) {
            return false;
        }
        return getId() != null && getId().equals(((ConsultaEspecialista) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConsultaEspecialista{" +
            "id=" + getId() +
            ", tipoEspecialista='" + getTipoEspecialista() + "'" +
            ", dataHorarioConsulta='" + getDataHorarioConsulta() + "'" +
            ", statusConsulta='" + getStatusConsulta() + "'" +
            "}";
    }
}

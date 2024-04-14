package com.mycompany.myapp.service.criteria;

import com.mycompany.myapp.domain.enumeration.StatusConsulta;
import com.mycompany.myapp.domain.enumeration.TipoEspecialista;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.mycompany.myapp.domain.ConsultaEspecialista} entity. This class is used
 * in {@link com.mycompany.myapp.web.rest.ConsultaEspecialistaResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /consulta-especialistas?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ConsultaEspecialistaCriteria implements Serializable, Criteria {

    /**
     * Class for filtering TipoEspecialista
     */
    public static class TipoEspecialistaFilter extends Filter<TipoEspecialista> {

        public TipoEspecialistaFilter() {}

        public TipoEspecialistaFilter(TipoEspecialistaFilter filter) {
            super(filter);
        }

        @Override
        public TipoEspecialistaFilter copy() {
            return new TipoEspecialistaFilter(this);
        }
    }

    /**
     * Class for filtering StatusConsulta
     */
    public static class StatusConsultaFilter extends Filter<StatusConsulta> {

        public StatusConsultaFilter() {}

        public StatusConsultaFilter(StatusConsultaFilter filter) {
            super(filter);
        }

        @Override
        public StatusConsultaFilter copy() {
            return new StatusConsultaFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private TipoEspecialistaFilter tipoEspecialista;

    private InstantFilter dataHorarioConsulta;

    private StatusConsultaFilter statusConsulta;

    private LongFilter internalUserId;

    private Boolean distinct;

    public ConsultaEspecialistaCriteria() {}

    public ConsultaEspecialistaCriteria(ConsultaEspecialistaCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.tipoEspecialista = other.optionalTipoEspecialista().map(TipoEspecialistaFilter::copy).orElse(null);
        this.dataHorarioConsulta = other.optionalDataHorarioConsulta().map(InstantFilter::copy).orElse(null);
        this.statusConsulta = other.optionalStatusConsulta().map(StatusConsultaFilter::copy).orElse(null);
        this.internalUserId = other.optionalInternalUserId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public ConsultaEspecialistaCriteria copy() {
        return new ConsultaEspecialistaCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public Optional<LongFilter> optionalId() {
        return Optional.ofNullable(id);
    }

    public LongFilter id() {
        if (id == null) {
            setId(new LongFilter());
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public TipoEspecialistaFilter getTipoEspecialista() {
        return tipoEspecialista;
    }

    public Optional<TipoEspecialistaFilter> optionalTipoEspecialista() {
        return Optional.ofNullable(tipoEspecialista);
    }

    public TipoEspecialistaFilter tipoEspecialista() {
        if (tipoEspecialista == null) {
            setTipoEspecialista(new TipoEspecialistaFilter());
        }
        return tipoEspecialista;
    }

    public void setTipoEspecialista(TipoEspecialistaFilter tipoEspecialista) {
        this.tipoEspecialista = tipoEspecialista;
    }

    public InstantFilter getDataHorarioConsulta() {
        return dataHorarioConsulta;
    }

    public Optional<InstantFilter> optionalDataHorarioConsulta() {
        return Optional.ofNullable(dataHorarioConsulta);
    }

    public InstantFilter dataHorarioConsulta() {
        if (dataHorarioConsulta == null) {
            setDataHorarioConsulta(new InstantFilter());
        }
        return dataHorarioConsulta;
    }

    public void setDataHorarioConsulta(InstantFilter dataHorarioConsulta) {
        this.dataHorarioConsulta = dataHorarioConsulta;
    }

    public StatusConsultaFilter getStatusConsulta() {
        return statusConsulta;
    }

    public Optional<StatusConsultaFilter> optionalStatusConsulta() {
        return Optional.ofNullable(statusConsulta);
    }

    public StatusConsultaFilter statusConsulta() {
        if (statusConsulta == null) {
            setStatusConsulta(new StatusConsultaFilter());
        }
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsultaFilter statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public LongFilter getInternalUserId() {
        return internalUserId;
    }

    public Optional<LongFilter> optionalInternalUserId() {
        return Optional.ofNullable(internalUserId);
    }

    public LongFilter internalUserId() {
        if (internalUserId == null) {
            setInternalUserId(new LongFilter());
        }
        return internalUserId;
    }

    public void setInternalUserId(LongFilter internalUserId) {
        this.internalUserId = internalUserId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public Optional<Boolean> optionalDistinct() {
        return Optional.ofNullable(distinct);
    }

    public Boolean distinct() {
        if (distinct == null) {
            setDistinct(true);
        }
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ConsultaEspecialistaCriteria that = (ConsultaEspecialistaCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(tipoEspecialista, that.tipoEspecialista) &&
            Objects.equals(dataHorarioConsulta, that.dataHorarioConsulta) &&
            Objects.equals(statusConsulta, that.statusConsulta) &&
            Objects.equals(internalUserId, that.internalUserId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoEspecialista, dataHorarioConsulta, statusConsulta, internalUserId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConsultaEspecialistaCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalTipoEspecialista().map(f -> "tipoEspecialista=" + f + ", ").orElse("") +
            optionalDataHorarioConsulta().map(f -> "dataHorarioConsulta=" + f + ", ").orElse("") +
            optionalStatusConsulta().map(f -> "statusConsulta=" + f + ", ").orElse("") +
            optionalInternalUserId().map(f -> "internalUserId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}

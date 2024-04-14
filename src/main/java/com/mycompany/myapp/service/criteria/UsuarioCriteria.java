package com.mycompany.myapp.service.criteria;

import com.mycompany.myapp.domain.enumeration.TipoPlano;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.mycompany.myapp.domain.Usuario} entity. This class is used
 * in {@link com.mycompany.myapp.web.rest.UsuarioResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /usuarios?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UsuarioCriteria implements Serializable, Criteria {

    /**
     * Class for filtering TipoPlano
     */
    public static class TipoPlanoFilter extends Filter<TipoPlano> {

        public TipoPlanoFilter() {}

        public TipoPlanoFilter(TipoPlanoFilter filter) {
            super(filter);
        }

        @Override
        public TipoPlanoFilter copy() {
            return new TipoPlanoFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private TipoPlanoFilter plano;

    private InstantFilter dataRegistro;

    private LongFilter internalUserId;

    private Boolean distinct;

    public UsuarioCriteria() {}

    public UsuarioCriteria(UsuarioCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.plano = other.optionalPlano().map(TipoPlanoFilter::copy).orElse(null);
        this.dataRegistro = other.optionalDataRegistro().map(InstantFilter::copy).orElse(null);
        this.internalUserId = other.optionalInternalUserId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public UsuarioCriteria copy() {
        return new UsuarioCriteria(this);
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

    public TipoPlanoFilter getPlano() {
        return plano;
    }

    public Optional<TipoPlanoFilter> optionalPlano() {
        return Optional.ofNullable(plano);
    }

    public TipoPlanoFilter plano() {
        if (plano == null) {
            setPlano(new TipoPlanoFilter());
        }
        return plano;
    }

    public void setPlano(TipoPlanoFilter plano) {
        this.plano = plano;
    }

    public InstantFilter getDataRegistro() {
        return dataRegistro;
    }

    public Optional<InstantFilter> optionalDataRegistro() {
        return Optional.ofNullable(dataRegistro);
    }

    public InstantFilter dataRegistro() {
        if (dataRegistro == null) {
            setDataRegistro(new InstantFilter());
        }
        return dataRegistro;
    }

    public void setDataRegistro(InstantFilter dataRegistro) {
        this.dataRegistro = dataRegistro;
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
        final UsuarioCriteria that = (UsuarioCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(plano, that.plano) &&
            Objects.equals(dataRegistro, that.dataRegistro) &&
            Objects.equals(internalUserId, that.internalUserId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plano, dataRegistro, internalUserId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UsuarioCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalPlano().map(f -> "plano=" + f + ", ").orElse("") +
            optionalDataRegistro().map(f -> "dataRegistro=" + f + ", ").orElse("") +
            optionalInternalUserId().map(f -> "internalUserId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}

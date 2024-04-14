package com.mycompany.myapp.service.criteria;

import com.mycompany.myapp.domain.enumeration.TipoMeta;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.mycompany.myapp.domain.MetasSaude} entity. This class is used
 * in {@link com.mycompany.myapp.web.rest.MetasSaudeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /metas-saudes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MetasSaudeCriteria implements Serializable, Criteria {

    /**
     * Class for filtering TipoMeta
     */
    public static class TipoMetaFilter extends Filter<TipoMeta> {

        public TipoMetaFilter() {}

        public TipoMetaFilter(TipoMetaFilter filter) {
            super(filter);
        }

        @Override
        public TipoMetaFilter copy() {
            return new TipoMetaFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private TipoMetaFilter tipoMeta;

    private IntegerFilter valorMeta;

    private InstantFilter dataLimite;

    private LongFilter internalUserId;

    private Boolean distinct;

    public MetasSaudeCriteria() {}

    public MetasSaudeCriteria(MetasSaudeCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.tipoMeta = other.optionalTipoMeta().map(TipoMetaFilter::copy).orElse(null);
        this.valorMeta = other.optionalValorMeta().map(IntegerFilter::copy).orElse(null);
        this.dataLimite = other.optionalDataLimite().map(InstantFilter::copy).orElse(null);
        this.internalUserId = other.optionalInternalUserId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public MetasSaudeCriteria copy() {
        return new MetasSaudeCriteria(this);
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

    public TipoMetaFilter getTipoMeta() {
        return tipoMeta;
    }

    public Optional<TipoMetaFilter> optionalTipoMeta() {
        return Optional.ofNullable(tipoMeta);
    }

    public TipoMetaFilter tipoMeta() {
        if (tipoMeta == null) {
            setTipoMeta(new TipoMetaFilter());
        }
        return tipoMeta;
    }

    public void setTipoMeta(TipoMetaFilter tipoMeta) {
        this.tipoMeta = tipoMeta;
    }

    public IntegerFilter getValorMeta() {
        return valorMeta;
    }

    public Optional<IntegerFilter> optionalValorMeta() {
        return Optional.ofNullable(valorMeta);
    }

    public IntegerFilter valorMeta() {
        if (valorMeta == null) {
            setValorMeta(new IntegerFilter());
        }
        return valorMeta;
    }

    public void setValorMeta(IntegerFilter valorMeta) {
        this.valorMeta = valorMeta;
    }

    public InstantFilter getDataLimite() {
        return dataLimite;
    }

    public Optional<InstantFilter> optionalDataLimite() {
        return Optional.ofNullable(dataLimite);
    }

    public InstantFilter dataLimite() {
        if (dataLimite == null) {
            setDataLimite(new InstantFilter());
        }
        return dataLimite;
    }

    public void setDataLimite(InstantFilter dataLimite) {
        this.dataLimite = dataLimite;
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
        final MetasSaudeCriteria that = (MetasSaudeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(tipoMeta, that.tipoMeta) &&
            Objects.equals(valorMeta, that.valorMeta) &&
            Objects.equals(dataLimite, that.dataLimite) &&
            Objects.equals(internalUserId, that.internalUserId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoMeta, valorMeta, dataLimite, internalUserId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MetasSaudeCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalTipoMeta().map(f -> "tipoMeta=" + f + ", ").orElse("") +
            optionalValorMeta().map(f -> "valorMeta=" + f + ", ").orElse("") +
            optionalDataLimite().map(f -> "dataLimite=" + f + ", ").orElse("") +
            optionalInternalUserId().map(f -> "internalUserId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}

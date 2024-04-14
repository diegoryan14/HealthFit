package com.mycompany.myapp.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.mycompany.myapp.domain.Anuncio} entity. This class is used
 * in {@link com.mycompany.myapp.web.rest.AnuncioResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /anuncios?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AnuncioCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter titulo;

    private StringFilter descricao;

    private InstantFilter dataPublicacao;

    private DoubleFilter preco;

    private Boolean distinct;

    public AnuncioCriteria() {}

    public AnuncioCriteria(AnuncioCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.titulo = other.optionalTitulo().map(StringFilter::copy).orElse(null);
        this.descricao = other.optionalDescricao().map(StringFilter::copy).orElse(null);
        this.dataPublicacao = other.optionalDataPublicacao().map(InstantFilter::copy).orElse(null);
        this.preco = other.optionalPreco().map(DoubleFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public AnuncioCriteria copy() {
        return new AnuncioCriteria(this);
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

    public StringFilter getTitulo() {
        return titulo;
    }

    public Optional<StringFilter> optionalTitulo() {
        return Optional.ofNullable(titulo);
    }

    public StringFilter titulo() {
        if (titulo == null) {
            setTitulo(new StringFilter());
        }
        return titulo;
    }

    public void setTitulo(StringFilter titulo) {
        this.titulo = titulo;
    }

    public StringFilter getDescricao() {
        return descricao;
    }

    public Optional<StringFilter> optionalDescricao() {
        return Optional.ofNullable(descricao);
    }

    public StringFilter descricao() {
        if (descricao == null) {
            setDescricao(new StringFilter());
        }
        return descricao;
    }

    public void setDescricao(StringFilter descricao) {
        this.descricao = descricao;
    }

    public InstantFilter getDataPublicacao() {
        return dataPublicacao;
    }

    public Optional<InstantFilter> optionalDataPublicacao() {
        return Optional.ofNullable(dataPublicacao);
    }

    public InstantFilter dataPublicacao() {
        if (dataPublicacao == null) {
            setDataPublicacao(new InstantFilter());
        }
        return dataPublicacao;
    }

    public void setDataPublicacao(InstantFilter dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public DoubleFilter getPreco() {
        return preco;
    }

    public Optional<DoubleFilter> optionalPreco() {
        return Optional.ofNullable(preco);
    }

    public DoubleFilter preco() {
        if (preco == null) {
            setPreco(new DoubleFilter());
        }
        return preco;
    }

    public void setPreco(DoubleFilter preco) {
        this.preco = preco;
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
        final AnuncioCriteria that = (AnuncioCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(titulo, that.titulo) &&
            Objects.equals(descricao, that.descricao) &&
            Objects.equals(dataPublicacao, that.dataPublicacao) &&
            Objects.equals(preco, that.preco) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao, dataPublicacao, preco, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnuncioCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalTitulo().map(f -> "titulo=" + f + ", ").orElse("") +
            optionalDescricao().map(f -> "descricao=" + f + ", ").orElse("") +
            optionalDataPublicacao().map(f -> "dataPublicacao=" + f + ", ").orElse("") +
            optionalPreco().map(f -> "preco=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}

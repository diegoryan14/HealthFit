package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Anuncio;
import com.mycompany.myapp.repository.AnuncioRepository;
import com.mycompany.myapp.service.AnuncioService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.mycompany.myapp.domain.Anuncio}.
 */
@Service
@Transactional
public class AnuncioServiceImpl implements AnuncioService {

    private final Logger log = LoggerFactory.getLogger(AnuncioServiceImpl.class);

    private final AnuncioRepository anuncioRepository;

    public AnuncioServiceImpl(AnuncioRepository anuncioRepository) {
        this.anuncioRepository = anuncioRepository;
    }

    @Override
    public Anuncio save(Anuncio anuncio) {
        log.debug("Request to save Anuncio : {}", anuncio);
        return anuncioRepository.save(anuncio);
    }

    @Override
    public Anuncio update(Anuncio anuncio) {
        log.debug("Request to update Anuncio : {}", anuncio);
        return anuncioRepository.save(anuncio);
    }

    @Override
    public Optional<Anuncio> partialUpdate(Anuncio anuncio) {
        log.debug("Request to partially update Anuncio : {}", anuncio);

        return anuncioRepository
            .findById(anuncio.getId())
            .map(existingAnuncio -> {
                if (anuncio.getTitulo() != null) {
                    existingAnuncio.setTitulo(anuncio.getTitulo());
                }
                if (anuncio.getDescricao() != null) {
                    existingAnuncio.setDescricao(anuncio.getDescricao());
                }
                if (anuncio.getDataPublicacao() != null) {
                    existingAnuncio.setDataPublicacao(anuncio.getDataPublicacao());
                }
                if (anuncio.getPreco() != null) {
                    existingAnuncio.setPreco(anuncio.getPreco());
                }

                return existingAnuncio;
            })
            .map(anuncioRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Anuncio> findOne(Long id) {
        log.debug("Request to get Anuncio : {}", id);
        return anuncioRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Anuncio : {}", id);
        anuncioRepository.deleteById(id);
    }
}

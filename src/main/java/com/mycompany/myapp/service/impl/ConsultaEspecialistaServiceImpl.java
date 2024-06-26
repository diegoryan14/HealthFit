package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.ConsultaEspecialista;
import com.mycompany.myapp.repository.ConsultaEspecialistaRepository;
import com.mycompany.myapp.service.ConsultaEspecialistaService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.mycompany.myapp.domain.ConsultaEspecialista}.
 */
@Service
@Transactional
public class ConsultaEspecialistaServiceImpl implements ConsultaEspecialistaService {

    private final Logger log = LoggerFactory.getLogger(ConsultaEspecialistaServiceImpl.class);

    private final ConsultaEspecialistaRepository consultaEspecialistaRepository;

    public ConsultaEspecialistaServiceImpl(ConsultaEspecialistaRepository consultaEspecialistaRepository) {
        this.consultaEspecialistaRepository = consultaEspecialistaRepository;
    }

    @Override
    public ConsultaEspecialista save(ConsultaEspecialista consultaEspecialista) {
        log.debug("Request to save ConsultaEspecialista : {}", consultaEspecialista);
        return consultaEspecialistaRepository.save(consultaEspecialista);
    }

    @Override
    public ConsultaEspecialista update(ConsultaEspecialista consultaEspecialista) {
        log.debug("Request to update ConsultaEspecialista : {}", consultaEspecialista);
        return consultaEspecialistaRepository.save(consultaEspecialista);
    }

    @Override
    public Optional<ConsultaEspecialista> partialUpdate(ConsultaEspecialista consultaEspecialista) {
        log.debug("Request to partially update ConsultaEspecialista : {}", consultaEspecialista);

        return consultaEspecialistaRepository
            .findById(consultaEspecialista.getId())
            .map(existingConsultaEspecialista -> {
                if (consultaEspecialista.getTipoEspecialista() != null) {
                    existingConsultaEspecialista.setTipoEspecialista(consultaEspecialista.getTipoEspecialista());
                }
                if (consultaEspecialista.getDataHorarioConsulta() != null) {
                    existingConsultaEspecialista.setDataHorarioConsulta(consultaEspecialista.getDataHorarioConsulta());
                }
                if (consultaEspecialista.getStatusConsulta() != null) {
                    existingConsultaEspecialista.setStatusConsulta(consultaEspecialista.getStatusConsulta());
                }

                return existingConsultaEspecialista;
            })
            .map(consultaEspecialistaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConsultaEspecialista> findOne(Long id) {
        log.debug("Request to get ConsultaEspecialista : {}", id);
        return consultaEspecialistaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ConsultaEspecialista : {}", id);
        consultaEspecialistaRepository.deleteById(id);
    }
}

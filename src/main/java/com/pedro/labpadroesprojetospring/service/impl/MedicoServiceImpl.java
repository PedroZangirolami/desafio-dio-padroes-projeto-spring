package com.pedro.labpadroesprojetospring.service.impl;

import com.pedro.labpadroesprojetospring.Model.Hospital;
import com.pedro.labpadroesprojetospring.Model.Medico;
import com.pedro.labpadroesprojetospring.Repository.EnderecoRepository;
import com.pedro.labpadroesprojetospring.Repository.HospitalRepository;
import com.pedro.labpadroesprojetospring.Repository.MedicoRepository;
import com.pedro.labpadroesprojetospring.service.MedicoService;
import com.pedro.labpadroesprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Medico> buscarTodos() {
        return medicoRepository.findAll();
    }
    @Override
    public Medico buscarPorId(Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.get();
    }
    @Override
    public void inserir(Medico medico) {

    }

    @Override
    public void atualizar(Long id, Medico cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}

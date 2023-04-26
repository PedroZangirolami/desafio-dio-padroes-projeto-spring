package com.pedro.labpadroesprojetospring.service.impl;

import com.pedro.labpadroesprojetospring.Model.Hospital;
import com.pedro.labpadroesprojetospring.Model.Medico;
import com.pedro.labpadroesprojetospring.Repository.HospitalRepository;
import com.pedro.labpadroesprojetospring.Repository.MedicoRepository;
import com.pedro.labpadroesprojetospring.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Iterable<Hospital> buscarTodos() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital buscarPorId(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        return hospital.get();
    }

    @Override
    public void inserir(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public void atualizar(Long id, Hospital hospital) {
        Optional<Hospital> hospitalBd = hospitalRepository.findById(id);
        if (hospitalBd.isPresent()) {
           hospitalRepository.save(hospital);
        }
    }
    @Override
    public void deletar(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public Iterable<Medico> buscarMedicos(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        return hospital.get().getMedicos();
    }

}

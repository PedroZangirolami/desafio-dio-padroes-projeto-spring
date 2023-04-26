package com.pedro.labpadroesprojetospring.service.impl;

import com.pedro.labpadroesprojetospring.Model.Endereco;
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
        salvarMedico(medico);
    }

    @Override
    public void atualizar(Long id, Medico medico) {
        Optional<Medico> medicoBd = medicoRepository.findById(id);
        if (medicoBd.isPresent()) {
            salvarMedico(medico);
        }
    }

    @Override
    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }
    private void salvarMedico(Medico medico) {
        medico.setEndereco(adicionarEndereco(medico));
        medico.setHospital(adicionalHospital(medico));

        // Inserir medico, vinculando o Endereco (novo ou existente). e o hospital que ele trabalha
        medicoRepository.save(medico);
    }

    private Hospital adicionalHospital(Medico medico){
        Optional<Hospital> hospital = hospitalRepository.findById(medico.getIdHospital());
        return hospital.get();
    }

    private Endereco adicionarEndereco(Medico medico){
        // Verificar se o Endereco do medico já existe (pelo CEP).
        String cep = medico.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        return endereco;
    }
}

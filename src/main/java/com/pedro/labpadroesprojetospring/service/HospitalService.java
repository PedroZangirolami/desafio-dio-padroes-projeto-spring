package com.pedro.labpadroesprojetospring.service;

import com.pedro.labpadroesprojetospring.Model.Hospital;
import com.pedro.labpadroesprojetospring.Model.Medico;

public interface HospitalService {

    Iterable<Hospital> buscarTodos();

    Hospital buscarPorId(Long id);

    void inserir(Hospital cliente);

    void atualizar(Long id, Hospital cliente);

    void deletar(Long id);

}

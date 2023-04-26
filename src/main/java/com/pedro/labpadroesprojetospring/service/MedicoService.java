package com.pedro.labpadroesprojetospring.service;

import com.pedro.labpadroesprojetospring.Model.Medico;

public interface MedicoService {
    Iterable<Medico> buscarTodos();

    Medico buscarPorId(Long id);

    void inserir(Medico cliente);

    void atualizar(Long id, Medico cliente);

    void deletar(Long id);

}

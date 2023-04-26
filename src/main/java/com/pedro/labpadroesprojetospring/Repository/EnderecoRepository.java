package com.pedro.labpadroesprojetospring.Repository;

import com.pedro.labpadroesprojetospring.Model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}

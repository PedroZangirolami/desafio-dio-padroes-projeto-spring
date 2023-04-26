package com.pedro.labpadroesprojetospring.Repository;

import com.pedro.labpadroesprojetospring.Model.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {
}

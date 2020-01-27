package com.hms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hms.model.Hospital;

@Repository
@Component
public interface HospitalRepository extends CrudRepository<Hospital, Integer> {

}

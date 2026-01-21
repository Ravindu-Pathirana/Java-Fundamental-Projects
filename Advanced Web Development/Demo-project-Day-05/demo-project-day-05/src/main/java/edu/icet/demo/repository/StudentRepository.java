package edu.icet.demo.repository;

import edu.icet.demo.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository <StudentEntity,Integer> {

}

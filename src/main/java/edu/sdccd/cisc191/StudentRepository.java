package edu.sdccd.cisc191;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
/**
 * (MODULE 8) Databases
 * Converting persistent serialized objects from disk to database by using Spring JPA annotations.
 */
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> { }

package edu.sdccd.cisc191;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * (8)
 */
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
    List<StudentEntity> findBySSID(String SSID);
    StudentEntity findByLastName(String lastName);
}

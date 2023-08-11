package edu.sdccd.cisc191;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * (MODULE 8) Databases
 * Converting persistent serialized objects from disk to database by using Spring JPA annotations.
 */
@SpringBootApplication
public class ReadStudents {
    public static final Logger log = LoggerFactory.getLogger(ReadStudents.class);
    public static void main(String[] args)
    {
        SpringApplication.run(ReadStudents.class, args);
    }
    @Bean
    public CommandLineRunner readDemo(StudentRepository studentRepository)
    {
        return (args) ->
        {
            log.info("All Students: ");
            Iterable<StudentEntity> allStudentEntities = studentRepository.findAll();
            for (StudentEntity studentEntity: allStudentEntities)
            {
                String lastName = studentEntity.getLastName();
                String SSID = studentEntity.getSSID();
                log.info("STUDENT: " + lastName + "  (" + SSID + ")");
            }
        };
    }
}

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
public class InsertStudents
{
    public static final Logger log = LoggerFactory.getLogger(InsertStudents.class);
    public static void main(String[] args)
    {
        SpringApplication.run(InsertStudents.class, args);
    }
    @Bean
    public CommandLineRunner insertDemo(StudentRepository studentRepository)
    {
        return (args) ->
        {
            studentRepository.save(new StudentEntity("1234", "John", "Doe", 4.0));
            studentRepository.save(new StudentEntity("2345", "Jane","Smith", 3.9));
            studentRepository.save(new StudentEntity("3456", "Richard","Roe", 3.8));
            studentRepository.save(new StudentEntity("4567", "Jo","Poe", 3.7));
            log.info("STUDENT(S) SAVED.");
        };
    }
}

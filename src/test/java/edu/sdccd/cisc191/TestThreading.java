package edu.sdccd.cisc191;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 * (9)
 */
class TestThreading
{
    @Test
    void testHighschool() throws OutOfStockException
    {
        Highschool highschool = new Highschool();
        StudentConcurrency s1 = new StudentConcurrency();
        assertEquals(0, highschool.getNumberOfStudentsEnrolled());
        highschool.receive(s1);
        assertEquals(1, highschool.getNumberOfStudentsEnrolled());
        assertEquals(s1, highschool.ship());
        assertEquals(0, highschool.getNumberOfStudentsEnrolled());
        StudentConcurrency s2 = new StudentConcurrency();
        StudentConcurrency s3 = new StudentConcurrency();
        highschool.receive(s2);
        highschool.receive(s3);
        assertEquals(2, highschool.getNumberOfStudentsEnrolled());
        assertEquals(s3, highschool.ship());
        assertEquals(s2, highschool.ship());
        assertEquals(0, highschool.getNumberOfStudentsEnrolled());
        assertThrows(OutOfStockException.class, () -> { highschool.ship(); });
    }
    @Test
    void testProducingSequentially()
    {
        Highschool school = new Highschool();
        int numberOfEnrollers = 5;
        int numberOfStudentsPerEnroller = 5;
        Enroll[] enroll = new Enroll[numberOfEnrollers];
        for (int i = 0; i < numberOfEnrollers; i++) { enroll[i] = new Enroll("Enroller " + i, school, numberOfStudentsPerEnroller); }
        for (int i = 0; i < numberOfEnrollers; i++) { enroll[i].run(); }
        assertEquals(numberOfEnrollers * numberOfStudentsPerEnroller, school.getNumberOfStudentsEnrolled());
    }
    @Test
    void testConsumingConcurrently() throws InterruptedException
    {
        Highschool school = new Highschool();
        int numberOfConsumers = 5;
        int numberOfItemsPerConsumer = 5;
        int numberOfItemsToProduce = numberOfConsumers * numberOfItemsPerConsumer;
        new Enroll("Enroll A", school, numberOfItemsToProduce).run();
        assertEquals(numberOfItemsToProduce, school.getNumberOfStudentsEnrolled());
        Farewell[] consumers = new Farewell[numberOfConsumers];
        for (int i = 0; i < numberOfConsumers; i++) { consumers[i] = new Farewell("Farewell " + i, school, numberOfItemsPerConsumer); }
        for (int i = 0; i < numberOfConsumers; i++) { consumers[i].start(); }
        for (int i = 0; i < numberOfConsumers; i++) { consumers[i].join(); }
        assertEquals(0, school.getNumberOfStudentsEnrolled());
    }
    @Test
    void testProducingConsumingConcurrently() throws InterruptedException
    {
        Highschool school = new Highschool();
        int numberOfProducers = 10000;
        int numberOfItemsPerProducer = 10;
        Enroll[] producers = new Enroll[numberOfProducers];
        for (int i = 0; i < numberOfProducers; i++) { producers[i] = new Enroll("Enroll " + i, school, numberOfItemsPerProducer); }
        int numberOfConsumers = numberOfProducers;
        int numberOfItemsPerConsumer = numberOfItemsPerProducer;
        Farewell[] consumers = new Farewell[numberOfConsumers];
        for (int i = 0; i < numberOfConsumers; i++) { consumers[i] = new Farewell("Consumer " + i, school, numberOfItemsPerConsumer); }
        for (int i = 0; i < numberOfProducers/2; i++) { producers[i].start(); }
        for (int i = 0; i < numberOfConsumers/2; i++) { consumers[i].start(); }
        for (int i = numberOfProducers/2; i < numberOfProducers; i++) { producers[i].start(); }
        for (int i = numberOfConsumers/2; i < numberOfConsumers; i++) { consumers[i].start(); }
        for (int i = 0; i < numberOfProducers; i++) { producers[i].join(); }
        for (int i = 0; i < numberOfConsumers; i++) { consumers[i].join(); }
        assertEquals(0, school.getNumberOfStudentsEnrolled());
    }
}
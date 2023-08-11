package edu.sdccd.cisc191;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
/**
 * (MODULE 4) I/O Streams
 */
class ServerClientTest {
    private Server server;
    private Client client;
    @Before
    public void setUp() {
        server = new Server();
        client = new Client();
    }
    @After
    public void tearDown() throws IOException {
        server.stop();
        client.disconnect();
    }
    @Test
    public void testClientServerCommunication() throws IOException, ClassNotFoundException {
        Thread serverThread = new Thread(() -> {
            try { server.start(1111); }
            catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
        });
        serverThread.start();
        Thread clientThread = new Thread(() -> {
            try {
                client.connect("localhost", 1111);
                StudentRequest request = new StudentRequest(12345);
                client.sendRequest(request);
                StudentResponse response = client.receiveResponse();
                assertEquals(12345, response.getSSID());
                assertEquals("Doe", response.getLastName());
                assertEquals("John", response.getFirstName());
                client.disconnect();
            } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
        });
        clientThread.start();
        try {
            serverThread.join();
            clientThread.join();
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
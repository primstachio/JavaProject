package edu.sdccd.cisc191;
import java.io.*; // Exception, Input, Output
import java.net.*; // Socket
/**
 * (4)
 * Client connects to the server and sends a StudentRequest.
 * Receives the StudentResponse from the server.
 * Received response is printed to client.
 */
public class Client
{
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    /*
    * Establishes connection to server.
    * Creates socket and connects to server at specified host and port.
    * Creates object streams to send and receive objects over socket.
    * Creates StudentRequest object with specified year value and sends to server.
    * Receives response from server in a loop.
    * Checks if received object is an instance of StudentResponse and casts object.
    */
    public void connect(String hostname, int port) throws IOException
    {
        socket = new Socket(hostname, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        StudentRequest request = new StudentRequest(12345);
        oos.writeObject(request);
        oos.flush();
        try
        {
            Object object = ois.readObject();
            if (object instanceof StudentResponse)
            {
                StudentResponse response = (StudentResponse) object;
                System.out.println(response);
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    // Disconnects from server and closes connections.
    public void disconnect() throws IOException
    {
        ois.close();
        oos.close();
        socket.close();
    }
    // Entry point of client application and connects to server at host: 1111.
    public static void main(String[] args)
    {
        Client client = new Client();
        try
        {
            client.connect("localhost", 1111);
            client.disconnect();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
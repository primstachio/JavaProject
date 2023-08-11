package edu.sdccd.cisc191;
import java.io.*; // Exception, Input, Output
import java.net.*; // Socket
/**
 * (MODULE 4) I/O Streams
 * Save objects from application in serialized format on disk and load them up on start.
 */
public class Client
{
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
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
    public void disconnect() throws IOException
    {
        ois.close();
        oos.close();
        socket.close();
    }
    public void sendRequest(StudentRequest request) throws IOException {
        oos.writeObject(request);
        oos.flush();
    }
    public StudentResponse receiveResponse() throws IOException, ClassNotFoundException {
        Object object = ois.readObject();
        if (object instanceof StudentResponse) { return (StudentResponse) object; }
        return null;
    }
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
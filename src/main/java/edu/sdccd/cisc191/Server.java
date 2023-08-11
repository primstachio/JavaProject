package edu.sdccd.cisc191;
import java.io.*; // Exception, Input, Output
import java.net.*; // ServerSocket, Socket
/**
 * (MODULE 4) I/O Streams
 * Save objects from application in serialized format on disk and load them up on start.
 */
public class Server
{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    public void start(int port) throws IOException, ClassNotFoundException
    {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        oos = new ObjectOutputStream(clientSocket.getOutputStream());
        ois = new ObjectInputStream(clientSocket.getInputStream());
        while (true)
        {
            Object object = ois.readObject();
            if (object instanceof StudentRequest)
            {
                StudentRequest request = (StudentRequest) object;
                StudentResponse response = processRequest(request);
                oos.writeObject(response);
                oos.flush();
            }
            else
            {
                break;
            }
        }
    }
    private StudentResponse processRequest(StudentRequest request)
    {
        int SSID = request.getSSID();
        String lastName = "Doe";
        String firstName = "John";
        return new StudentResponse(SSID, lastName, firstName);
    }
    public void stop() throws IOException
    {
        ois.close();
        oos.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args)
    {
        Server server = new Server();
        try
        {
            server.start(1111);
            server.stop();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

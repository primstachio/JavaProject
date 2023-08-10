package edu.sdccd.cisc191;
import java.io.*; // Exception, Input, Output
import java.net.*; // ServerSocket, Socket
/**
 * (4) I/O Streams
 * Server listens for incoming connections on specified port.
 * Accepts StudentRequest object from client.
 * Processes request by creating StudentResponse with fixed first and last name values.
 * Returns information back to client.
 */
public class Server
{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    /*
    * Starts server and listens on the specified port.
    * Creates server socket to listen on specified port.
    * Accepts client connection.
    * Creates object streams to send and receive objects over socket.
    * Processes incoming requests in a loop.
    * Checks if object is an instance of StudentRequest and casts object to StudentRequest.
    * Loop breaks of incoming object is not of type StudentRequest.
    */
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
    // Process VehicleRequest and generate VehicleResponse.
    private StudentResponse processRequest(StudentRequest request)
    {
        int SSID = request.getSSID();
        String lastName = "Doe";
        String firstName = "John";
        return new StudentResponse(SSID, lastName, firstName);
    }
    // Stops server and closes server-client connections.
    public void stop() throws IOException
    {
        ois.close();
        oos.close();
        clientSocket.close();
        serverSocket.close();
    }
    // Entry point of server application and starts server on port 1111.
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

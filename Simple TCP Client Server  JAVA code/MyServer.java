import java.net.*;
import java.io.*;

//Simple TCP Server

public class MyServer{
  public static void main(String[] args) throws IOException {
     
     ServerSocket listener = new ServerSocket(9090);
  
     System.out.println("Waiting for client on port " + listener.getLocalPort() + "...");
                
     Socket socket = listener.accept();
     System.out.println("Just connected to " + socket.getRemoteSocketAddress());
                
     //To receive message from client
     DataInputStream dis=new DataInputStream(socket.getInputStream());  
     System.out.println("Message Recevied from Client: " + dis.readUTF());
                
     // To send message back to the client                   
     DataOutputStream out = new DataOutputStream(socket.getOutputStream());
     out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress() + "\nGoodbye!");
     socket.close();
  
  }
                                           
}
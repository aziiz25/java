import java.io.*;
import java.net.*;
import java.util.Scanner; 

//Simple TCP Client

public class MyClient {

  public static void main(String[] args) throws IOException {
  
        Socket socket = new Socket("127.0.0.1", 9090);
      
        // Send message to server.
        DataOutputStream dout=new DataOutputStream(socket.getOutputStream());  
		Scanner in = new Scanner(System.in);            
		System.out.print("Enter message for Server: "); 
        String msg = in.nextLine(); 
        dout.writeUTF(msg);  // sends message to the socket

        // Receive message from server
        DataInputStream in2 = new DataInputStream(socket.getInputStream());
        System.out.println("Server says " + in2.readUTF());
        
        socket.close(); 
    }
}
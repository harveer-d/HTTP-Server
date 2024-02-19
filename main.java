import java.io.IOException; 
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/** 
 * Java program to create a simple HTTP Server to demonstrate how to use * ServerSocket and Socket class.
 * The program will user serversocket to create a new HTTP server at port 8080 and will send today's date 
 * Use http://localhost:8080 in firefox to test
*/

public class main {
    public static void main(String[] args) throws IOException { 

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ...."); 
        while (true){ 
            try (Socket socket = server.accept()) { 
                Date today = new Date(); 
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today; 
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8")); 
            }
        } 
    }

}
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class TCPClient {
    public static void main(String args[]) {
        Socket socket = null;

        PrintWriter out = null;
        BufferedReader in = null;
        //System.setProperty("line.separator", "\r\n"); // Mac users only

        String address = "127.0.0.1";
        int port = 20;

// Establish 2-way connection
        System.out.println("Will establish 2-way connection with " + address + ":" + port); // DEBUG
        try {
            socket = new Socket(address, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (UnknownHostException e) {
            System.out.println("Unknown host");
            System.exit(-1);
        }
        catch  (IOException e) {
            System.out.println("No I/O");
            System.exit(-1);
        }
// Connection was established
        System.out.println("Connection was established"); // DEBUG
//        System.exit(-1);

// Communicate in accordance to protocol
        try {
// Send request
            System.out.println("Will send request"); // DEBUG
            //while((line = in.readLine()) != null)
            //{

            out.println("Bonjour!");
            System.out.println(in.readLine());
            out.println("COUNT 23 45");
            System.out.println(in.readLine());
            out.println("DIVISIBLE 45");
            System.out.println(in.readLine());
            out.println("FINISH");
           // out.println("GET / HTTP/1.1" + "\r\n" + "Host: " + address + "\r\n\r\n");
// Request was sent
            System.out.println("Request was sent"); // DEBUG
//          System.exit(-1);

// Receive response
            System.out.println("Will receive response"); // DEBUG

            //}
        }
        catch (IOException e) {
            System.out.println("Error during communication");
            System.exit(-1);
        }
// Response was received
        System.out.println("Response was received"); // DEBUG

// Close connection
        System.out.println("Will close connection with server"); // DEBUG
        try {
            socket.close();
        }
        catch (IOException e) {
            System.out.println("Cannot close the socket");
            System.exit(-1);
        }
// Connection was closed
        System.out.println("Connection was closed"); // DEBUG

        System.out.println("Bye, bye...");
    }
}

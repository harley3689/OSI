import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        try(Socket socket = new Socket()){
         socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),port),3000);
         Scanner input = new Scanner(socket.getInputStream());
         PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
         output.println(InetAddress.getLoopbackAddress());

         while (input.hasNextLine()){
             System.out.println(input.nextLine());
         }

        }
    }
}

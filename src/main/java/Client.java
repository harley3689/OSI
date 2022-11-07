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
         Scanner scan = new Scanner(socket.getInputStream());
         while (scan.hasNextLine()){
             System.out.println(scan.nextLine());
         }
        }
    }
}

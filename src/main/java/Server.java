import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port);) {
            try (Socket socket = server.accept()) {
                Scanner input = new Scanner(socket.getInputStream()); //пришла инф
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true); //ушла инф

                while(input.hasNextLine()) {
                    output.println("New connection accepted!");
                    String str = input.nextLine();
                    out.println("connect:\t"+str);
                    output.println(String.format("Hi,%s, your port is %d", str, socket.getLocalPort()));
                }
            }
        }
    }
}


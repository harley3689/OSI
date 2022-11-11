import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = server.accept();
                     Scanner input = new Scanner(socket.getInputStream());
                     PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                    output.println("Connect accepted!");
                    String str = input.nextLine();
                    out.println("New string from client:\t" + str + "\tport:" + socket.getLocalPort());
                    output.println(String.format("Hi,%s, your port is %d", str, socket.getLocalPort()));
                }
            }
        }
    }
}



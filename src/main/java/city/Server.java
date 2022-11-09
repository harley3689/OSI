package city;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String actual = null;
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port);) {
            while (true) {
                try (Socket socket = server.accept();
                     BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {
                    System.out.println("Connect:\t"+socket.isConnected()+"\t"+socket.getLocalAddress());
                    String in = null;

                    if (actual==null) {
                        output.println("???");
                        in = input.readLine();
                        output.println("Ok");
                        actual = in;
                    } else {
                        output.println(actual);
                        in = input.readLine();
                        if (actual.toLowerCase().charAt(actual.length() - 1) == in.toLowerCase().charAt(0)) {
                            actual = in;
                            output.println("Ok");
                        } else {
                            output.println("Don't");
                        }
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Don't start Server!");
        }
    }
}


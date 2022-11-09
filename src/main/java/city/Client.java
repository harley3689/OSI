package city;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

public class Client {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int port = 8080;

        while (true) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String in = input.readLine();

                if (in.equals("???")) {
                    out.println("Enter City:");
                } else {
                    out.println("actual City:" + in);
                    out.println("Enter City with a letter:" + in.toLowerCase().charAt(in.length() - 1));
                }
                String out = scan.nextLine();
                output.println(out);
                in = input.readLine();

                if (in.equals("Ok")) {
                    System.out.println("Game continue:");
                    continue;
                }
                if (in.equals("Don't")) {
                    System.out.println(in);
                }
            }
        }
    }
}

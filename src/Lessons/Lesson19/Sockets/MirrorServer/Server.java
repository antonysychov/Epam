package Lessons.Lesson19.Sockets.MirrorServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(7777, 5); //(ограничение на количество клиентов)
        while (true) {
            Socket client = s.accept();
            ClientHandler c = new ClientHandler(client);
            c.start();
        }
    }
}

class ClientHandler extends Thread {
    Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = client.getInputStream();
            out = client.getOutputStream();
            byte[] mas = new byte[1024];
            int count = in.read(mas);
            String message = new String(mas, 0, count);
            message += " answer";
            out.write(message.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}


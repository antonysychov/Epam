package Lessons.Lesson19.Sockets.MirrorServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getByName("127.0.0.1"), 7777);
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        String message = "Hello Server";

        os.write(message.getBytes());
        byte[] nas = new byte[1024];
        int count = is.read(nas);
        String answer = new String(nas, 0, count);
        System.out.println(answer);
        is.close();
        os.close();
        s.close();
    }
}

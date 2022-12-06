import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Socket Server:");
        int PORT = 12345;

        try {
            ServerSocket server = new ServerSocket(PORT);

            Socket socket = server.accept();

            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            // String msg = dis.readUTF();
            // System.out.println(msg);
            // socket.close();
            String fromClient = dis.readUTF();
            while(!fromClient.equalsIgnoreCase("close") && fromClient != null) {
                System.out.println("Received msg from client:" + fromClient);
                fromClient = dis.readUTF();
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }
}
package com.company.file_transfer;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(48123);
            System.out.println("start listen");

            Socket socket = server.accept();
            receiveFile(socket);

        } catch (Exception e) {

        }

    }


    public static void receiveFile(Socket socket) throws IOException {
        DataInputStream dis = null;
        FileOutputStream fos = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            File file = new File("src/com/company/file_transfer/bfile");
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            fos = new FileOutputStream(file, true);
            byte[] buf = new byte[1024];
            int len = 0;
            int offset = 0;
            while ((len = dis.read(buf)) > 0) {
                System.out.println(new String(buf, 0, len));
                fos.write(buf, 0, len);
                fos.flush();
            }
        } finally {
            if (dis != null) {
                dis.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}

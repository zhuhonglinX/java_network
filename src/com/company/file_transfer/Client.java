package com.company.file_transfer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        DataOutputStream dos = null;
        FileInputStream fis = null;
        try {
            File file = new File("src/com/company/file_transfer/afile");
            socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", 48123));
            dos = new DataOutputStream(socket.getOutputStream());
            fis = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) > 0) {
                dos.write(buf, 0, len);
                dos.flush();
            }

        } catch (Exception e) {
            System.out.println("client file transfer error");
        } finally {
            if (dos != null) {
                dos.close();
            }
            if (fis != null) {
                fis.close();
            }
            if (socket != null) {
                socket = null;
            }
        }
    }
}

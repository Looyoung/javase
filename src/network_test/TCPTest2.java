package network_test;


import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// TCP编程测试二：客户端给服务端发送信息，服务端将信息打印到控制台上，同时发送“已收到信息”给客户端
public class TCPTest2 {
    // 客户端
    @Test
    public void Client() {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 6888);
            outputStream = socket.getOutputStream();
            outputStream.write("我是客户端。。。".getBytes());
            //shutdownOutput():执行此方法，显式的告诉服务端发送完毕！ 在流末端添加标志 -1
            //虽然在大多数的时候可以直接使用Socket类或输入输出流的close方法关闭网络连接，
            // 但有时我们只希望关闭OutputStream或InputStream，而在关闭输入输出流的同时，
            // 并不关闭网络连接。这就需要用到Socket类的另外两个方法：shutdownInput和shutdownOutput，
            // 这两个方法只关闭相应的输入、输出流，而它们并没有同时关闭网络连接的功能。
            socket.shutdownOutput();
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[128];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                String string = new String(bytes, 0, len);
                System.out.print(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(6888);
            s = ss.accept();
            is = s.getInputStream();
            byte[] b = new byte[128];
            int len;
            while ((len = is.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.print(str);
            }
            os = s.getOutputStream();
            os.write("服务端已接收到您的信息。。".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

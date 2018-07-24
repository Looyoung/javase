package network_test;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

// TCP编程测试三：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接。
// 如下的程序，处理异常时，要使用try-catch-finally!! 本例仅为了方便 ~~~
public class TCPTest3 {
    @Test
    public void Client() throws Exception {
        // 创建 socket 对象
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 6888);
        // 从本地获取一个文件发送给服务端
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\Louis\\Pictures\\Saved Pictures\\eclipse.jpg"));
        byte[] b = new byte[1024];
        int len;
        while ((len = fileInputStream.read(b)) != -1) {
            outputStream.write(b, 0, len);
        }
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] b1 = new byte[1024];
        int len1;
        while ((len1 = inputStream.read(b1)) != -1) {
            String str = new String(b1, 0, len1);
            System.out.print(str);
        }
        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        socket.close();
    }

    @Test
    public void server() throws Exception {
        //1.创建一个ServerSocket的对象
        ServerSocket serverSocket = new ServerSocket(6888);
        //2.调用其accept()方法，返回一个Socket的对象
        Socket socket = serverSocket.accept();
        //3.将从客户端发送来的信息保存到本地
        InputStream is = socket.getInputStream();
        File file = new File("eclipse.jpg");
        if (file.exists()) {
            file = new File(file.getName().split("\\.")[0] + "-副本."
                    + file.getName().split("\\.")[1]);  // eclipse-副本.jpg
        }
        FileOutputStream fos = new FileOutputStream(file);
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        System.out.println("收到来自于" + socket.getInetAddress().getHostAddress() + "的文件");
        //4.发送"接收成功"的信息反馈给客户端
        OutputStream os = socket.getOutputStream();
        os.write("你发送的图片我已接收成功！".getBytes());
        //5.关闭相应的流和Socket及ServerSocket的对象
        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}

package network_test;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP 实现发送端发送数据，接收端接收数据。
 */
public class UDPTest {

    // 发送端
    @Test
    public void send() {
        DatagramSocket datagramSocket = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            datagramSocket = new DatagramSocket();
            byte[] bytes = "你好呀！！".getBytes();
            // 创建一个数据报，每一个数据报不能大于64K，都记录着数据信息，发送端的ip、端口号，
            // 以及要发送到的接收端的ip，端口号
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, inetAddress, 6888);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }

    // 接收端
    @Test
    public void receive() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(6888);
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            A:
            while (true) {
                datagramSocket.receive(datagramPacket);
                String aString = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                if (aString.equals("886")) {
                    System.out.println(aString);
                    break A;
                } else {
                    System.out.println(aString);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}

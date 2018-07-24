package network_test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 网络通信的第一个要素：IP地址。通过IP地址，唯一的定位互联网上一台主机
 * InetAddress:位于java.net包下
 * 1.InetAddress用来代表IP地址。一个InetAdress的对象就代表着一个IP地址
 * 2.如何创建InetAddress的对象：getByName(String host)
 * 3.getHostName(): 获取IP地址对应的域名
 *   getHostAddress():获取IP地址
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress);  // www.baidu.com/14.215.177.39
            // 获取对象所含域名
            System.out.println(inetAddress.getHostName()); // www.baidu.com/14.215.177.39
            // 获取对象所含 ip 地址
            System.out.println(inetAddress.getHostAddress());  // 14.215.177.39
            // 获取本机域名和 ip 地址
            InetAddress inetAddress1 = InetAddress.getLocalHost();
            System.out.println(inetAddress1);  // LAPTOP-UKSNO6IO/192.168.1.211
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

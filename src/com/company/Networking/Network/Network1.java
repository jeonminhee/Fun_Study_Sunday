package com.company.Networking.Network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Network1 {

    public static void main(String[] args) {

        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try{

            ip = InetAddress.getByName("www.naver.com"); // 도메인명(host)를 통해 IP주소를 얻는다.
            System.out.println("getHostName() : " + ip.getHostName()); // 호스트의 이름을 반환한다.
            System.out.println("getHostAddress() : " + ip.getHostAddress()); // 호스트의 IP주소를 반환한다.
            System.out.println("toString() = " + ip.toString());

            byte[] ipAddr = ip.getAddress(); // IP주소를 byte 배열로 반환한다.
            System.out.println("getAddress : " + Arrays.toString(ipAddr));

            String result = "";
            for(int i = 0; i < ipAddr.length; i++){
                System.out.println("ipAddr = " + ipAddr[i]);
                result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
                result += ".";
            }
            System.out.println("getAddress() + 256 : " + result);
            System.out.println();
            /*
            * ip의 범위는 0~255이다. 그러나 byte의 범의는 -128~127로 범위가 다르기 때문에 값을 보정해주어야한다.
            * 0부터 127까지는 동일하고 음수일때만 보정해주면된다. 예를들어 -128은 128로 바뀌어야하기 때문에 -128에 256더해주면 된다..
            * */

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("getHostName() : " + ip.getHostName());
            System.out.println("getHostAddress() : " + ip.getHostAddress());
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com"); // 도메인명(host)에 지정된 모든 호스트의 IP주소를 배열에 담아 반환한다.

            for(int i = 0; i < ipArr.length; i++){
                System.out.println("ipArr[" + i + "] : " + ipArr[i]);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

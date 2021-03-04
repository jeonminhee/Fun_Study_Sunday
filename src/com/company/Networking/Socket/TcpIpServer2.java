package com.company.Networking.Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer2 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7777); // 서버 소켓을 생성하여 7777번 포트와 결합(bind)
            System.out.println(getTime() + "서버가 준비되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                // 서버소켓
                System.out.println(getTime() + "연결요청을 기다립니다.");
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

                System.out.println("getPort() : " + socket.getPort()); // 상대편 소켓(원격소켓)이 사용하는 포트, 사용가능한 임의의 포트가 선택된다.
                System.out.println("getLocalPort() : " + socket.getLocalPort()); // 자신이 사용하는 포트

                // 소켓의 출력스트림을 얻는다.
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격소켓(remote socket)에 데이터를 보낸다.
                dos.writeUTF("[Notice] Test Message1 from Server.");
                System.out.println(getTime() + "데이터를 전송헀습니다.");

                // 소켓과 스트림을 닫아준다.
                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } // main

    // 현재시간을 문자열로 반환하는 함수
    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
} // class

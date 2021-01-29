package com.company.IO;

import java.io.*;

public class SystemExam01 {
    public static void main(String[] args) throws IOException {
        // Scanner Class보다 BufferedReader를 실무에서 더 많이 사용함.
        // 처리 속도, 사용 메모리가 BufferedReader가 더 효율적이기 때문
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("이름을 입력해주세요");
        String name = bufferedReader.readLine();

        System.out.println("이름: " + name);
    }
}

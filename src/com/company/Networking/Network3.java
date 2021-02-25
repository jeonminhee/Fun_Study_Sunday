package com.company.Networking;

import java.net.URL;
import java.net.URLConnection;

public class Network3 {
    public static void main(String[] args) {
        URL url = null;
        // String address = "http://www.codechobo.com/sample/hello.html";
        String address = "https://www.eff.org/pages/blue-ribbon-campaign#intro";

        try {

            url = new URL(address);
            URLConnection conn = url.openConnection();

            System.out.println("conn.toString = " + conn);
            System.out.println("conn.getAllowUserInteraction() = " + conn.getAllowUserInteraction()); // 연결 된 곳에 사용자가 서버와 통신 할 수 있는 환경 확인(boolean)
            System.out.println("conn.getConnectTimeout() = " + conn.getConnectTimeout()); // 연결종료시간을 천분의 일초로 반환한다.
            System.out.println("conn.getContent() = " + conn.getContent()); // content객체를 반환한다.
            System.out.println("conn.getContentEncoding() = " + conn.getContentEncoding()); // content의 인코딩을 반환한다.
            System.out.println("conn.getContentLength() = " + conn.getContentLength()); // content의 크기를 반환한다.
            System.out.println("conn.getContentType() = " + conn.getContentType()); // content의 타입을 반환한다.
            System.out.println("conn.getDate() = " + conn.getDate()); // 헤더의 date필드의 값을 반환한다.
            System.out.println("conn.getDefaultUseCaches() = " + conn.getDefaultUseCaches()); // useCache의 디폴트값을 얻는다.
            System.out.println("conn.getDoInput() = " + conn.getDoInput()); // doInput필드값을 얻는다.
            System.out.println("conn.getDoOutput() = " + conn.getDoOutput()); // doOutput필드값을 얻는다.
            System.out.println("conn.getExpiration() = " + conn.getExpiration()); // 자원(URL)의 만료일자를 얻는다. (천분의 일초단위)
            System.out.println("conn.getHeaderField() = " + conn.getHeaderFields()); // 헤더에서 지정된 이름의 필드를 읽어온다.
            System.out.println("conn.getIfModifiedSince = " + conn.getIfModifiedSince()); // ifModifiedSince(변경여부)의 필드값을 반환한다.
            System.out.println("conn.getLastModified() = " + conn.getLastModified()); // LastModified(최종변경일)필드의 값을 반환한다.
            System.out.println("conn.getReadTimeout() = " + conn.getReadTimeout()); // 읽기제한시간의 값을 반환한다. (천분의 일초단위)
            System.out.println("conn.getURL() = " + conn.getURL()); // URLConnection의 URL을 반환한다.
            System.out.println("conn.getUseCaches() = " + conn.getUseCaches()); // 캐쉬의 사용여부를 반환한다.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

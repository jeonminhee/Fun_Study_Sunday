package com.company.Networking.Network;

import java.net.URL;

public class Network2 {

    public static void main(String[] args) throws Exception {
        // URL url = new URL("http://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1");
        URL url = new URL("https://www.eff.org/pages/blue-ribbon-campaign#intro");

        System.out.println("url.getAuthority() = " + url.getAuthority()); // 호스트명과 포트
        System.out.println("url.getContent() = " + url.getContent()); // URL과 Content 객체
        // 결과 형식 : sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@3941a79c
        System.out.println("url.getDefaultPort() = " + url.getDefaultPort()); // URL의 기본포트 (http는 80)
        System.out.println("url.getPort() = " + url.getPort()); // 포트를 반환, 포트번호가 명시되지않았을때 -1
        System.out.println("url.getFile() = " + url.getFile()); // 파일명을 반환, /sample/hello.html?referer=codechobo
        System.out.println("url.getHost() = " + url.getHost()); // 호스트명을 반환, www.codechobo.com
        System.out.println("url.getPath() = " + url.getPath()); // 경로명을 반환, /sample/hello.html
        System.out.println("url.getProtocol() = " + url.getProtocol()); // 프로토콜을 반환, http
        System.out.println("url.getQuery() = " + url.getQuery()); // 쿼리를 반환, referer=codechobo
        System.out.println("url.getRef() = " + url.getRef()); // 참조를 반환, #index1
        System.out.println("url.getUserInfo() = " + url.getUserInfo()); // 사용자정보를 반환, null
        System.out.println("url.toExternalForm() = " + url.toExternalForm()); // URL을 문자열로 변환하여 반환
        System.out.println("url.toURI() = " + url.toURI()); // URL을 URI로 변환하여 반환

    }
}

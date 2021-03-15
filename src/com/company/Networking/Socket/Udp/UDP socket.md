# UDP
## UDP 소켓 프로그래밍
> 특징
* UDP 소켓 프로그래밍은 ***DatagramSocket***, ***DatagramPacket*** 사용
    * TCP에서는 Socket과 ServerSocket 사용
    * 연결지향적인 프로토콜이 아니기 때문에 ServerSocket이 필요없다.
    * DatagramPacket에 데이터를 담아서 전송한다.
* DatagramPacket?
    * 헤더와 데이터로 구성
    * 헤더에는 DatagramPacekt을 수신할 호스트의 정보(호스트 주소, 포트)가 저장
    * 소포(Packet)에 수신할 상대편의 주소를 적어서 보내는 것과 같다.
    * DatagramPacket을 전송하면 D.P에 지정된 주소(호스트의 포트)의 DatagramSocket에 도착한다.
    
# IO

1.  IO란?

    - Input/Output 즉, 입출력을 구현하는 클래스와 인터페이스
    - java IO는 크게 byte 단위 입출력과, 문자 단위 입출력으로 나뉘어 진다
      - byte 단위 입출력의 경우, InputStream || OutputStream 추상 클래스를 상속
      - 문자(char)단위 입출력의 경우, Reader와 Writer라는 추상클래스를 상속
    - 생성자의 유무에 따라 어떻게 사용되는 클래스인지 확인 가능
    - InputStream, OutputStream, Reader, Writer 추상 클래스를 받아들이는 생성자가 있다면, 입출력 방법을 제공하는 클래스
    - InputStream, OutputStream, Reader, Writer 추상 클래스를 받아들이는 생성자가 없다면, 어떻게 입력받을지, 어떻게 출력할지를 나타내는 클래스

2.  Buffer

    - 데이터를 한 곳에서 다른 곳으로 전송하는 동안 일시적으로 데이터를 보관해주는 메모리 영역
    - 버퍼링(Buffering)은 버퍼를 활용하는 방식 또는 버퍼를 채우는 동작을 말함
    - 속도 차이가 큰 두 대상이 입출력을 수행할 때 효율성을 위해 사용하는 임시 저장공간
    - 데이터를 하나씩 가져와서 하나씩 처리하는 것 보다, 데이터를 모아뒀다 한꺼번에 처리하는 것이 더 빠르기 때문
    - 보조기억장치(HDD, SDD)가 데이터를 보내는 속도보다 CPU가 데이터를 처리하는 시간이 월등히 빠르기 때문에 데이터를 보냄과 동시에 데이터를 처리하게 된다면 오히려 처리 속도가 느려지므로 버퍼에 데이터를 쌓은 뒤 처리
    - 단, Buffer가 너무 크면 메모리의 낭비를 유발할 수 있음

3.  Decorator Pattern

    - 주어진 상황 및 용도에 따라 어떤 객체에 동적으로 기능을 부여해주는 패턴
    - 클래스 전체를 고칠 필요는 없으나, 객체에 추가 요소가 필요할 때 쓰임
    - 런타임 중 다양하게 기능 추가 가능(동적으로 기능을 부여하기 때문)
    - 데코레이터 패턴에는 장식 대상 클래스인 추상 데코레이터(Abstract Decorator)와 장식하는 클래스인 구상 데코레이터(Concrete Decorator)가 있다
    - FileInputStream, FileOutputStream, FileReader, FileWriter(파일에서 입력 받고 쓰기 위한 클래스들) & ByteArrayInputStream, ByteArrayOutputStream, CharReader, CharWriter(배열에서 입력 받고 쓰기 위한 클래스들)등의 어떤 대상을 지정할 수 있는 클래스들이 추상 데코레이터(Abstract Decorator)
    - DataInputStream, DataOutputStream() & PrintWriter() & BufferedReader()등의 입출력 하는 기능을 가진 클래스들이 구상 데코레이터(Concrete Decorator)

4.  byte 단위 입출력

    1.  ByteStream

        1.  Input/OutputStream

            - byte 단위 입력 스트림 중 최상위 추상 클래스
            - 추상 클래스이므로 직접 객체를 만들지 않고, 메소드를 상속하여 메소드를 호출해야 함
            - InputStream 클래스에는 하나의 바이트를 읽기 위한 read() 메소드가 있고, OutputStream에는 하나의 바이트를 출력하기 위한 write() 메소드가 있음
            - read 메소드는 byte가 아닌 int를 리턴하는데 읽을것이 있을 때에는 항상 양수를 리턴하며, 읽을것이 없으면 -1을 리턴
            - OutputStream에는 출력이 끝났음을 알려주기 위한 flush() 메소드도 있는데, 이는 버퍼에 쌓인 데이터를 보냄

        2.  FileInputStream/FileOutputStream

            - 파일로부터 byte단위로 읽어오는 객체를 FileInputStream, 파일에 출력하게 해주는 객체를 FileOutputStream이라 함
            - 생성자로 직접 File 객체를 줄 수도 있고, 파일의 이름을 String으로 줄 수도 있음
            - 버퍼를 사용하지 않을 경우, 1바이트씩 읽어들이며, 1바이트씩 저장함

    2.  Byte 보조 스트림

        1.  FilterInputStream / FilterOutputStream

            - FilterStream의 경우 데이터를 모아서 어떤 타입으로 변환함
            - 다른 Stream 객체를 생성인자로 받아 입출력시에 새로운 기능을 제공 (-> 새로운 기능은 어떤 객체를 받느냐에 따라 다름)

        2.  BufferedInputStream / BufferedOutputStream

            - FilterStream을 상속받아 실제 필터 기능을 제공하는 클래스
            - 1바이트 단위로 입출력이 일어날 경우 비효율적이기 때문에 내부적인 버퍼를 자동으로 발생시켜주므로 효율을 향상 시킬 수 있음
            - 사용자가 버퍼의 크기를 지정하지 않을 경우, Output은 512byte, Input은 2048byte의 크기를 가지고 있음

        3.  DataInputStream / DataOutputStream

            - FilterStream을 상속받아 실제 필터 기능을 제공하는 클래스
            - FilterStream을 사용할 경우, byte[]단위로만 입출력 할 수 있었으나 DataStream filter를 적용하면 자바의 기본 자료형 데이터로 입출력 할 수 있음

        4.  SequenceInputStream

            - 서로 다른 InputStream을 연결해주는 역할

        5.  PrintStream
            - 출력 장치에 상관 없이 편하고 쉽게 출력을 도와주는 클래스
            - 데이터를 다양한 형태로 출력할 수 있는 print(), println(), printf() 메소드를 오버로딩하여 제공
            - flush 기능을 자동으로 처리

5.  Char 단위 Stream

    1. Char 기반 Stream

       1. Reader/Writer

          - 16비트 문자나 문자열을 읽기 위한 스트림들의 최상위 추상 클래스
          - Reader의 read() 메소드의 경우, int를 리턴 하는데 메소드의 파라미터에 따라 어떤 값이 리턴되는지 정해짐
            - read(): 한 개의 문자(2바이트)를 읽고, 읽을 수 있으면 양수, 읽을 수 없으면 -1를 리턴
            - read(char[] cbuf): 매개값으로 주어진 문자열 배열의 길이만큼 문자를 읽고 배열에 저장한 뒤 읽은 문자 수를 리턴
            - read(char[] cbuf, int off, int len): len개의 문자를 읽고, 매개값으로 주어진 문자 배열의 off번째 인덱스부터 len개까지 저장한 후, 읽은 문자 수를 리턴
          - Writer
            - write(int c): c만큼의 글자 출력
            - write(char[] cbuf): cbuf의 내용 출력
            - write(char[] cbuf, int off, int len): cubf에서 off를 시작으로 len만큼 출력
            - write(String s): s의 내용 출력
            - write(String s, int off, int len): s에서 off를 시작으로 len만큼 출력
            - close(): 문자 출력 스트림을 닫음
            - flush(): 버퍼에 남은 출력 스트림을 내보냄

       2. FileReader / FileWriter

          - 파일에 저장된 바이트를 유니코드 문자로 변환하여 읽거나 출력 때 사용되는 클래스
          - 파일에 입력 또는 출력을 하기 위한 클래스이므로 파일 클래스 또는 파일 이름을 인자로 받음

       3. PipedReader / PipedWriter

          - thread간에 데이터를 주고 받으면서 스레드를 제어하는 것
          - PipedReader에서 문자열을 출력하면 PrpedWriter에서 읽을 수 있음
          - 두 스레드 사이에서 입출력을 하기 위해서는 두 스트림은 연결되어야 하는데, 생성자를 이용해 상대방 스트림을 연결하는 방법과 connect()메소드를 사용하는 방법이 있음

       4. StringReader / StringWriter
          - 문자열을 기반으로 입/출력 해주는 스트림
          - StringWriter에서 출력되는 데이터는 StringBuffer에 저장됨

    2. Char 기반의 보조 스트림

       1. InputStreamReader / OutputStreamReader

          - 문자(char)는 바이트 2개가 모여서 구성한 데이터이므로 byte와 char은 호환 가능
          - Input은 바이트 스트림을 문자 스트림으로, Output은 문자 스트림을 바이트 스트림으로 변환하는 입출력 스트림
          - 바이트를 읽어 생성자에 명시된 문자 인코딩에 따라 문자로 변환하는데 사용

       2. BufferedReader / BufferedWriter

          - 문자 입력 스트림으로부터 입출력을 할 때 내부에서 자동으로 버퍼를 적용해주는 클래스

6.  File

    - Java에서 파일이나 디렉터리를 다룰 수 있게 해주는 클래스
    - File 클래스의 다양한 생성자를 통해 파일을 나타내는 객체를 생성

7.  표준 입출력

    1. 표준 입출력이란

       - 입출력의 기본이 되는 것
       - java의 표준 입출력은 콘솔 화면에 입출력되어 콘솔 입출력이라고도 함
       - System.in, System.out, System.err을 이용해 표준 입력, 표준 출력, 표준 에러를 제공

    2. System Class

       - java는 JVM에서 실행되는 것 이므로 운영체제의 기능을 코드로 직접 접근하기 어려운데, 이 때 java.lang에 있는 System class를 사용하면 운영체제의 일부 기능을 사용할 수 있음
       - 프로그램 강제 종료(.exit()), 가비지 컬렉터 실행(gc()), 시스템 프로퍼티(시스템 속성값, 사용자 이름, 사용자의 홈 디렉토리 등) 읽기(.getProperty()), 환경변수 읽기(.getenv())등의 기능 사용 가능

       1. System.in

          - 표준 입력 스트림, 키보드로 입력 받음
          - InputStream 타입의 필드이므로, InputStream의 객체로도 사용 가능
          - 자료형이 InputStream이므로 byte단위로만 입출력 가능
          - Scanner class를 이용해 다양한 타입의 입력값을 읽어올 수 있음

       2. System.out

          - 표준 출력 스트림, 콘솔에 출력됨
          - PrintStream 타입의 필드
          - 예외를 안전하게 처리한 메소드로만 구성되어 있으므로 예외처리를 할 필요 없음

       3. System.err
          - 표준 에러 출력 장치
          - 일반적인 정상 출력은 System.out으로 나가고 에러는 System.err로 나감
          - PrintStream 타입의 필드

8.  직렬화

    1. 직렬화란?

       - 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에도 사용할 수 있도록 바이트(byte) 형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)
       - 객체들을 파일로 저장하거나 전송할 때 주로 사용

    2. 직렬화를 할 수 있는 조건

       1. 기본 자료형

          - 정해진 byte의 변수이기 때문에 byte로 변환하는데 문제가 없음
          - 하지만 객체의 크기는 가변적이며 객체를 구성하는 자료형의 종류와 수에 따라 객체의 크기가 다양하게 바뀔 수 있음

       2. Java.io.Serializable 인터페이스를 상속받은 객체

          - 객체의 맴버들 중 Serializable 인터페이스가 구현되지 않은 것이 존재해선 안 됨
          - transient가 선언된 변수는 전송되지 않음. 보통 패스워드와 같은 보안이 중요한 변수를 데이터에 보내지 않을 때 사용
          - Serializable 인터페이스를 구현하지 않으면서 transient가 선언된 변수는 데이터에 보내지지 않으며, 이 외의 Serializable 인터페이스를 구현하지 않은 객체가 있을 경우 직렬화 불가능
          - 변경에 취약하므로 자주 변경되는 클래스의 객체에는 직렬화를 사용하지 않는것이 좋음

       ```
       HubContent hubcontent = new HubContent("제목", "부제");
       byte[] serializedHubContent;
       try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
       try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
           oos.writeObject(hubContent);

           // 직렬화된 HubContent 객체
           serializedHubContent = baos.toByteArray();
       }
       }
       ```

    3. 역직렬화를 할 수 있는 조건

       - 직렬화 대상이 된 객체의 클래스가 ClassPath에 존재해야 하며, import 되어있어야 함
       - 자바 직렬화 대상 객체는 동일한 serialVersionUID 를 가지고 있어야 함
       - 다만, serialVersionUID를 직접 선언하지 않아도 내부적으로 클래스의 구조 정보를 이용해 자동으로 생성된 해쉬값이 할당됨
       - 클래스 멤버 변수가 추가되거나 삭제되면 serialVersionUID가 재설정 되어 기존의 serialVersionUID와 달라지므로 java.io.InvalidClassException 예외 발생
       - 가능한 serialVersionUID를 직접 관리해야 클래스의 맴버가 변경되어도 직렬화/역직렬화 가능하므로 직접 관리해주는게 좋음
       - 다만, serialVersionUID이 같다고 무조건 직렬/역직렬이 가능한 것은 아님
         - 클래스의 멤버 변수 타입이 다르면 타입 예외 발생
         - 멤버 변수를 제거하거나 변수명을 바꾸면 예외는 발생하지 않으나 데이터는 누락됨

       ```
       try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedHubContent)) {
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {

            // 역직렬화된 HubContent 객체를 읽어온다.
            Object objectHubContent = ois.readObject();
            HubContent hubContent = (HubContent) objectHubContent;
        }
        }
       ```

    4. 직렬화 방법

       1. CSV

          - 콤마(,)를 기준으로 데이터를 구분
          - 표 형태의 다양한 데이터를 직렬화 할 때 많이 쓰임

          ```
          Member member = new Member("judy", "judy@email.com", 28);
          // member객체를 csv로 변환
          String csv = String.format("%s,%s,%d",member.getName(), member.getEmail(), member.getAge());
          System.out.println(csv);
          ```

       2. JSON

          - key: value 방식으로 데이터를 구분
          - 자바스크립트에서 쉽게 사용할 수 있고, 다른 데이터 포맷 방식에 비해 오버헤드가 적어 많이 사용
          - 구조적인 데이터를 직렬화 할 때 많이 쓰임 (ex. API 데이터)

          ```
          Member member = new Member("judy", "judy@email.com", 28);
          // member객체를 json으로 변환
          String json = String.format(
              "{\"name\":\"%s\",\"email\":\"%s\",\"age\":%d}",
              member.getName(), member.getEmail(), member.getAge());
          System.out.println(json);
          ```

    5. 장단점
       1. 장점
          - 자바 시스템에서 개발에 최적화 되어있음.
          - 복잡한 데이터 구조라도 직렬화 조건만 지켜주면 큰 작업 없이 직렬화 사용 가능
          - 데이터 타입이 자동으로 맞춰지기 때문에 역직렬화시 기존 객체처럼 사용 가능
       2. 단점
          - 외부(DB, 캐시서버 등)에 장기간 저장될 정보라면 사용하지 않는게 좋음. 긴 시간동안 외부에 존재하는 직렬화 데이터는 가비지가 될 확률이 높으므로 언제 예외가 발생할지 모름
          - 개발자가 직접 컨트롤 하기 힘든 객체(프레임워크, 라이브러리 객체)에는 사용하지 않는게 좋음. 그러한 객체에 고유 serialVersionUID가 있는 경우가 있는데, 이 때 serialVersionUID의 관리가 힘듦
          - 변경에 취약함
          - 타입에 대한 정보, 클래스의 메타 정보 등 단순 데이터에 비해 많은 데이터를 가지고 있기 때문에 다른 포맷에 비해 용량이 큼

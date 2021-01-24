# IO

1.  IO란?

    - Input/Output 즉, 입출력을 구현하는 클래스와 인터페이스
    - java IO는 크게 byte 단위 입출력과, 문자 단위 입출력으로 나뉘어 진다
      - byte 단위 입출력의 경우, InputStream || OutputStream 추상 클래스를 상속
      - 문자(char)단위 입출력의 경우, Reader와 Writer라는 추상클래스를 상속
    - 생성자의 유무에 따라 어떻게 사용되는 클래스인지 확인 가능
    - InputStream, OutputStream, Reader, Writer 추상 클래스를 받아들이는 생성자가 있다면, 입출력 방법을 제공하는 클래스
    - InputStream, OutputStream, Reader, Writer 추상 클래스를 받아들이는 생성자가 없다면, 어떻게 입력받을지, 어떻게 출력할지를 나타내는 클래스

2.  Decorator Pattern

    - 주어진 상황 및 용도에 따라 어떤 객체에 동적으로 기능을 부여해주는 패턴
    - 클래스 전체를 고칠 필요는 없으나, 객체에 추가 요소가 필요할 때 쓰임
    - 런타임 중 다양하게 기능 추가 가능(동적으로 기능을 부여하기 때문)
    - 데코레이터 패턴에는 장식 대상 클래스인 추상 데코레이터(Abstract Decorator)와 장식하는 클래스인 구상 데코레이터(Concrete Decorator)가 있다
    - FileInputStream, FileOutputStream, FileReader, FileWriter(파일에서 입력 받고 쓰기 위한 클래스들) & ByteArrayInputStream, ByteArrayOutputStream, CharReader, CharWriter(배열에서 입력 받고 쓰기 위한 클래스들)등의 어떤 대상을 지정할 수 있는 클래스들이 추상 데코레이터(Abstract Decorator)
    - DataInputStream, DataOutputStream() & PrintWriter() & BufferedReader()등의 입출력 하는 기능을 가진 클래스들이 구상 데코레이터(Concrete Decorator)

3.  File

    - Java에서 파일이나 디렉터리를 다룰 수 있게 해주는 클래스
    - File 클래스의 다양한 생성자를 통해 파일을 나타내는 객체를 생성

4.  byte 단위 입출력

    1.  Input/OutputStream

        - byte 단위 입력 스트림 중 최상위 추상 클래스
        - 추상 클래스이므로 직접 객체를 만들지 않고, 메소드를 상속하여 메소드를 호출해야 함
        - InputStream 클래스에는 하나의 바이트를 읽기 위한 read() 메소드가 있고, OutputStream에는 하나의 바이트를 출력하기 위한 write() 메소드가 있음
        - read 메소드는 byte가 아닌 int를 리턴하는데 읽을것이 있을 때에는 항상 양수를 리턴하며, 읽을것이 없으면 -1을 리턴
        - OutputStream에는 출력이 끝났음을 알려주기 위한 flush() 메소드도 있는데, 이는 버퍼에 쌓인 데이터를 보냄

    2.  Buffer

        - 데이터를 한 곳에서 다른 곳으로 전송하는 동안 일시적으로 데이터를 보관해주는 메모리 영역
        - 버퍼링(Buffering)은 버퍼를 활용하는 방식 또는 버퍼를 채우는 동작을 말함
        - 속도 차이가 큰 두 대상이 입출력을 수행할 때 효율성을 위해 사용하는 임시 저장공간
        - 데이터를 하나씩 가져와서 하나씩 처리하는 것 보다, 데이터를 모아뒀다 한꺼번에 처리하는 것이 더 빠르기 때문
        - 보조기억장치(HDD, SDD)가 데이터를 보내는 속도보다 CPU가 데이터를 처리하는 시간이 월등히 빠르기 때문에 데이터를 보냄과 동시에 데이터를 처리하게 된다면 오히려 처리 속도가 느려지므로 버퍼에 데이터를 쌓은 뒤 처리
        - 단, Buffer가 너무 크면 메모리의 낭비를 유발할 수 있음

    3.  ByteStream

        1.  FileInputStream/FileOutputStream

            - 파일로부터 byte단위로 읽어오는 객체를 FileInputStream, 파일에 출력하게 해주는 객체를 FileOutputStream이라 함
            - 생성자로 직접 File 객체를 줄 수도 있고, 파일의 이름을 String으로 줄 수도 있음
            - 버퍼를 사용하지 않을 경우, 1바이트씩 읽어들이며, 1바이트씩 저장함

        2.  FilterInputStream / FilterOutputStream

            - FilterStream의 경우 데이터를 모아서 어떤 타입으로 변환함
            - 다른 Stream 객체를 생성인자로 받아 입출력시에 새로운 기능을 제공 (-> 새로운 기능은 어떤 객체를 받느냐에 따라 다름)

        3.  BufferedInputStream / BufferedOutputStream

            - FilterStream을 상속받아 실제 필터 기능을 제공하는 클래스
            - 1바이트 단위로 입출력이 일어날 경우 비효율적이기 때문에 내부적인 버퍼를 자동으로 발생시켜주므로 효율을 향상 시킬 수 있음
            - 사용자가 버퍼의 크기를 지정하지 않을 경우, Output은 512byte, Input은 2048byte의 크기를 가지고 있음

        4.  DataInputStream / DataOutputStream
            - FilterStream을 상속받아 실제 필터 기능을 제공하는 클래스
            - FilterStream을 사용할 경우, byte[]단위로만 입출력 할 수 있었으나 DataStream filter를 적용하면 자바의 기본 자료형 데이터로 입출력 할 수 있음

    4.  Char 단위 Stream

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

        2. InputStreamReader / OutputStreamReader

           - 문자(char)는 바이트 2개가 모여서 구성한 데이터이므로 byte와 char은 호환 가능
           - Input은 바이트 스트림을 문자 스트림으로, Output은 문자 스트림을 바이트 스트림으로 변환하는 입출력 스트림
           - 바이트를 읽어 생성자에 명시된 문자 인코딩에 따라 문자로 변환하는데 사용

        3. FileReader / FileWriter

           - 파일에 저장된 바이트를 유니코드 문자로 변환하여 읽거나 출력 때 사용되는 클래스
           - 파일에 입력 또는 출력을 하기 위한 클래스이므로 파일 클래스 또는 파일 이름을 인자로 받음

        4. BufferedReader / BufferedWriter
           - 문자 입력 스트림으로부터 입출력을 할 때 내부에서 자동으로 버퍼를 적용해주는 클래스

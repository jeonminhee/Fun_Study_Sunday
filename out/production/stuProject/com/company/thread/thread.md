# Thread

1. Thread?

   - 하나의 프로세스 내부에서 독립적으로 실행되는 하나의 작업 단위
   - 보통 하나의 프로세스는 한 가지 일을 하지만, 스레드를 이용하면 한 프로세스 내에서 두가지 이상의 일을 할 수 있다.

2. Thread 만들기

   1. Thread class를 상속하는 방법
      - java.lang.Thread 클래스를 상속한 뒤, run()을 Override
      -

      ```
      public class Test1 extends Thread {
          public void run() {
              System.out.println("RUNNING");
          }

          public static void main(String[] args) {
              Test1 test = new Test1();
              test.start();
          }
      }
      ```

   2. Runnable interface를 구현하는 방법

      - java.lang.Runnable interface를 구현(interface이기 때문에 run() 메소드를 구현해야 함)

      ```
      public class Test2 implements Runnable {
        @Override
        public void run() {
            System.out.println("RUNNING");
        }

        public static void main(String[] args) {
            Test2 test = new Test2();

            Thread t1 = new Thread(test);

            t1.start();
        }
      }
      ```

      - Thread를 상속받은게 아니기 때문에 start() 메소드가 없음 (Thread가 아님)
      - Thread를 생성한 뒤, 구현했던 클래스를 Thread 생성자에 넣어서 Thread를 생성해야 함
      - java는 다중상속을 지원하지 않으므로 다른 클래스를 상속받은 상태일 때, Runnable interface 구현

   3. Multi Thread

      - 하나의 객체를 여러개의 Thread가 사용할 수 있는데, 이 객체를 '공유 객체'라 함
      - 여러개의 Thread가 같은 데이터를 동시에 사용할 경우, 충돌이 일어나거나 데이터가 손상이 될 위험이 있음
      - 위와 같은 문제를 해결하기 위해 Thread를 동기화(하나의 Thread가 공유 객체를 사용할 때 다른 객체는 사용하지 못 하도록 하게끔) 작업이 필요

      1. 동기화 메소드

         - 동기화 할 메소드 return type 앞에 synchronized를 붙임

         ```
         public synchronized void method() {
             System.out.println("Synchronized Method!")
         }
         ```

         - 메소드 전체가 임계 영역이므로 Thread가 메소드를 실행하는 즉시 메소드에 접근할 수 없음

      2. 동기화 블록
         - 동기화 할 부분에 synchronized(공유 객체, 자기 자신일 경우 this 사용) {} 사용
         ```
         public void method() {
             System.out.println("method")
             synchronized(this){
                 System.out.println("block")
             }
         }
         ```
         - 메소드가 실행되는 속도가 느릴 경우, Thread의 대기 시간을 줄이기 위해 문제가 있는 부분만 사용할 수 있음

   4. Thread 상태

      1. Thread 생명 주기
         ![Thread 생명주기](./img/thread1.png)

      2. Thread 상태
         1. NEW
            - 생성
            - Thread가 생성된 상태
         2. RUNNABLE
            - 실행 대기
            - start()가 호출해 실행 대기중인 상태, run() 하면 RUNNING이 됨
         3. WAITING
            - 일시 정지
            - 다른 Thread의 통지를 기다림
         4. TIMED_WAITING
            - 일시 정지
            - 주어진 시간동안 대기
         5. BLOCKED
            - 일시 정지
            - 사용하려는 객체의 락이 풀릴때까지 대기
         6. TERMINATED
            - 종료
            - 실행 종료 후 소멸

   5. Thread 상태 제어

      1. start()
         - NEW에서 RUNNABLE로 보냄
      2. run()
         - RUNNABLE에서 RUNNING이 될 때, 이 메소드를 실행
      3. yield()
         - 우선권이 동일한 Thread에게 우선권 양보
         - RUNNING 상태에서 RUNNABLE 상태로 변환
      4. sleep()
         - 주어진 시간동안 TIMED_WAITING 상태로 변환
      5. join()
         - 다른 Thread와 같이 쓸 때 주로 사용
         - Thread가 멈출때까지 기다리게 함(BLOCKED 상태)
         - 기다리는 Thread의 작업이 끝나면 다시 실행 됨
      6. wait()
         - WAITING 상태로 만듦
         - notify() 될 때까지 waiting pool에서 기다림
         - Thread 동기화 후 사용
      7. notify()
         - WAITING 상태의 Thread 한 개를 RUNNABLE 상태로 변경
         - 어떤 Thread를 변경할지는 모름
      8. notifyAll()
         - WAITING 상태의 Thread 전부를 RUNNABLE 상태로 변경

   6. Demon Thread

      1. 데몬 스레드?
         - 리눅스와 같은 유닉스 계열의 운영체제에서 백그라운드로 동작하는 프로그램을 '데몬'이라 함
         - Thread에 데몬 설정을 하면 됨
         - 주 Thread를 돕는 보조적인 역할을 하는 스레드
         - Ex) 워드프로세스 자동저장, 가비지 컬렉터...
         - 주(일반) Thread가 종료되면 데몬 스레드는 자동으로 종료됨

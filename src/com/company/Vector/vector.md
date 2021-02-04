# Vector

1. Vector?

   - 가변적인 길이로 여러 데이터형을 저장하기 위해 사용하는 클래스
   - ArrayList와 동일한 내부 구조를 가지고 있음
   - List 인터페이스를 구현하기 때문에 저장순서를 유지하며, 중복을 허용한다는 특징을 가지고 있음
   - Vector를 선언할 때 타입을 지정하지 않고 임의의 타입의 값을 넣고 사용할 수도 있지만, 백터 내부의 값을 사용할 때 형변환을 해야 하는데, 이때 잘못된 타입으로 형변환시 문제가 생길 수 있으므로 Generic에 타입을 지정하는것을 추천

2. ArrayList와의 차이점

   - 가장 중요한 차이점은 <b>ArrayList는 동기화가 되어있지 않지만, Vector는 동기화가 되어있음</b>
   - ArrayList는 멀티 스레드에서 작업이 가능하지만 Vector는 싱글 스레드에서만 작업 가능
   - ArrayList는 배열의 최대 길이까지 왔을 때 길이가 50%씩 증가하지만, Vector는 2배씩 증가

3. 사용법

   1. Vector 선언

      ```
      Vector v = new Vector();//타입 미설정 Object로 선언된다.
      Vector<Student> student = new Vector<Student>(); //타입설정 Student객체만 사용가능
      Vector<Integer> num2 = new Vector<Integer>(); //타입설정 int타입만 사용가능
      Vector<Integer> num3 = new Vector<>(); //new에서 타입 파라미터 생략가능
      Vector<String> v2 = new Vector<String>(10);//초기 용량(capacity)지정
      Vector<Integer> v3 = new Vector<Integer>(Arrays.asList(1,2,3)); //초기값 지정
      ```

   2. 값 추가

      ```
      Vector<Integer> v = new Vector<Integer>();
      v.add(3); //값 추가
      v.add(null); //null값도 add가능
      v.add(1,10); //index 1뒤에 10 삽입

      Vector v = new Vector();
      Student student = new Student(name,age);
      v.add(student);
      v.add(new Member("홍길동",15));
      ```

      - 값 추가시 add(index, value) 메소드 사용
      - index 생략시 가장 끝 index에 값이 추가되며 index 중간에 값 추가시 해당 인덱스부터 마지막 인덱스까지 인덱스가 하나씩 늘어남

   3. 값 삭제

      ```
      Vector<Integer> v = new Vector<Integer>(Arrays.asList(1,2,3));
      v.remove(1);  //index 1 제거
      v.removeAllElements(); //모든 값 제거
      v.clear();  //모든 값 제거
      ```

      - 값을 삭제하려면 remove(index) 메소드 사용
      - remove(index) 메소드 사용시 바로 뒤에 있는 인덱스부터 맨 마지막 인덱스까지 인덱스가 하나씩 줄어듦
      - 모든 값을 제거하려면 removeAllElements() 메소드나 clear() 메소드 사용

   4. Vector 크기 구하기

      ```
      Vector<Integer> v = new Vector<Integer>(10);//초기용량 10
      v.add(1); //값 추가
      System.out.println(v.size()); //Vector 자료 개수 : 1
      System.out.println(v.capacity()); //Vector 물리적크기 : 10
      ```

      - 자료의 개수를 구하기 위해서는 size()메소드 사용
      - vector의 물리적 크기를 구하기 위해서는 capacity()메소드 사용

   5. Vector 값 출력

      ```
      Vector<Integer> list = new Vector<Integer>(Arrays.asList(1,2,3));

      System.out.println(list.get(0));//0번째 index 출력

      for(Integer i : list) { //for문을 통한 전체출력
          System.out.println(i);
      }

      Iterator iter = list.iterator(); //Iterator 선언
      while(iter.hasNext()){//다음값이 있는지 체크
          System.out.println(iter.next()); //값 출력
      }
      ```

      - get(index) 메소드를 이용해 원하는 index의 값을 출력할 수 있음

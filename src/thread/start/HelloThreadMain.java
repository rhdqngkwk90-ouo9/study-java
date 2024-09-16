package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {

        //1. 현재 실행하는 스레드 객체 반환
        Thread thread = Thread.currentThread();

        //2. main 코드를 실행하는 스레드 확인 - main 이라는 스레드가 떠서 main 메서드를 실행한다.
//        System.out.println(thread.getName()); //main

        //3. main 스레드 실행 범위 확인
        System.out.println(thread.getName()+" start !"); //main start !

        HelloThread helloThread = new HelloThread();
        System.out.println("start() 호출 전 : "+helloThread.getName());
        /* 4. start() 메서드
         * - 스레드를 실행하는 메서드
         * - 호출하면 스택 공간을 할당 받는다.
         * - run()이 아니라 start()를 호출해야 안에 run()을 불러온다.
         * - main 스레드가 run()을 호출하는 것이 아니라, 생성된 Thread-0 가 호출하는 것이다.
         * - main은 기다리지 않고 end 하기 때문에 순서가 아래와 같이 나오는 것이다.
         */
        helloThread.start();
        System.out.println("start() 호출 후 : "+helloThread.getName());

        System.out.println(thread.getName()+" end !"); //main end !

        /* 5. 출력 결과
         * main start !
         * start() 호출 전 : Thread-0
         * start() 호출 후 : Thread-0
         * main end !
         * 이 사이에 "run() 실행 ! Thread-0"가 어디에 껴서 나올지 모른다. (CPU 스케줄링)
         */

        /* 6. 결론
         * 스레드 간의 실행 순서는 얼마든지 달라질 수 있다.
         * -> 스레드는 순서와 실행 기간을 모두 보장하지 않는다. -> 이것이 멀티스레드 !
         */
    }
}

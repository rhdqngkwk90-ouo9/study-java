package thread.start;

//Thread 클래스 상속
public class HelloThread extends Thread {

    //스레드가 실행할 코드를 run() 메서드에 재정의한다.
    @Override
    public void run() {
        //현재 실행 중인 스레드의 이름을 조회한다.
        System.out.println("run() 실행 ! "+Thread.currentThread().getName());
    }
}

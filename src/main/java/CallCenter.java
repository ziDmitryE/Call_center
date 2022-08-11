import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CallCenter {

    private static final int WAIT_FOR_CALL = 1000;
    private static final int OPERATE_TIME = 3000;
    private static final int SIZE_OF_CALLS = 10;

    /*
    используем ArrayBlockingQueue т.к. по задаче известен размер очереди, она обеспечивает
    честный порядок и быстрее чем список
    */
    final private BlockingQueue<Call> calls = new ArrayBlockingQueue<>(SIZE_OF_CALLS, true);

    public void incomingCalls() {
        System.out.println("Центр начинает принимать звонки");
        try {
            for (int i = 0; i < SIZE_OF_CALLS; i++) {
                calls.put(new Call());
                Thread.sleep(WAIT_FOR_CALL);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Центр принял " + SIZE_OF_CALLS + " звонков");
    }

    public void operateCall() {
        int callsCount = 0;
        try {
            while (!calls.isEmpty()) {
                calls.take();
                Thread.sleep(OPERATE_TIME);
                System.out.println(Thread.currentThread().getName() + " обработал звонок");
                callsCount++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " всего обработал " + callsCount + " звонков");
    }
}

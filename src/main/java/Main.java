public class Main {

    public static void main(String[] args) throws InterruptedException {
        CallCenter ATC = new CallCenter();

        new Thread(null, ATC::incomingCalls, "АТС").start();

        // Время на создание первых звонков
        Thread.sleep(4000);

        new Thread(null, ATC::operateCall, "Оператор 1").start();
        new Thread(null, ATC::operateCall, "Оператор 2").start();
        new Thread(null, ATC::operateCall, "Оператор 3").start();
    }
}

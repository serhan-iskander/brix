package Excercise1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by serhan.i on 2019-08-18
 **/
public class main {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue, 1)).start();
        new Thread(new Consumer(queue, 2)).start();
        new Thread(new Consumer(queue, 3)).start();
        new Thread(new Consumer(queue, 4)).start();
        new Thread(new Consumer(queue, 5)).start();

    }

}

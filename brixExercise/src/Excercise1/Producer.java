package Excercise1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by serhan.i on 2019-08-18
 **/
public class Producer implements Runnable {
    private final  BlockingQueue<String> queue;
    private static int peopleId = 0;

    @Override
    public void run() {

        try {
            process();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void process() throws InterruptedException {

        while (true)
        {
            Thread.sleep(1000);
            System.out.println("People " + peopleId++ + " join the queue");
            queue.add("People " + peopleId);
        }

    }

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
}

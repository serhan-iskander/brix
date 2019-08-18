package Excercise1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by serhan.i on 2019-08-18
 **/
public class Consumer implements Runnable{
    private final BlockingQueue<String> queue;
    private final Integer id;

    @Override
    public void run() {

        try {
            while (true) {
                String people = queue.take();
                process(people);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void process(String people) throws InterruptedException {
        Random rand = new Random();
        System.out.println("cashier " + id + " start processing " + people);
        Thread.sleep((rand.nextInt(5) + 1) * 1000);
        System.out.println("cashier " + id + " end processing " + people);
    }

    public Consumer(BlockingQueue<String> queue, Integer id) {
        this.queue = queue;
        this.id = id;
    }
}

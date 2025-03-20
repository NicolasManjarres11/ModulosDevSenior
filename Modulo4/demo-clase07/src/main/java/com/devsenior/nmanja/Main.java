package com.devsenior.nmanja;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /* new DemoComparator().run(); */

        var queue = new ConcurrentLinkedDeque<String>(); 

        Runnable productor = () -> {
            for (int i = 0; i < 100; i++) {
                queue.add("Mensaje "+ i+1 + " desde "+ Thread.currentThread().getName());
            }
        };

        Runnable consumidor = () -> {
            while(queue.size() > 0){
                var message = queue.poll(); //poll lo elimina de la cola
                System.out.println(message);
            }
        };

        var productor1 = new Thread(productor);
        var producto2 = new Thread(productor);
        var consumidor1 = new Thread(consumidor);

        productor1.start();
        producto2.start();

        Thread.sleep(1000);

        consumidor1.start();

        

        productor1.join();
        producto2.join();
        consumidor1.join();

    }
}
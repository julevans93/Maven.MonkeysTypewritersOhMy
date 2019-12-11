package io.zipcoder;

import java.util.Random;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        Random random = new Random();
        int randomSleep = random.nextInt((500 - 250) + 1)+ 250;
        while (stringIterator.hasNext()) {
//            System.out.println(Thread.currentThread().getName() + " " + stringIterator.next());
//            copied += stringIterator.next();
            try {
                String holder = stringIterator.next() + " ";
                Thread.sleep(randomSleep);
                System.out.println(Thread.currentThread().getName() + " " + stringIterator.next());
                copied += holder;
            } catch (InterruptedException e) {
                System.out.println("MAIN INTERRUPTED");
            }
        }
        copied = copied.trim();
    }
}

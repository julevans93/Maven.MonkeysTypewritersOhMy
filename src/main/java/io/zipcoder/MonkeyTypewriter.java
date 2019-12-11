package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        //all threads need to start at the same time or one will do all the work
        //Thread monkey1 = new Thread(new unsafeCopier(introduction)) will create a new thread of entire line each time
        UnsafeCopier unsafe = new UnsafeCopier(introduction);
        SafeCopier safe = new SafeCopier(introduction);
        //change thread to safe or unsafe depending on on what copier you are running
        Thread monkey1 = new Thread(safe);
        Thread monkey2 = new Thread(safe);
        Thread monkey3 = new Thread(safe);
        Thread monkey4 = new Thread(safe);
        Thread monkey5 = new Thread(safe);
        monkey1.start();
        monkey2.start();
        monkey3.start();
        monkey4.start();
        monkey5.start();


        //join together with main so that threads run first before main
        try{
            monkey1.join();
            monkey2.join();
            monkey3.join();
            monkey4.join();
            monkey5.join();

        }catch (InterruptedException e){
            System.out.println("MAIN INTERRUPTED");
        }
/*
         This wait is here because main is still a thread and we want the main method to print the finished copies
         after enough time has passed.*/

        try {
            Thread.sleep(100);


        } catch (InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        //this changes to unsafe or safe depending on whats being run
        System.out.println(safe.copied);

        if(pageMatcher(safe.copied,introduction)){
            System.out.println("Match!");
        }

    }
        public static  Boolean pageMatcher(String copy, String original){
        return copy.equals(original);
        }
}
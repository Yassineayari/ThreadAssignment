static class Counter {
    void count() {
        //todo implement me
        for (int i = 350; i>=1; i--){
            System.out.println(i);
        }
        System.out.println("FINISH !!");
    }
}

@@ -15,14 +18,26 @@ public MyThread(Counter counter) {

    @Override
    public void run() {
        counter.count();
        synchronized (counter){
            counter.count();
        };
    }
}

public static void main(String[] args) {
    Counter counter = new Counter();

    new MyThread(counter).start();
    new MyThread(counter).start();
    MyThread t1 = new MyThread(counter);
    MyThread t2 = new MyThread(counter);
    t1.start();
    t2.start();

    try {
        t2.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    System.out.println("DONE!");
}
}
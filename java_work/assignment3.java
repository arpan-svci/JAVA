import java.util.LinkedList;
  
class assignment3 {

    static class ProducerConsumer {

        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 3;
        
        public void produce() throws InterruptedException{
            int value = 0;
            while (true) {
                synchronized (this){
                    if(list.size() == capacity){
                        System.out.println("Buffer is full. producer going to sleep");
                        while (list.size() == capacity) wait();
                    }    
  
                    System.out.println("Producer produced an item");
  
                    list.add(value++);
  
                    notify();
  
                    Thread.sleep(1000);
                }
            }
        }
  
        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    if(list.size() == 0){
                        System.out.println("Buffer is empty. Consumer going to sleep");
                        while (list.size() == 0) wait();

                    }
                    int val = list.removeFirst();
  
                    System.out.println("Consumer consumed an item");
  
                    notify();
  
                    Thread.sleep(1000);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final ProducerConsumer pc = new ProducerConsumer();
        Thread t1 = new Thread(new Runnable() {
            public void run(){
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
  
        Thread t2 = new Thread(new Runnable() {
            public void run(){
                try {
                    pc.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        System.out.println("Buffer capacity is: " + pc.capacity);

        t1.start();
        t2.start();
    }
}
package synchronization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSample {
  public static void main(String[] args) {
     ExecutorService es1 = Executors.newFixedThreadPool(5);
      Future<String> f1 = es1.submit(new CallableSample());        
     while(!f1.isDone()) {
         //подождать пока задача не выполнится
     }
    try {
        System.out.println("task has been completed : " + f1.get());
    } catch (InterruptedException ie) {           
         ie.printStackTrace(System.err);
     } catch (ExecutionException ee) {
         ee.printStackTrace(System.err);
     }
     es1.shutdown();
 }
}
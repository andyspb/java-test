package synchronization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.List;

public class SynchronizationTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    List<String> list = new ArrayList<String>();
    list.add("one");
    list.add("two");

    List<String> syncList = Collections.synchronizedList(list);


    System.out.println("Synchronized list :" + syncList);



  }

}

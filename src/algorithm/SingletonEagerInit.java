package algorithm;

public class SingletonEagerInit {
  
  private static final SingletonEagerInit instance = new SingletonEagerInit();
  
  private SingletonEagerInit () {  }
  
  public static SingletonEagerInit getInstance() {
    return instance;
}


}

package generic;


interface Parser<T> {
  T parse();
}

interface Iterator<E> {
  E next();
  boolean hasNext();
}

interface List<E> {
  void add(E x);
  Iterator<E> iterator();
}

public class GenericTest {

}

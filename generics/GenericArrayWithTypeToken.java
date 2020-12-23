// generics/GenericArrayWithTypeToken.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.lang.reflect.*;

public class GenericArrayWithTypeToken<T> {
  private T[] array;
  @SuppressWarnings("unchecked")
  public
  GenericArrayWithTypeToken(Class<T> type, int sz) {
    array = (T[])Array.newInstance(type, sz);
  }
  public void put(int index, T item) {
    array[index] = item;
  }
  public T get(int index) { return array[index]; }
  // Expose the underlying representation:
  public T[] rep() { return array; }
  public static void main(String[] args) {
    GenericArrayWithTypeToken<Integer> gai =
      new GenericArrayWithTypeToken<>(
        Integer.class, 10);
    // This now works:
    Integer[] ia = gai.rep();
    System.err.println(ia.length);

    //self-note: 深入研究泛型的数组【】
    try {
      Object obj = new Object();
      String str = (String)obj;
    } catch (Exception e) {
      System.err.println("not OK!  "+e);
    }

    try {
      String str = new String();
      Object obj = str;
      String str2 = (String)obj;
      System.err.println("OK!");
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}

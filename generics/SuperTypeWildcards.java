// generics/SuperTypeWildcards.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

public class SuperTypeWildcards {
  static void writeTo(List<? super Apple> apples) {
    apples.add(new Apple());
    apples.add(new Jonathan());
//     apples.add(new Fruit()); // Error

    Holder<? super Apple> apple1 = new Holder<>(new Apple());
    Holder<? super Apple> apple2 = new Holder<>(new Jonathan());
    Holder<? super Apple> apple0 = new Holder<>(new Fruit());
    apple1.set(new Jonathan());
//    apple1.set(new Orange());
//    apple0.set(new Fruit());

  }
}

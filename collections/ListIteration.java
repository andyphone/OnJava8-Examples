// collections/ListIteration.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import pets.*;
import java.util.*;

public class ListIteration {
  public static void main(String[] args) {
    List<Pet> pets = Pets.list(8);
    ListIterator<Pet> it = pets.listIterator();
    while(it.hasNext())
      System.err.print(it.next() +
        ", " + it.nextIndex() +
        ", " + it.previousIndex() + "; ");
    System.err.println();
    // Backwards:
    while(it.hasPrevious())
      System.err.print(it.previous().id() + " ");
    System.err.println();
    System.err.println("TOTAL_1:"+pets);
    it = pets.listIterator(3);
    while(it.hasNext()) {
//      ;
      System.err.println(it.next() );
      it.set(Pets.get());//self-note:   使用 set() 方法可以替换它访问过的最近一个元素。
    }
    System.err.println("TOTAL_2:"+pets);
  }
}
/* Output:
Rat, 1, 0; Manx, 2, 1; Cymric, 3, 2; Mutt, 4, 3; Pug,
5, 4; Cymric, 6, 5; Pug, 7, 6; Manx, 8, 7;
7 6 5 4 3 2 1 0
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
[Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]
*/

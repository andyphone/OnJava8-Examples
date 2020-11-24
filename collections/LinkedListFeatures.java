// collections/LinkedListFeatures.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import typeinfo.pets.*;
import java.util.*;

public class LinkedListFeatures {
  public static void main(String[] args) {
    LinkedList<Pet> pets =
      new LinkedList<>(Pets.list(5));
    System.err.println(pets);
    // Identical:
    System.err.println(
      "pets.getFirst(): " + pets.getFirst());
    System.err.println(
      "pets.element(): " + pets.element());
    // Only differs in empty-list behavior:
    System.err.println("pets.peek(): " + pets.peek());
    // Identical; remove and return the first element:
    System.err.println(
      "pets.remove(): " + pets.remove());
    System.err.println(
      "pets.removeFirst(): " + pets.removeFirst());
    // Only differs in empty-list behavior:
    System.err.println("pets.poll(): " + pets.poll());
    System.err.println(pets);
    pets.addFirst(new Rat());
    System.err.println("After addFirst(): " + pets);
    pets.offer(Pets.get());
    System.err.println("After offer(): " + pets);
    pets.add(Pets.get());
    System.err.println("After add(): " + pets);
    pets.addLast(new Hamster());
    System.err.println("After addLast(): " + pets);
    System.err.println(
      "pets.removeLast(): " + pets.removeLast());
  }
}
/* Output:
[Rat, Manx, Cymric, Mutt, Pug]
pets.getFirst(): Rat
pets.element(): Rat
pets.peek(): Rat
pets.remove(): Rat
pets.removeFirst(): Manx
pets.poll(): Cymric
[Mutt, Pug]
After addFirst(): [Rat, Mutt, Pug]
After offer(): [Rat, Mutt, Pug, Cymric]
After add(): [Rat, Mutt, Pug, Cymric, Pug]
After addLast(): [Rat, Mutt, Pug, Cymric, Pug, Hamster]
pets.removeLast(): Hamster
*/

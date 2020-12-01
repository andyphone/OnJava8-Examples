// collections/LinkedListFeatures.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import pets.*;
import java.util.*;

public class LinkedListFeatures {
  public static void main(String[] args) {
    LinkedList<Pet> pets =
      new LinkedList<>(Pets.list(5));
    System.err.println(pets);

/*-----------------------------------------------------------------------------------------------------------------------------------*/

    // Identical:                   self-note:  getFirst() 和 element() 是相同的，它们都返回列表的头部（第一个元素）而并不删除它，
    //                              如果 List 为空，则抛出 NoSuchElementException 异常。
    System.err.println(
      "pets.getFirst(): " + pets.getFirst());
    System.err.println(
      "pets.element(): " + pets.element());
    // Only differs in empty-list behavior:               peek() 方法与这两个方法只是稍有差异，它在列表为空时返回 null 。
    System.err.println("pets.peek(): " + pets.peek());

/*-----------------------------------------------------------------------------------------------------------------------------------*/

    // Identical; remove and return the first element:     如果 List 为空，则抛出 NoSuchElementException 异常。
    System.err.println(
      "pets.remove(): " + pets.remove());
    System.err.println(
      "pets.removeFirst(): " + pets.removeFirst());
    // Only differs in empty-list behavior:                它在列表为空时返回 null 。
    System.err.println("pets.poll(): " + pets.poll());
    System.err.println(pets);

/*-----------------------------------------------------------------------------------------------------------------------------------*/

    /*在列表的开头插入一个元素。*/
    pets.addFirst(new Rat());
    System.err.println("After addFirst(): " + pets);


    /*offer() 与 add() 和 addLast() 相同。 它们都在列表的尾部（末尾）添加一个元素。*/
    pets.offer(Pets.get());
    System.err.println("After offer(): " + pets);
    pets.add(Pets.get());
    System.err.println("After add(): " + pets);
    pets.addLast(new Hamster());
    System.err.println("After addLast(): " + pets);


    /*删除并返回列表的最后一个元素。*/
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

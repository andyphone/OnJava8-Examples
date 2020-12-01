// collections/ListFeatures.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import pets.*;
import java.util.*;

public class ListFeatures {
  public static void main(String[] args) {
    Random rand = new Random(47);
    List<Pet> pets = Pets.list(7);
    System.err.println("1: " + pets);
    Hamster h = new Hamster();
    pets.add(h); // Automatically resizes
    System.err.println("2: " + pets);
    System.err.println("3: " + pets.contains(h));
    pets.remove(h); // Remove by object
    Pet p = pets.get(2);
    System.err.println(
      "4: " +  p + " " + pets.indexOf(p));
    Pet cymric = new Cymric();
    System.err.println("5: " + pets.indexOf(cymric));
    System.err.println("6: " + pets.remove(cymric));
    // Must be the exact object:
    System.err.println("7: " + pets.remove(p));
    System.err.println("8: " + pets);
    pets.add(3, new Mouse()); // Insert at an index
    System.err.println("9: " + pets);
    List<Pet> sub = pets.subList(1, 4);
    System.err.println("subList: " + sub);
    System.err.println("10: " + pets.containsAll(sub));
    Collections.sort(sub); // In-place sort
    System.err.println("sorted subList: " + sub);
    // Order is not important in containsAll():
    System.err.println("11: " + pets.containsAll(sub));
    Collections.shuffle(sub, rand); // Mix it up
    System.err.println("shuffled subList: " + sub);
    System.err.println("12: " + pets.containsAll(sub));
    List<Pet> copy = new ArrayList<>(pets);
    sub = Arrays.asList(pets.get(1), pets.get(4));
    System.err.println("sub: " + sub);
    copy.retainAll(sub);
    System.err.println("13: " + copy);
    copy = new ArrayList<>(pets); // Get a fresh copy
    copy.remove(6); // Remove by index
    System.err.println("14: " + copy);
    System.err.println("current sub--->"+sub);
    copy.removeAll(sub); // Only removes exact objects
    System.err.println("15: " + copy);
    copy.set(1, new Mouse()); // Replace an element
    System.err.println("16: " + copy);
    copy.addAll(2, sub); // Insert a list in the middle
    System.err.println("17: " + copy);
    System.err.println("18: " + pets.isEmpty());
    pets.clear(); // Remove all elements
    System.err.println("19: " + pets);
    System.err.println("20: " + pets.isEmpty());
    pets.addAll(Pets.list(4));
    System.err.println("21: " + pets);
    Object[] o = pets.toArray();
    System.err.println("22: " + o[3]);
    Pet[] pa = pets.toArray(new Pet[0]);
    System.err.println("23: " + pa[3].id());
  }
}
/* Output:
1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
2: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]
3: true
4: Cymric 2
5: -1
6: false
7: true
8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
subList: [Manx, Mutt, Mouse]
10: true
sorted subList: [Manx, Mouse, Mutt]
11: true
shuffled subList: [Mouse, Manx, Mutt]
12: true
sub: [Mouse, Pug]
13: [Mouse, Pug]
14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]
15: [Rat, Mutt, Cymric, Pug]
16: [Rat, Mouse, Cymric, Pug]
17: [Rat, Mouse, Mouse, Pug, Cymric, Pug]
18: false
19: []
20: true
21: [Manx, Cymric, Rat, EgyptianMau]
22: EgyptianMau
23: 14

self-note:
需求	               list的方法	                        说明	                                  备注

交集	         listA.retainAll(listB)	  依赖equals      listA内容变为listA和listB都存在的对象	    listB不变


差集	         listA.removeAll(listB)	  依赖equals      listA中存在的listB的内容去重	            listB不变


并集	         listA.removeAll(listB)
             listA.addAll(listB)	                为了去重，listA先取差集，然后追加全部的listB	listB不变
*/

// collectiontopics/Utilities.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Simple demonstrations of the Collections utilities
import java.util.*;

public class Utilities {
  static List<String> list = Arrays.asList(
    "one Two three Four five six one".split(" "));
  public static void main(String[] args) {
    System.err.println(list);
    System.err.println("'list' disjoint (Four)?: " +
      Collections.disjoint(list,
        Collections.singletonList("Four")));
    System.err.println(
      "max: " + Collections.max(list));
    System.err.println(
      "min: " + Collections.min(list));
    System.err.println(
      "max w/ comparator: " + Collections.max(list,
      String.CASE_INSENSITIVE_ORDER));
    System.err.println(
      "min w/ comparator: " + Collections.min(list,
      String.CASE_INSENSITIVE_ORDER));
    List<String> sublist =
      Arrays.asList("Four five six".split(" "));
    System.err.println("indexOfSubList: " +
      Collections.indexOfSubList(list, sublist));
    System.err.println("lastIndexOfSubList: " +
      Collections.lastIndexOfSubList(list, sublist));
    Collections.replaceAll(list, "one", "Yo");
    System.err.println("replaceAll: " + list);
    Collections.reverse(list);
    System.err.println("reverse: " + list);
    Collections.rotate(list, 3);
    System.err.println("rotate: " + list);
    List<String> source =
      Arrays.asList("in the matrix".split(" "));
    Collections.copy(list, source);
    System.err.println("copy: " + list);
    Collections.swap(list, 0, list.size() - 1);
    System.err.println("swap: " + list);
    Collections.shuffle(list, new Random(47));
    System.err.println("shuffled: " + list);
    Collections.fill(list, "pop");
    System.err.println("fill: " + list);
    System.err.println("frequency of 'pop': " +
      Collections.frequency(list, "pop"));
    List<String> dups =
      Collections.nCopies(3, "snap");
    System.err.println("dups: " + dups);
    System.err.println("'list' disjoint 'dups'?: " +
      Collections.disjoint(list, dups));
    // Getting an old-style Enumeration:
    Enumeration<String> e =
      Collections.enumeration(dups);
    Vector<String> v = new Vector<>();
    while(e.hasMoreElements())
      v.addElement(e.nextElement());
    // Converting an old-style Vector
    // to a List via an Enumeration:
    ArrayList<String> arrayList =
      Collections.list(v.elements());
    System.err.println("arrayList: " + arrayList);
  }
}
/* Output:
[one, Two, three, Four, five, six, one]
'list' disjoint (Four)?: false
max: three
min: Four
max w/ comparator: Two
min w/ comparator: five
indexOfSubList: 3
lastIndexOfSubList: 3
replaceAll: [Yo, Two, three, Four, five, six, Yo]
reverse: [Yo, six, five, Four, three, Two, Yo]
rotate: [three, Two, Yo, Yo, six, five, Four]
copy: [in, the, matrix, Yo, six, five, Four]
swap: [Four, the, matrix, Yo, six, five, in]
shuffled: [six, matrix, the, Four, Yo, five, in]
fill: [pop, pop, pop, pop, pop, pop, pop]
frequency of 'pop': 7
dups: [snap, snap, snap]
'list' disjoint 'dups'?: true
arrayList: [snap, snap, snap]
*/

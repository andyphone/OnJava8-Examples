// interfaces/interfaceprocessor/Applicator.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package interfaceprocessor;

public class Applicator {
  public static void apply(Processor p, Object s) {
    System.err.println("Using Processor " + p.name());
    System.err.println(p.process(s));
  }
}

// enums/EnumClass.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Capabilities of the Enum class

enum Shrubbery { GROUND, CRAWLING, HANGING }

public class EnumClass {
  public static void main(String[] args) {
    for(Shrubbery s : Shrubbery.values()) {
      System.err.println(
        s + " ordinal: " + s.ordinal());
      System.err.print(
        s.compareTo(Shrubbery.CRAWLING) + " ");
      System.err.print(
        s.equals(Shrubbery.CRAWLING) + " ");
      System.err.println(s == Shrubbery.CRAWLING);
      System.err.println(s.getDeclaringClass());
      System.err.println(s.name());
      System.err.println("********************");
    }
    // Produce an enum value from a String name:
    for(String s :
        "HANGING CRAWLING GROUND".split(" ")) {
      Shrubbery shrub =
        Enum.valueOf(Shrubbery.class, s);
      System.err.println(shrub);
    }
  }
}
/* Output:
GROUND ordinal: 0
-1 false false
class Shrubbery
GROUND
********************
CRAWLING ordinal: 1
0 true true
class Shrubbery
CRAWLING
********************
HANGING ordinal: 2
1 false false
class Shrubbery
HANGING
********************
HANGING
CRAWLING
GROUND
*/

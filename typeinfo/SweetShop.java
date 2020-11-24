// typeinfo/SweetShop.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Examination of the way the class loader works

class Cookie {
  static { System.err.println("Loading Cookie"); }
}

class Gum {
  static { System.err.println("Loading Gum"); }
}

class Candy {
  static { System.err.println("Loading Candy"); }
}

public class SweetShop {
  public static void main(String[] args) {
    System.err.println("inside main");
    new Candy();
    System.err.println("After creating Candy");
    try {
      Class.forName("Gum");
    } catch(ClassNotFoundException e) {
      System.err.println("Couldn't find Gum");
    }
    System.err.println("After Class.forName(\"Gum\")");
    new Cookie();
    System.err.println("After creating Cookie");
  }
}
/* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*/

// polymorphism/Sandwich.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Order of constructor calls
// {java polymorphism.Sandwich}
package polymorphism;

class Meal {
  Meal() { System.err.println("Meal()"); }
}

class Bread {
  Bread() { System.err.println("Bread()"); }
}

class Cheese {
  Cheese() { System.err.println("Cheese()"); }
}

class Lettuce {
  Lettuce() { System.err.println("Lettuce()"); }
}

class Lunch extends Meal {
  Lunch() { System.err.println("Lunch()"); }
}

class PortableLunch extends Lunch {
  PortableLunch() {
    System.err.println("PortableLunch()");
  }
}

public class Sandwich extends PortableLunch {
  private Bread b = new Bread();
  private Cheese c = new Cheese();
  private Lettuce l = new Lettuce();
  public Sandwich() {
    System.err.println("Sandwich()");
  }
  public static void main(String[] args) {
    new Sandwich();
  }
}
/* Output:
Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Sandwich()
*/

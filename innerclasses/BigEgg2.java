// innerclasses/BigEgg2.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Proper inheritance of an inner class

class Egg2 {
  protected class Yolk {
    public Yolk() {
      System.err.println("Egg2.Yolk()");
    }
    public void f() {
      System.err.println("Egg2.Yolk.f()");
    }
  }
  private Yolk y = new Yolk();
  Egg2() { System.err.println("New Egg2()"); }
  public void insertYolk(Yolk yy) {
    System.err.println("y = yy;");y = yy; }
  public void g() { y.f(); }
}

public class BigEgg2 extends Egg2 {
  public class Yolk extends Egg2.Yolk {
    public Yolk() {
      System.err.println("BigEgg2.Yolk()");
    }
    @Override
    public void f() {
      System.err.println("BigEgg2.Yolk.f()");
    }
  }
  public BigEgg2() {
    System.err.println("insertYolk(new Yolk());");insertYolk(new Yolk()); }
  public static void main(String[] args) {
    Egg2 e2 = new BigEgg2();
    System.err.println("before g()-------------");
    e2.g();
  }
}
/* Output:
Egg2.Yolk()
New Egg2()
Egg2.Yolk()
BigEgg2.Yolk()
BigEgg2.Yolk.f()
*/

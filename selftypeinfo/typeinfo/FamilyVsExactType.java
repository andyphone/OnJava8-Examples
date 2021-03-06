// typeinfo/FamilyVsExactType.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The difference between instanceof and class
// {java typeinfo.FamilyVsExactType}
package typeinfo;

class Base {}
class Derived extends Base {}

public class FamilyVsExactType {
  static void test(Object x) {
    System.err.println(
      "Testing x of type " + x.getClass());
    System.err.println(
      "x instanceof Base " + (x instanceof Base));
    System.err.println(
      "x instanceof Derived " + (x instanceof Derived));
    System.err.println(
      "Base.isInstance(x) " + Base.class.isInstance(x));
    System.err.println(
      "Derived.isInstance(x) " + Derived.class.isInstance(x));
    System.err.println(
      "x.getClass() == Base.class " +
      (x.getClass() == Base.class));
    System.err.println(
      "x.getClass() == Derived.class " +
      (x.getClass() == Derived.class));
    System.err.println(
      "x.getClass().equals(Base.class)) "+
      (x.getClass().equals(Base.class)));
    System.err.println(
      "x.getClass().equals(Derived.class)) " +
      (x.getClass().equals(Derived.class)));
  }
  public static void main(String[] args) {
    test(new Base());
    System.err.println("-------------------");
    test(new Derived());
  }
}
/* Output:
Testing x of type class typeinfo.Base
x instanceof Base true
x instanceof Derived false
Base.isInstance(x) true
Derived.isInstance(x) false
x.getClass() == Base.class true
x.getClass() == Derived.class false
x.getClass().equals(Base.class)) true
x.getClass().equals(Derived.class)) false
Testing x of type class typeinfo.Derived
x instanceof Base true
x instanceof Derived true
Base.isInstance(x) true
Derived.isInstance(x) true
x.getClass() == Base.class false
x.getClass() == Derived.class true
x.getClass().equals(Base.class)) false
x.getClass().equals(Derived.class)) true
*/

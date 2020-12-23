// generics/TupleTest2.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
//import onjava.*;
//import static onjava.Tuple.*;

public class TupleTest2 {
  static Tuple2<String, Integer> f() {
    return Tuple.tuple("hi", 47);
  }
  static Tuple2 f2() { return Tuple.tuple("hi", 47); }
  static Tuple3<Amphibian, String, Integer> g() {
    return Tuple.tuple(new Amphibian(), "hi", 47);
  }
  static
  Tuple4<Vehicle, Amphibian, String, Integer> h() {
    return Tuple.tuple(
      new Vehicle(), new Amphibian(), "hi", 47);
  }
  static
  Tuple5<Vehicle, Amphibian,
         String, Integer, Double> k() {
    return Tuple.tuple(new Vehicle(), new Amphibian(),
      "hi", 47, 11.1);
  }
  public static void main(String[] args) {
    Tuple2<String, Integer> ttsi = f();
    System.err.println(ttsi);
    System.err.println(f2());
    System.err.println(g());
    System.err.println(h());
    System.err.println(k());
  }
}
/* Output:
(hi, 47)
(hi, 47)
(Amphibian@14ae5a5, hi, 47)
(Vehicle@135fbaa4, Amphibian@45ee12a7, hi, 47)
(Vehicle@4b67cf4d, Amphibian@7ea987ac, hi, 47, 11.1)
*/

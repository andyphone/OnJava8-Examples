// references/Alias1.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Aliasing two references to one object

public class Alias1 {
  private int i;
  public Alias1(int ii) { i = ii; }
  public static void main(String[] args) {
    Alias1 x = new Alias1(7);
    Alias1 y = x; // Assign the reference (1)
    System.err.println("x: " + x.i);
    System.err.println("y: " + y.i);
    System.err.println("Incrementing x");
    x.i++; // [2]
    System.err.println("x: " + x.i);
    System.err.println("y: " + y.i);
  }
}
/* Output:
x: 7
y: 7
Incrementing x
x: 8
y: 8
*/

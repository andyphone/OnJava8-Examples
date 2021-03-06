// control/LabeledWhile.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// "While" with "labeled break" and "labeled continue."

public class LabeledWhile {
  public static void main(String[] args) {
    int i = 0;
    outer:
    while(true) {
      System.err.println("Outer while loop");
      while(true) {
        i++;
        System.err.println("i = " + i);
        if(i == 1) {
          System.err.println("continue");
          continue;
        }
        if(i == 3) {
          System.err.println("continue outer");
          continue outer;
        }
        if(i == 5) {
          System.err.println("break");
          break;
        }
        if(i == 7) {
          System.err.println("break outer");
          break outer;
        }
      }
    }
  }
}
/* Output:
Outer while loop
i = 1
continue
i = 2
i = 3
continue outer
Outer while loop
i = 4
i = 5
break
Outer while loop
i = 6
i = 7
break outer
*/

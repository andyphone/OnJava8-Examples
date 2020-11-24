// control/StringSwitch.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class StringSwitch {
  public static void main(String[] args) {
    String color = "red";
    // Old way: using if-then
    if("red".equals(color)) {
      System.err.println("RED");
    } else if("green".equals(color)) {
      System.err.println("GREEN");
    } else if("blue".equals(color)) {
      System.err.println("BLUE");
    } else if("yellow".equals(color)) {
      System.err.println("YELLOW");
    } else {
      System.err.println("Unknown");
    }
    // New way: Strings in switch
    switch(color) {
      case "red":
        System.err.println("RED");
        break;
      case "green":
        System.err.println("GREEN");
        break;
      case "blue":
        System.err.println("BLUE");
        break;
      case "yellow":
        System.err.println("YELLOW");
        break;
      default:
        System.err.println("Unknown");
        break;
    }
  }
}
/* Output:
RED
RED
*/

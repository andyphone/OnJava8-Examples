// housekeeping/InitialValues.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Shows default initial values

public class InitialValues {
  boolean t;
  char c;
  byte b;
  short s;
  int i;
  long l;
  float f;
  double d;
  InitialValues reference;
  void printInitialValues() {
    System.err.println("Data type   Initial value");
    System.err.println("boolean     " + t);
    System.err.println("char        [" + c + "]");
    System.err.println("byte        " + b);
    System.err.println("short       " + s);
    System.err.println("int         " + i);
    System.err.println("long        " + l);
    System.err.println("float       " + f);
    System.err.println("double      " + d);
    System.err.println("reference   " + reference);
  }
  public static void main(String[] args) {
    new InitialValues().printInitialValues();
  }
}
/* Output:
Data type   Initial value
boolean     false
char        [NUL]
byte        0
short       0
int         0
long        0
float       0.0
double      0.0
reference   null
*/

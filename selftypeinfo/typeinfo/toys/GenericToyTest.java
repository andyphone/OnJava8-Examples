// typeinfo/toys/GenericToyTest.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Testing class Class
// {java typeinfo.toys.GenericToyTest}
package typeinfo.toys;

public class GenericToyTest {
  @SuppressWarnings("deprecation")
  public static void
  main(String[] args) throws Exception {
    Class<typeinfo.toys.FancyToy> ftClass = typeinfo.toys.FancyToy.class;
    // Produces exact type:
    typeinfo.toys.FancyToy fancyToy = ftClass.newInstance();
    Class<? super typeinfo.toys.FancyToy> up =
      ftClass.getSuperclass();
    // This won't compile:
     Class<typeinfo.toys.Toy> up2 = (Class<typeinfo.toys.Toy>) ftClass.getSuperclass();
    // Only produces Object:
    Object obj = up.newInstance();
  }
}

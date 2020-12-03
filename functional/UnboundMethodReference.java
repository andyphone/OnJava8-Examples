// functional/UnboundMethodReference.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Method reference without an object

interface MakeString {
  String make();
}

class X {
  String f() { return "X::f()"; }
}

interface MakeString2 {
  String make();
}

class X2 {
  String f() {
    System.err.println("success!");
    return "success!";
  }
}

interface TransformX {
  String transform(X x);
}

public class UnboundMethodReference {
  public static void main(String[] args) {

    X2 x2 = new X2();
//    MakeString2 c = X2::f;                没有实例
    MakeString2 c = x2::f;
    c.make();

//    MakeString ms = X::f; // [1] self-note: 这个是大写的X,不是上面例子的小写d了,没有实例,因此其实需要一个实例用作参数.
    TransformX sp = X::f;  //总之静态方法引用 X::f 写法是需要多一个参数，要么就用非静态的方法引用 x2::f
    X x3 = new X();
    System.err.println(sp.transform(x3)); // [2]
    System.err.println(x3.f()); // Same effect
  }
}
/* Output:
X::f()
X::f()
*/

// innerclasses/DotNew.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Creating an inner class directly using .new syntax

public class DotNew {
  public class Inner {
    public Inner() {
      System.err.println("inner is be done");
    }
  }
  public Inner getInner(){
    return new Inner();
  }
  public static void main(String[] args) {
    DotNew dn = new DotNew();
    //fun1
    DotNew.Inner dni = dn.new Inner();//self-note:  直接获取创建内部对象的方法, .new
    //fun2
    DotNew.Inner dni2 = dn.getInner();
    DotNew.Inner dni3 = dn.getInner();

  }
}

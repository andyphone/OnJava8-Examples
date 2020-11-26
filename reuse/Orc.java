// reuse/Orc.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The protected keyword

class Villain {
  private String name;
  protected void set(String nm) { name = nm; }
  Villain(String name) { this.name = name; }
  @Override
  public String toString() {
    return "I'm a Villain and my name is " + name;
  }
}

public class Orc extends Villain {
  private int orcNumber;
  public Orc(String name, int orcNumber) {
    super(name);
    this.orcNumber = orcNumber;
  }
  public void change(String name, int orcNumber) {
    set(name); // Available because it's protected
    this.orcNumber = orcNumber;
  }
  @Override
  public String toString() {
    return "Orc " + orcNumber + ": " + super.toString();
  }
  public static void main(String[] args) {
    Orc orc = new Orc("Limburger", 12);
    System.err.println(orc);
    orc.change("Bob", 19);
    System.err.println(orc);
  }
}
/* Output:
Orc 12: I'm a Villain and my name is Limburger
Orc 19: I'm a Villain and my name is Bob
self-note: 尽管可以创建 protected 属性，但是最好的方式是将属性声明为 private 以一直保留更改底层实现的权利。
然后通过 protected 控制类的继承者(Orc类)访问权限。
*/

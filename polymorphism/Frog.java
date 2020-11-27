// polymorphism/Frog.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Cleanup and inheritance
// {java polymorphism.Frog}

class Characteristic {
  private String s;
  Characteristic(String s) {
    this.s = s;
    System.err.println("Creating Characteristic " + s);
  }
  protected void dispose() {
    System.err.println("disposing Characteristic " + s);
  }
}

class Description {
  private String s;
  Description(String s) {
    this.s = s;
    System.err.println("Creating Description " + s);
  }
  protected void dispose() {
    System.err.println("disposing Description " + s);
  }
}

class LivingCreature {
  private Characteristic p =
    new Characteristic("is alive");
  private Description t =
    new Description("Basic Living Creature");
  LivingCreature() {
    System.err.println("LivingCreature()");
  }
  protected void dispose() {
    System.err.println("LivingCreature dispose");
    t.dispose();
    p.dispose();
  }
}

class Animal extends LivingCreature {
  private Characteristic p =
    new Characteristic("has heart");
  private Description t =
    new Description("Animal not Vegetable");
  Animal() { System.err.println("Animal()"); }
  @Override
  protected void dispose() {
    System.err.println("Animal dispose");
    t.dispose();
    p.dispose();
    super.dispose();
  }
}

class Amphibian extends Animal {
  private Characteristic p =
    new Characteristic("can live in water");
  private Description t =
    new Description("Both water and land");
  Amphibian() {
    System.err.println("Amphibian()");
  }
  @Override
  protected void dispose() {
    System.err.println("Amphibian dispose");
    t.dispose();
    p.dispose();
    super.dispose();
  }
}

public class Frog extends Amphibian {
  private Characteristic p =
    new Characteristic("Croaks");
  private Description t = new Description("Eats Bugs");
  public Frog() { System.err.println("Frog()"); }
  @Override
  protected void dispose() {
    System.err.println("Frog dispose");
    t.dispose();
    p.dispose();
    super.dispose();
  }
  public static void main(String[] args) {
    Frog frog = new Frog();
    System.err.println("Bye!");
    frog.dispose();
  }
}
/* Output:
Creating Characteristic is alive
Creating Description Basic Living Creature
LivingCreature()
Creating Characteristic has heart
Creating Description Animal not Vegetable
Animal()
Creating Characteristic can live in water
Creating Description Both water and land
Amphibian()
Creating Characteristic Croaks
Creating Description Eats Bugs
Frog()
Bye!
Frog dispose
disposing Description Eats Bugs
disposing Characteristic Croaks
Amphibian dispose
disposing Description Both water and land
disposing Characteristic can live in water
Animal dispose
disposing Description Animal not Vegetable
disposing Characteristic has heart
LivingCreature dispose
disposing Description Basic Living Creature
disposing Characteristic is alive
*/
/**
 * self-note:
 *
 * 对象销毁的顺序应该与初始化的顺序相反，以防一个对象依赖另一个对象。
 * 属性销毁的顺序与声明的顺序相反（因为属性是按照声明顺序初始化的）。
 * 首先进行派生类的清理工作，然后才是基类的清理。
 * 这是因为派生类的清理可能调用基类的一些方法，所以基类组件这时得存活，不能过早地被销毁。
 * 尽管通常不必进行清理工作，但万一需要时，就得谨慎小心地执行。
 */

// interfaces/interfaceprocessor/FilterProcessor.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java interfaces.interfaceprocessor.FilterProcessor}
//package interfaces.interfaceprocessor;
//import interfaces.filters.*;
//import interfaces;
package interfaceprocessor;
import filters.*;

class FilterAdapter implements Processor {
  Filter filter;
  FilterAdapter(Filter filter) {
    this.filter = filter;
  }
  @Override
  public String name() { return filter.name(); }
  @Override
  public Waveform process(Object input) {
    return filter.process((Waveform)input);
  }
}

public class FilterProcessor {
  public static void main(String[] args) {
    Waveform w = new Waveform();
    Applicator.apply(
      new FilterAdapter(new LowPass(1.0)), w);
   Applicator.apply(
      new FilterAdapter(new HighPass(2.0)), w);
   Applicator.apply(
      new FilterAdapter(new BandPass(3.0, 4.0)), w);//self-note: 对于filter及其派生类来说,没有任何改动,但是能用apply方法了; 完全解耦
    Upcase p = new Upcase();
    Applicator.apply(
            p, "sss");//除了开始将Processor改为接口外,也没有别的改动了.
  }
}
/* Output:
Using Processor LowPass
Waveform 0
Using Processor HighPass
Waveform 0
Using Processor BandPass
Waveform 0

self-note: 这种使用适配器的方式设计模式中，
FilterAdapter 的构造器接受已有的接口 Filter，继而产生需要的 Processor 接口的对象。
你可能还注意到 FilterAdapter 中使用了委托。


对象适配器模式
设计思路

     对象适配器模式主要应用于新的需求的一个（抽象）基类。
     在这里我们不能使用类适配器模式的所用到的继承父类、实现接口的方式去满足目标需求，因为java中不允许多根继承，只能单根继承，
     我们也就无法在继承（目标需求）抽象类的同时再去继承原有的类（复用原代码）。
     此时定义一个新类（适配者），将一个原有的类（被适配者）作为成员变量放在这个类中，此类还要继承目标抽象类，并实现其中的抽象方法。

     对象适配器模式同样需要定义一个适配器类，它继承需求对应的（抽象）类，
     将现有的业务类作为适配器的一个成员变量，并用构造方法传入业务类实例对象的引用，以初始化此成员变量；
     在实现父类的抽象方法中使用委托机制(某个方法将实际处理工作交给其他对象的方法去完成)，
     让成员变量（现有业务类对象）调用自己的方法。

*/

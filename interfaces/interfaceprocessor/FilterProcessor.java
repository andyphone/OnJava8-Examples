// interfaces/interfaceprocessor/FilterProcessor.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java interfaces.interfaceprocessor.FilterProcessor}
package interfaces.interfaceprocessor;
import interfaces.filters.*;

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
      new FilterAdapter(new BandPass(3.0, 4.0)), w);
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
*/

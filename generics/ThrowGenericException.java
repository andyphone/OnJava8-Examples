// generics/ThrowGenericException.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E> processor : this) {
          processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception {
}

class Processor1 implements Processor<String, Failure1> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        System.err.println("count:"+count);
        if (count-- > 1) {
          resultCollector.add("Hep!");
        } else {
          resultCollector.add("Ho!");
        }
        if (count < 0) {
          throw new Failure1();
        }
    }
}

class Failure2 extends Exception {
}

class Processor2 implements Processor<Integer, Failure2> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        System.err.println("Processor2 count:"+count);

        if (count-- == 0) {
          resultCollector.add(47);
            System.err.println("47");
        } else {
            resultCollector.add(11);
            System.err.println("11");

        }
        if (count < 0) {
          throw new Failure2();
        }
    }
}

public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String, Failure1> runner = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
          runner.add(new Processor1());
        }
        try {
            System.err.println(runner.processAll());
        } catch (Failure1 e) {
            System.err.println(e);
        }

        ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
          runner2.add(new Processor2());
        }
        try {
            List<Integer> x = runner2.processAll();
            System.err.println("x:"+x);//processAll()抛出异常，因此没有打印 收集参数
        } catch (Failure2 e) {
            System.err.println(e);
        }
    }
}
/* Output:
[Hep!, Hep!, Ho!]
Failure2
*/

// streams/SpecialCollector.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;
import java.util.stream.*;

public class SpecialCollector {
  public static void
  main(String[] args) throws Exception {
    ArrayList<String> words =
      FileToWords.stream("D:\\GitOnlyTestProject\\OnJava8-Examples\\streams\\Cheese.dat")
//        .parallel()
              .collect(
//                ArrayList::new,
                ()->{ System.err.println("NEW");return new ArrayList<>();},
                 ArrayList::add,
                 ArrayList::addAll); //self-note: [非并发时]该参数无效
                            //该参数包含两个方法combiner以及finisher: finisher将结果容器转换成最终的返回结果。如果结果容器类型和最终返回结果类型一致，那么finisher就可以不执行
    words.stream()
//      .filter(s -> s.equals("cheese"))
      .forEach(System.out::println);
  }
}
/* Output:
cheese
cheese
*/

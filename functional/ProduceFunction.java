// functional/ProduceFunction.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;

interface FuncSS extends Function<String, String> {
} // [1]

public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase(); //self-note: produce()是高阶函数, 意思是一个消费或返回函数的函数。
        // [2]
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.err.println(f.apply("YELLING"));
    }
}
/* Output:
yelling
*/

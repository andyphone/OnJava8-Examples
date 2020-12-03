// functional/Strategize.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

interface Strategy {
  String approach(String msg);
}

class Soft implements Strategy {
  @Override
  public String approach(String msg) {
    return msg.toLowerCase() + "?";
  }
}

class Unrelated {
  static String twice(String msg) {
    return msg + " " + msg;
  }
}

public class Strategize {
  Strategy strategy;
  String msg;
  Strategize(String msg) {
    strategy = new Soft(); // [1]
    this.msg = msg;
  }
  void communicate() {
    System.err.println(strategy.approach(msg));
  }
  void changeStrategy(Strategy strategy) {
    this.strategy = strategy;
  }


  public static void main(String[] args) {
    Strategy[] strategies = {

      //fun1
      new Strategy() { // [2]
        @Override
        public String approach(String msg) {
          return msg.toUpperCase() + "!";
        }
      },
      //fun1的简写 msg -> msg.toUpperCase() + "!",
      msg -> msg.substring(0, 5), // [3]
      Unrelated::twice // [4]
    };
    Strategize s = new Strategize("Hello there");
    s.communicate();  //最原始


    for(Strategy newStrategy : strategies) {
      s.changeStrategy(newStrategy); // [5]
      s.communicate(); // [6]   //余下的几种
    }
  }
}
/* Output:
hello there?
HELLO THERE!
Hello
Hello there Hello there
*/

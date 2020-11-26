// reuse/Chess.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Inheritance, constructors and arguments

class Game {
  Game(int i) {
    System.err.println("Game constructor");
  }
}

class BoardGame extends Game {
  BoardGame(int i) {
    super(i);
    System.err.println("BoardGame constructor");
  }
}

public class Chess extends BoardGame {
  Chess() {
    super(11);// self-note:如果没有无参数的基类构造函数，或者必须调用具有参数的基类构造函数，
    // 则必须使用 super 关键字和适当的参数列表显式地编写对基类构造函数的调用。
    System.err.println("Chess constructor");
  }
  public static void main(String[] args) {
    Chess x = new Chess();
  }
}
/* Output:
Game constructor
BoardGame constructor
Chess constructor
*/

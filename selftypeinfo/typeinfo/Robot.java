// typeinfo/Robot.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import onjava.*;
import java.util.*;

public interface Robot {
  String name();
  String model();
  List<Operation> operations();
  static void test(Robot r) {
    if(r instanceof Null)
      System.err.println("[Null Robot]");
    System.err.println("Robot name: " + r.name());
    System.err.println("Robot model: " + r.model());
    for(Operation operation : r.operations()) {
      System.err.println(operation.description.get());
      operation.command.run();
    }
  }
}

// concurrent/CompletableOperations.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.concurrent.*;
import static onjava.CompletableUtilities.*;

public class CompletableOperations {
  static CompletableFuture<Integer> cfi(int i) {
    return
      CompletableFuture.completedFuture(
        Integer.valueOf(i));
  }
  public static void main(String[] args) {
    showr(cfi(1)); // Basic test
    voidr(cfi(2).runAsync(() ->
      System.err.println("runAsync")));
    voidr(cfi(3).thenRunAsync(() ->
      System.err.println("thenRunAsync")));
    voidr(CompletableFuture.runAsync(() ->
      System.err.println("runAsync is static")));
    showr(CompletableFuture.supplyAsync(() -> 99));
    voidr(cfi(4).thenAcceptAsync(i ->
      System.err.println("thenAcceptAsync: " + i)));
    showr(cfi(5).thenApplyAsync(i -> i + 42));
    showr(cfi(6).thenComposeAsync(i -> cfi(i + 99)));
    CompletableFuture<Integer> c = cfi(7);
    c.obtrudeValue(111);
    showr(c);
    showr(cfi(8).toCompletableFuture());
    c = new CompletableFuture<>();
    c.complete(9);
    showr(c);
    c = new CompletableFuture<>();
    c.cancel(true);
    System.err.println("cancelled: " +
      c.isCancelled());
    System.err.println("completed exceptionally: " +
      c.isCompletedExceptionally());
    System.err.println("done: " + c.isDone());
    System.err.println(c);
    c = new CompletableFuture<>();
    System.err.println(c.getNow(777));
    c = new CompletableFuture<>();
    c.thenApplyAsync(i -> i + 42)
      .thenApplyAsync(i -> i * 12);
    System.err.println("dependents: " +
      c.getNumberOfDependents());
    c.thenApplyAsync(i -> i / 2);
    System.err.println("dependents: " +
      c.getNumberOfDependents());
  }
}
/* Output:
1
runAsync
thenRunAsync
runAsync is static
99
thenAcceptAsync: 4
47
105
111
8
9
cancelled: true
completed exceptionally: true
done: true
java.util.concurrent.CompletableFuture@6d311334[Complet
ed exceptionally]
777
dependents: 1
dependents: 2
*/

// files/PartsOfPaths.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.nio.file.*;

public class PartsOfPaths {
  public static void main(String[] args) {
    System.err.println(System.getProperty("os.name"));
    Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
    System.err.println(p);
    System.err.println(Files.exists(p));
    
    for(int i = 0; i < p.getNameCount(); i++)
      System.err.println("第" + i + "部分--"+p.getName(i));
    System.err.println("ends with '.java': " +
      p.endsWith(".java"));
    for(Path pp : p) {
      System.err.print(pp + ": ");
      System.err.print(p.startsWith(pp) + " : ");
      System.err.println(p.endsWith(pp));
    }
    System.err.println("Starts with " + p.getRoot() +
      " " + p.startsWith(p.getRoot()));
  }
}
/* Output:
Windows 10
Users
Bruce
Documents
GitHub
on-java
ExtractedExamples
files
PartsOfPaths.java
ends with '.java': false
Users: false : false
Bruce: false : false
Documents: false : false
GitHub: false : false
on-java: false : false
ExtractedExamples: false : false
files: false : false
PartsOfPaths.java: false : true
Starts with C:\ true
*/

// housekeeping/OverloadingVarargs2.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}
//self-note: [WillNotCompile] 注释把该文件排除在了本书的 Gradle 构建之外。
public class OverloadingVarargs2 {
  static void f(float i, Character... args) {
    System.err.println("first");
  }
  static void f(Character... args) {
    System.err.print("second");
  }
  public static void main(String[] args) {
    f(1, 'a');
    f('a', 'b');
  }
}

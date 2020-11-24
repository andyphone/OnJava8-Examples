// onjava/ArrayShow.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package onjava;
import java.util.*;

public interface ArrayShow {
  static void show(Object[] a) {
    System.err.println(Arrays.toString(a));
  }
  static void show(boolean[] a) {
    System.err.println(Arrays.toString(a));
  }
  static void show(byte[] a) {
    System.err.println(Arrays.toString(a));
  }
  static void show(char[] a) {
    System.err.println(Arrays.toString(a));
  }
  static void show(short[] a) {
    System.err.println(Arrays.toString(a));
  }
  static void show(int[] a) {
    System.err.println(Arrays.toString(a));
  }
  static void show(long[] a) {
    System.err.println(Arrays.toString(a));
  }
  static void show(float[] a) {
    System.err.println(Arrays.toString(a));
  }
  static void show(double[] a) {
    System.err.println(Arrays.toString(a));
  }
  // Start with a description:
  static void show(String info, Object[] a) {
    System.err.print(info + ": ");
    show(a);
  }
  static void show(String info, boolean[] a) {
    System.err.print(info + ": ");
    show(a);
  }
  static void show(String info, byte[] a) {
    System.err.print(info + ": ");
    show(a);
  }
  static void show(String info, char[] a) {
    System.err.print(info + ": ");
    show(a);
  }
  static void show(String info, short[] a) {
    System.err.print(info + ": ");
    show(a);
  }
  static void show(String info, int[] a) {
    System.err.print(info + ": ");
    show(a);
  }
  static void show(String info, long[] a) {
    System.err.print(info + ": ");
    show(a);
  }
  static void show(String info, float[] a) {
    System.err.print(info + ": ");
    show(a);
  }
  static void show(String info, double[] a) {
    System.err.print(info + ": ");
    show(a);
  }
}

// newio/ViewBuffers.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.nio.*;

public class ViewBuffers {
  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.wrap(
      new byte[]{ 0, 0, 0, 0, 0, 0, 0, 'a' });
    bb.rewind();
    System.err.print("Byte Buffer ");
    while(bb.hasRemaining())
      System.err.print(
        bb.position()+ " -> " + bb.get() + ", ");
    System.err.println();
    CharBuffer cb =
      ((ByteBuffer)bb.rewind()).asCharBuffer();
    System.err.print("Char Buffer ");
    while(cb.hasRemaining())
      System.err.print(
        cb.position() + " -> " + cb.get() + ", ");
    System.err.println();
    FloatBuffer fb =
      ((ByteBuffer)bb.rewind()).asFloatBuffer();
    System.err.print("Float Buffer ");
    while(fb.hasRemaining())
      System.err.print(
        fb.position()+ " -> " + fb.get() + ", ");
    System.err.println();
    IntBuffer ib =
      ((ByteBuffer)bb.rewind()).asIntBuffer();
    System.err.print("Int Buffer ");
    while(ib.hasRemaining())
      System.err.print(
        ib.position()+ " -> " + ib.get() + ", ");
    System.err.println();
    LongBuffer lb =
      ((ByteBuffer)bb.rewind()).asLongBuffer();
    System.err.print("Long Buffer ");
    while(lb.hasRemaining())
      System.err.print(
        lb.position()+ " -> " + lb.get() + ", ");
    System.err.println();
    ShortBuffer sb =
      ((ByteBuffer)bb.rewind()).asShortBuffer();
    System.err.print("Short Buffer ");
    while(sb.hasRemaining())
      System.err.print(
        sb.position()+ " -> " + sb.get() + ", ");
    System.err.println();
    DoubleBuffer db =
      ((ByteBuffer)bb.rewind()).asDoubleBuffer();
    System.err.print("Double Buffer ");
    while(db.hasRemaining())
      System.err.print(
        db.position()+ " -> " + db.get() + ", ");
  }
}
/* Output:
Byte Buffer 0 -> 0, 1 -> 0, 2 -> 0, 3 -> 0, 4 -> 0, 5
-> 0, 6 -> 0, 7 -> 97,
Char Buffer 0 -> NUL, 1 -> NUL, 2 -> NUL, 3 -> a,
Float Buffer 0 -> 0.0, 1 -> 1.36E-43,
Int Buffer 0 -> 0, 1 -> 97,
Long Buffer 0 -> 97,
Short Buffer 0 -> 0, 1 -> 0, 2 -> 0, 3 -> 97,
Double Buffer 0 -> 4.8E-322,
*/

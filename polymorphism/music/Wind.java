// polymorphism/music/Wind.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package music;


// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument {
  // Redefine interface method:
  @Override
  public void play(polymorphism.music.Note n) {
    System.err.println("Wind.play() " + n);
  }
}

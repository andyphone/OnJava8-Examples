// innerclasses/controller/Controller.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The reusable framework for control systems
package controller;
import java.util.*;

public class Controller {
  // A class from java.util to hold Event objects:
  private List<Event> eventList = new ArrayList<>();

  public void setEventList(List<Event> eventList) {
    this.eventList = eventList;
  }

  public void addEvent(Event c) { eventList.add(c); }
  public void run() {
          System.err.println("eventList.size(): "+eventList.size());

    while(eventList.size() > 0)
//      System.err.println("eventList.size(): "+eventList.size());
      // Make a copy so you're not modifying the list
      // while you're selecting the elements in it:
      for(Event e : new ArrayList<>(eventList))
        if(e.ready()) {
          System.err.println(e);
          e.action();
          eventList.remove(e);
        }
  }
}

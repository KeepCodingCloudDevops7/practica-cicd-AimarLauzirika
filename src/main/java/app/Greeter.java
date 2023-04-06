package main.java.app;

import java.time.LocalTime;

public class Greeter {

  public LocalTime getLocalTime() {
    LocalTime lt = LocalTime.now();
    
    return lt;
  }

  public LocalTime getSleepTime() {

    LocalTime sleepTime = LocalTime.parse("23:00");

    return sleepTime;
  }
}

package main.java.app;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Greeter {

  public LocalTime getLocalTime() {
    
    LocalTime lt = LocalTime.now();
    
    return lt;
  }

  public LocalTime getSleepTime() {

    LocalTime sleepTime = LocalTime.parse("23:00");

    return sleepTime;
  }

  public long diffHours() {
    
    LocalTime lt = getLocalTime();
    LocalTime sleepTime = getSleepTime();
    long diffHours = lt.until(sleepTime, ChronoUnit.HOURS);
    
    return diffHours;
  }

  public long diffMinutes() {
    
    LocalTime lt = getLocalTime();
    LocalTime sleepTime = getSleepTime();
    long diffMinutes = lt.until(sleepTime, ChronoUnit.MINUTES);
    
    return diffMinutes;
  }
}

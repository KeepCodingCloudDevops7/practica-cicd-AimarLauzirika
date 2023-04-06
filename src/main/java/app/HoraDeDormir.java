package main.java.app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HoraDeDormir {
  public static void main(String[] args) {

    Greeter greeter = new Greeter();
    
    LocalTime lt = greeter.getLocalTime();
    LocalTime sleepTime = greeter.getSleepTime();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String timeNow = lt.format(formatter);

    System.out.println("Son las " + timeNow);
    System.out.println("La hora de dormir es a las " + sleepTime);

    
    long horas = lt.until(sleepTime, ChronoUnit.HOURS);
    long minutos = lt.until(sleepTime, ChronoUnit.MINUTES);

    if (minutos < 1) {
      System.out.println("Ya deberias estar durmiendo.");
      return;
    }

    if (horas > 0) {

      long mins = minutos - (60 * horas);
      System.out.println("Te quedan " + horas + " horas y " + mins + " minutos para ir a dormir.");

      return;
    }

    if (horas < 1) {
      System.out.println("Te quedan " + minutos + " minutos para ir a dormir.");
    }


  }

}
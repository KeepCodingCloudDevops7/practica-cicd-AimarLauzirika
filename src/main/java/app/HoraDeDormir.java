package main.java.app;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class HoraDeDormir {
  public static void main(String[] args) {

    LocalTime lt = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime sleepTime = LocalTime.parse("23:00");

    System.out.println("Son las " + lt.format(formatter));
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
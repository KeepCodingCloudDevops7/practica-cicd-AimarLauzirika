package main.java.app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HoraDeDormir {
  public static void main(String[] args) {

    Greeter greeter = new Greeter();
    
    LocalTime lt = greeter.getLocalTime();
    LocalTime sleepTime = greeter.getSleepTime();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String timeNow = lt.format(formatter);

    System.out.println("Son las " + timeNow);
    System.out.println("La hora de dormir es a las " + sleepTime);

    
    long diffHours = greeter.diffHours();
    long diffMinutes = greeter.diffMinutes();

    if (diffMinutes < 1) {
      System.out.println("Ya deberias estar durmiendo.");
      return;
    }

    if (diffHours > 0) {

      long mins = diffMinutes - (60 * diffHours);
      System.out.println("Te quedan " + diffHours + " horas y " + mins + " minutos para ir a dormir.");

      return;
    }

    if (diffHours < 1) {
      System.out.println("Te quedan " + diffMinutes + " minutos para ir a dormir.");
    }
  }
}
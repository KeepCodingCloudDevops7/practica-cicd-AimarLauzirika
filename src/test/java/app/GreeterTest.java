package app;

import org.junit.jupiter.api.Test;
import main.java.app.Greeter;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Unit test for simple App.
 */
public class GreeterTest {

  Greeter greeter = new Greeter();

  @Test
  public void testDiffHours() {
    long diffHours = greeter.diffHours();
    assertTrue(diffHours < 23);
  }

  @Test
  public void testDiffMinutes() {
    long diffMinutes = greeter.diffMinutes();
    assertTrue(diffMinutes < 60 * 23);
  }
}
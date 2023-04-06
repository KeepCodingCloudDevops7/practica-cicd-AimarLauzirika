package app;

import org.junit.jupiter.api.Test;
import main.java.app.HoraDeDormir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
 * Unit test for simple App.
 */
public class HelloTest {

  @Test
  public void testTime() {
    HelloWorld app1 = new HelloWorld();
    HelloWorld app2 = new HelloWorld();
    assertNotEquals(app1.getCurrentTime(), app2.getCurrentTime());
  }
}
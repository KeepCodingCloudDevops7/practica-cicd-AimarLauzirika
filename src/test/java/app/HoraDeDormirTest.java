package app;

import org.junit.jupiter.api.Test;
import main.java.app.HoraDeDormir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
 * Unit test for simple App.
 */
public class HoraDeDormirTest {

  @Test
  public void testNotNull() {
    HoraDeDormir app1 = new HoraDeDormir();
    assertNotEquals(app1, null);
  }
}
package telius;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
boolean a = true;
@Test
public void testCheckForRegister() {
    assertEquals(a, Files.checkForRegister(dimitrap,usernames, dataUsernames));
 }
}
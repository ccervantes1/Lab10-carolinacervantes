 package hw;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCountryCodes {

  private CountryCodes fixture;

  @Before
  public void setUp() throws Exception {
    fixture = new CountryCodes();
  }

  @After
  public void tearDown() throws Exception {
    fixture = null;
  }

}

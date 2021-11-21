import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import q1.StringToInteger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

public class StringToIntegerTest {

    @Test
    public void testWriteFormat() {
        assertEquals(12, StringToInteger.convert("12"));
        assertEquals(-356, StringToInteger.convert("-356"));
        assertEquals(5678, StringToInteger.convert("5678"));
    }

    @Test
    public void testWrongPeriod() {
        try{
            StringToInteger.convert("543782");
            fail("An error expected");
        }
        catch(IllegalArgumentException e){
            Assert.assertEquals("Number should be between -32767 and 32767", e.getMessage());
        }
    }

    @Test
    public void testWrongFormat() {
        try{
            StringToInteger.convert("5 437@2");
            fail("An error expected");
        }
        catch(NumberFormatException e){
            Assert.assertEquals("Number should be numerical.", e.getMessage());
        }
    }

    @Test
    public void testNullFormat() {
        try{
            StringToInteger.convert("");
            fail("An error expected");
        }
        catch(NumberFormatException e){
            Assert.assertEquals("Your input must be not null!", e.getMessage());
        }
    }

}

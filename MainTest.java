import org.junit.Assert;
import org.junit.Test;


public class MainTest {

    @Test
    public void testIsWorkOverZero() {
        int inkContainerValue = 100;
        Pen testMin = new Pen(inkContainerValue);
        Assert.assertEquals(true, testMin.isWork());
    }

    @Test
    public void testIsWorkZero() {
        int inkContainerValue = 0;
        Pen testZero = new Pen (inkContainerValue);
        Assert.assertEquals(false, testZero.isWork());
    }

    
    @Test
    public void testIsWorkUnderZero() {
        int inkContainerValue = -100;
        Pen testZero = new Pen (inkContainerValue);
        Assert.assertEquals(false, testZero.isWork());
    }


}


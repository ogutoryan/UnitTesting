import org.junit.Assert;
import org.junit.Test;


public class MainTest {

    //текст + 1 значение из констркутора
    @Test
    public void testWrite() {
        String testWord = "TestAnytext";
        int inkContainerValue = 100;
        Pen testText = new Pen(inkContainerValue);
        String word = testText.write(testWord);
        Assert.assertEquals(testWord, word);
    }

    //текст из букв и символов  + 2 значения из констркутора
    @Test
    public void testWithSimbolsWrite() {
        String testWord = "<test>*(&^%%&^^(&klh^&*Anytext</test>";
        int inkContainerValue = 1025;
        double sizeLetter = 10.1;
        Pen testText = new Pen(inkContainerValue, sizeLetter);
        String word = testText.write(testWord);
        Assert.assertEquals(testWord, word);
    }

    //текст из букв, символов, пробелов + 3 значения из констркутора






    @Test
    public void testIsWorkOverZero() {
        int inkContainerValue = 100;
        Pen testMin = new Pen(inkContainerValue);
        Assert.assertEquals(true, testMin.isWork());
    }

    @Test
    public void testIsWorkZero() {
        int inkContainerValue = 0;
        Pen testZero = new Pen(inkContainerValue);
        Assert.assertEquals(false, testZero.isWork());
    }


    @Test
    public void testIsWorkUnderZero() {
        int inkContainerValue = -100;
        Pen UnderZero = new Pen(inkContainerValue);
        Assert.assertEquals(false, UnderZero.isWork());
    }


}


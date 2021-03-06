import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class MainTest {
    String testWord = "Testing";
    String color = "BLUE";
    String color2 = "RED";

    @Test
    public void inkContainerValueTest() {
        int inkContainerValue = 10;
        Pen testInk = new Pen(inkContainerValue);
        Assert.assertNotNull(testInk);
    }

    @Test
    public void inkAndLetterSizeContainerValueTest() {
        int inkContainerValue = 15;
        double letterSize = 5.0;
        Pen testInkAndSizeLetter = new Pen(inkContainerValue, letterSize);
        Assert.assertNotNull(testInkAndSizeLetter);
    }

    @Test
    public void inkLetterSizeColorContainerValueTest() {
        int inkContainerValue = 20;
        double letterSize = 1.0;
        Pen testInkSizeLetterColorContainerValue = new Pen(inkContainerValue, letterSize, color);
        Assert.assertNotNull(testInkSizeLetterColorContainerValue);
    }

    @Test
    public void writeTest() {
        int inkContainerValue = 100;
        Pen testText = new Pen(inkContainerValue);
        String word = testText.write(testWord);
        Assert.assertEquals(testWord, word);
    }

    @Test
    public void withSimbolsAndTwoArgsWriteTest() {
        String testWord = "<test>*(&^%%&^^(&klh^&*Anytext</test>";
        int inkContainerValue = 1025;
        double letterSize = 10.1;
        Pen testText = new Pen(inkContainerValue, letterSize);
        String word = testText.write(testWord);
        Assert.assertEquals(testWord, word);
    }

    @Test
    public void withSimbolsAndThreeArgsWriteTest() {
        String testWord = "<test>*(&^%875%&^^(&k878lh^&*Anytex87454t</test>1";
        int inkContainerValue = 999;
        double letterSize = 9.8;
        Pen testText = new Pen(inkContainerValue, letterSize, color);
        String word = testText.write(testWord);
        Assert.assertEquals(testWord, word);
    }

    @Test
    public void threeArgsInkZeroWriteTest() {
        int inkContainerValue = 0;
        double letterSize = 15.10;
        Pen testText = new Pen(inkContainerValue, letterSize, color2);
        String word = testText.write(testWord);
        Assert.assertEquals("", word);
    }

    @Test
    public void spaceWriteTest() {
        String testWord = "Testing hello";
        int inkContainerValue = 12;
        double letterSize = 1;
        Pen testText = new Pen(inkContainerValue, letterSize, color);
        String word = testText.write(testWord);
        Assert.assertEquals("Testing hello", word);
    }

    @Test
    public void letterSizeMoreThanInkTest() {
        int inkContainerValue = 2;
        double letterSize = 3;
        Pen testText = new Pen(inkContainerValue, letterSize, color);
        String word = testText.write(testWord);
        Assert.assertEquals("", word);
    }

    @Test
    public void partOfWordWriteTest() {
        int inkContainerValue = 2;
        double letterSize = 1.0;
        Pen testText = new Pen(inkContainerValue, letterSize, color);
        String word = testText.write(testWord);
        String partOfWord = word.substring(0, inkContainerValue);
        Assert.assertEquals("Te", partOfWord);
    }

    @Test
    public void letterSizeMoreThanInkContainerValueTest() {
        int inkContainerValue = 2;
        double letterSize = 5.0;
        Pen testText = new Pen(inkContainerValue, letterSize, color);
        String word = testText.write(testWord);
        String partOfWord = word.substring(0, inkContainerValue);
        Assert.assertEquals("", partOfWord);
    }

    @Test
    public void wordSizeMoreThanInkContainerValueTest() {
        int inkContainerValue = 7;
        double letterSize = 3.5;
        Pen testText = new Pen(inkContainerValue, letterSize, color);
        String word = testText.write(testWord);
        String partOfWord = word.substring(0, inkContainerValue);
        Assert.assertEquals("Te", partOfWord);
    }

    @Test
    public void partOfInkContainerValueWriteTest() {
        String testWord2 = "Authotesting";
        int inkContainerValue = 10;
        double letterSize = 1.0;
        Pen testText = new Pen(inkContainerValue, letterSize, color);
        String word1 = testText.write(testWord);
        String word2 = testText.write(testWord2);
        Assert.assertEquals("Testing", word1);
        Assert.assertEquals("Aut", word2);
    }

    @Test
    public void isWorkOverZeroTest() {
        int inkContainerValue = 100;
        Pen testMin = new Pen(inkContainerValue);
        Assert.assertEquals(true, testMin.isWork());
    }

    @Test
    public void isWorkZeroTest() {
        int inkContainerValue = 0;
        Pen testZero = new Pen(inkContainerValue);
        Assert.assertEquals(false, testZero.isWork());
    }

    @Test
    public void isWorkUnderZeroTest() {
        int inkContainerValue = -100;
        Pen underZero = new Pen(inkContainerValue);
        Assert.assertEquals(false, underZero.isWork());
    }

    @Test
    public void getColorTest() {
        int inkContainerValue = 99;
        double letterSize = 2.0;
        Pen testOfGetColor = new Pen(inkContainerValue, letterSize, color);
        Assert.assertEquals(color, testOfGetColor.getColor());
    }

    @Test
    public void getRedColorTest() {
        int inkContainerValue = 100;
        double letterSize = 3;
        Pen testOfGetColor = new Pen(inkContainerValue, letterSize, color2);
        Assert.assertEquals(color2, testOfGetColor.getColor());
    }


    @Test
    public void doSomethingElseTest() throws IOException {
        int inkContainerValue = 30;
        double letterSize = 1.0;
        Pen testPenThreeArgs = new Pen(inkContainerValue, letterSize, color2);
        File f = new File("1.txt"); //  создаем файл
        PrintStream ps = new PrintStream(f); // создаем поток вывода в файл
        PrintStream standardOut = System.out; // сохраняем стандартный поток вывода
        System.setOut(ps); // присваиваем файловый поток в качестве основного
        testPenThreeArgs.doSomethingElse(); // вызываем метод
        System.setOut(standardOut); // возвращаем метод в исходное состояние
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String line;
        line = fin.readLine();
        Assert.assertEquals(color2, line);
    }
}


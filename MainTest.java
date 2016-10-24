import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.System.out;


public class MainTest {

    //конструктор

    //только inkContainerValue из конструктора
    @Test
    public void JustInkContainerValue() {
        int inkContainerValue = 10;
        Pen testInk = new Pen(inkContainerValue);
        Assert.assertNotNull(testInk);
    }

//ink и letterSize из конструктора

    @Test
    public void InkAndSizeLetterContainerValue() {
        int inkContainerValue = 15;
        double sizeLetter = 5.0;
        Pen testInkAndSizeLetter = new Pen(inkContainerValue, sizeLetter);
        Assert.assertNotNull(testInkAndSizeLetter);
    }

//ink, letterSize, Color из конструктора

    @Test
    public void InkLetterSizeColorContainerValue() {
        int inkContainerValue = 20;
        double sizeLetter = 1.0;
        String color = "BLUE";
        Pen testInkSizeLetterColorContainerValue = new Pen(inkContainerValue, sizeLetter, color);
        Assert.assertNotNull(testInkSizeLetterColorContainerValue);
    }

    //write----------

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
    public void testWithSimbolsAndTwoArgsWrite() {
        String testWord = "<test>*(&^%%&^^(&klh^&*Anytext</test>";
        int inkContainerValue = 1025;
        double sizeLetter = 10.1;
        Pen testText = new Pen(inkContainerValue, sizeLetter);
        String word = testText.write(testWord);
        Assert.assertEquals(testWord, word);
    }

    //текст из букв и символов + 3 значения из констркутора

    @Test
    public void testWithSimbolsAndThreeArgsWrite() {
        String testWord = "<test>*(&^%875%&^^(&k878lh^&*Anytex87454t</test>1";
        int inkContainerValue = 999;
        double sizeLetter = 9.8;
        String color = "BLUE";
        Pen testText = new Pen(inkContainerValue, sizeLetter, color);
        String word = testText.write(testWord);
        Assert.assertEquals(testWord, word);
    }

    //текст  + 3 значения из конструктора, inkCOntainerValue = 0


    @Test
    public void testAndThreeArgsInkZeroWrite() {
        String testWord = "Life is beautiful";
        int inkContainerValue = 0;
        double sizeLetter = 15.10;
        String color = "RED";
        Pen testText = new Pen(inkContainerValue, sizeLetter, color);
        String word = testText.write(testWord);
        Assert.assertEquals("", word);
    }

    //With Space

    @Test
    public void testSpaceWrite() {
        String testWord = "Testing hello";
        int inkContainerValue = 10;
        double sizeLetter = 15.10;
        String color = "BLUE";
        Pen testText = new Pen(inkContainerValue, sizeLetter, color);
        String word = testText.write(testWord);
        String partOfWord = word.substring(0, inkContainerValue);
        Assert.assertEquals("Testing hel", partOfWord);
    }

    //partOfWord
    @Test
    public void testPartOfWordWrite() {
        String testWord = "Testing";
        int inkContainerValue = 2;
        double sizeLetter = 1.0;
        String color = "BLUE";
        Pen testText = new Pen(inkContainerValue, sizeLetter, color);
        String word = testText.write(testWord);
        String partOfWord = word.substring(0, inkContainerValue);
        Assert.assertEquals("Te", partOfWord);
    }

    //sizeLetter > inkContainerValue
    @Test
    public void testSizeLetterMoreThanInkContainerValue() {
        String testWord = "Testing";
        int inkContainerValue = 2;
        double sizeLetter = 5.0;
        String color = "BLUE";
        Pen testText = new Pen(inkContainerValue, sizeLetter, color);
        String word = testText.write(testWord);
        String partOfWord = word.substring(0, inkContainerValue);
        Assert.assertEquals("", partOfWord);
    }

    //sizeWord > inkContainerValue
    @Test
    public void testSizeWordMoreThanInkContainerValue() {
        String testWord = "Testing";
        int inkContainerValue = 10;
        double sizeLetter = 5.0;
        String color = "BLUE";
        Pen testText = new Pen(inkContainerValue, sizeLetter, color);
        String word = testText.write(testWord);
        String partOfWord = word.substring(0, inkContainerValue);
        Assert.assertEquals("Te", partOfWord);
    }

    //inkContainerValue != 0
    @Test
    public void testPartOfInkContainerValueWrite() {
        String testWord1 = "Testing";
        String testWord2 = "Authotesting";
        int inkContainerValue = 10;
        double sizeLetter = 1.0;
        String color = "BLUE";
        Pen testText = new Pen(inkContainerValue, sizeLetter);
        String word = testText.write(testWord1);
        String word2 = testText.write(testWord2);
        Assert.assertEquals("Testing", testWord1);
        Assert.assertEquals("Aut", testWord2);
    }

    // isWork------------------------------

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
        Pen underZero = new Pen(inkContainerValue);
        Assert.assertEquals(false, underZero.isWork());
    }

    //getColor
    @Test
    public void getColor() {
        int inkContainerValue = 99;
        double sizeLetter = 2.0;
        String testGetColor = "RED";
        Pen testOfGetColor = new Pen(inkContainerValue, sizeLetter, testGetColor);
        Assert.fail(testOfGetColor.getColor());
    }

    //do somethingElse

    @Test
    public void testDoSomethingElse() throws IOException {
        int inkContainerValue = 30;
        double sizeLetter = 1.0;
        String testColor = "RED";
        Pen testPenThreeArgs = new Pen(inkContainerValue, sizeLetter, testColor);
        File forTestFile = new File("d:\\1.txt"); //  создаем файл
        PrintStream ps = new PrintStream(forTestFile); // создаем поток вывода в файл
        PrintStream standardOut = System.out; // сохраняем стандартный поток вывода
        System.setOut(ps); // присваиваем файловый поток в качестве основного
        testPenThreeArgs.doSomethingElse(); // вызываем метод
        System.setOut(standardOut); // возвращаем метод в исходное состояние
        BufferedReader fin = new BufferedReader(new FileReader(forTestFile));
        String line;
        line = fin.readLine();
        Assert.assertEquals(testColor, line);

    }
}

import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XPathSelectorsTest {
    private WebDriver driver;

    private static final String absolutePath = "/html/body/div";

    private static final String allElementsInHTMLPath = "//*";  // Все элементы на странице начиная с html - тэга

    private static final String bodyPath = "//body";  // Элемент по тэгу

    private static final String childPath = "//form/input";  // Дочерний элемент относительно родителя

    private static final String tagWithAttrPath = "//span[@id='access--1']";  // Поиск элемента с аттрибутом и его значением

    private static final String parentPath1 = "//span[@id='access--1']//..";  // Поиск родителя у элемента с аттрибутом и его значением
    private static final String parentPath2 = "//*[@id='suite_mode_single']/parent::label;";  // Поиск родителя у элемента с аттрибутом и его значением

    private static final String elementByIndexPath = "(//form)[4]";  // Поиск элемента по индексу

    private static final String searchByTextPath = "//*[text()='New Widget']";  // Поиск элемента по полному соответствию по тексту
    private static final String searchByTextPath1 = "//*[.='New Widget']";  // Поиск элемента по полному соответствию по тексту

    private static final String searchBySubstringPath = "//*[contains(text(),'Widget')]";   // Поиск элемента по подстроке в тексте

    private static final String searchByStartsWithPath = "//input[starts-with(@type, 'hi')]";//Поиск элемента по аттрибуту значение которого начинается с
    private static final String searchByTwoAttrPath = "//*[@class='form-control ' and @type='text']";   // Использование логического оператора

    private static final String searchBySpecificAttrPath = "//input[@type != 'hidden']";   // Использование логического оператора

    //Axes - Оси
    //Использование ancestor - все предки текущего узла
    private static final String path1 = "//*[@id='suite_mode_single_baseline']/ancestor::div";

    //Использование child - все предки текущего узла зависят от уровня
    private static final String path2_1 = "//ul/child::li";
    private static final String path2_2 = "//ul/li";  // аналог только проще

    //Использование descendant - Все предки текущего узла не зависимо от уровня
    private static final String path3_1 = "//ul/descendant::span";
    private static final String path3_2 = "//ul//span";  // аналог только проще

    //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
    private static final String path4_1 = "//label[@for='announcement']/following::form";
    private static final String path4_2 = "(//label[@for='announcement']/following::div/*[@class='checkbox'])[1]";

    //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
    private static final String path5_1 = "//label[@for='announcement']/following-sibling::div";

    //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
    private static final String path6_1 = "//label[@for='announcement']/preceding::div";

    //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
    private static final String path7_1 = "//label[@for='announcement']/preceding-sibling::div";

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicXPathSelectors() {
        driver.get(ReadProperties.getUrl());

        // Абсолютный xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[1]/div/div[2]")).isDisplayed());

        // Все эелемнты на странице начина с HTML
        driver.findElements(By.xpath("//*"));

        // Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // Аналог родительского div и на один уровень ниже р1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        // Аналог родительского div и на любом уровене ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        // Поиск элемента с тэгом div у которого есть аьттрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением top-logo
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут method cо значением и фттрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());

        // Поиск элемента у которого значение аттрибута начинается с
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'new')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'Template')]")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'All Projects']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'Todos']")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'All Projects')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());
    }

    @Test
    public void axesXPathTest() {
        driver.get(ReadProperties.getUrl());

        // Поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        // Использование descendant - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::a")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following-sibling::form")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dialog-title\"]/preceding::form")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
    }
}


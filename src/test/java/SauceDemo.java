import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemo {
    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicLocatorsAndCssSelected() throws InterruptedException {
        driver.get(ReadProperties.getUrl());
        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        driver.findElement(By.className("submit-button")).click();

        WebElement filter = driver.findElement(By.tagName("select"));
        Select filterDropdown = new Select(filter);
        filterDropdown.selectByIndex(2);

        driver.findElement(By.linkText("Sauce Labs Backpack")).click(); // works for '<a href' only

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();


        driver.findElement(By.partialLinkText("Bolt T-Shirt")).click(); // works for '<a href' only

        Assert.assertTrue(driver.findElement(By.cssSelector("#back-to-products")).isDisplayed());
        driver.findElement(By.cssSelector("#back-to-products")).click();

        // Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#shopping_cart_container")).isDisplayed());

        // Поиск по class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".bm-burger-button")).isDisplayed());

        // Поиск по tag name
        Assert.assertEquals(20, driver.findElements(By.cssSelector("a")).size());

        // Поиск по tag и значению из аттрибута class
        Assert.assertFalse(driver.findElement(By.cssSelector("div.bm-cross-button")).isDisplayed());

        // Использование 2х уровневой иерархии для поиска дочернего элемента
        Assert.assertEquals(6, driver.findElements(By.cssSelector("#inventory_container .inventory_item")).size());

        // Использование 3х уровневой иерархии для поиска дочернего элемента
        Assert.assertEquals(6, driver.findElements(By.cssSelector("#inventory_container .inventory_item .inventory_item_label")).size());

        // Поиск всех элементов с тэгом a или img
        Assert.assertEquals(28, driver.findElements(By.cssSelector("a, img")).size());

        // Поиск всех элементов с тэгом img у которых непосредственный родитель с тэгом div
        Assert.assertEquals(2, driver.findElements(By.cssSelector("div > img")).size());

        // Поиск всех элементов с тэгом div которые идут сразу за элементом с тэго ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + div")).size());

        // Поиск всех элементов с тэгом div которые являются братьями элементу с тэгом div
        Assert.assertEquals(23, driver.findElements(By.cssSelector("div ~ div")).size());

        // Поиск всех элементов у которых присутствует аттрибут name
        Assert.assertEquals(10, driver.findElements(By.cssSelector("[name]")).size());

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='z-index: 1000;']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='pack']")).size());
        driver.findElement(By.cssSelector("[id$='pack']")).click();

        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='t-shirt']")).size());
        driver.findElement(By.cssSelector("[id$='t-shirt']")).click();

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой текст
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[class*=cart_cont]")).size());
        driver.findElement(By.cssSelector("[class*=cart_cont]")).click();

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то слово
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=cart_contents_container]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(4, driver.findElements(By.cssSelector("[id^=c]")).size());

        // Поиск всех элементов у которых присутствует аттрибут name со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[name~=continue-shopping]")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(6, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск по нескольким значениям в аттрибуте class
        Assert.assertEquals(1, driver.findElements(By.cssSelector(".btn.back")).size());
        driver.findElement(By.cssSelector(".btn.back")).click();

        // Поиск всех элементов c пустым телом
        Assert.assertEquals(20, driver.findElements(By.cssSelector(":empty")).size());

        // Поиск элемента с тэгом img и которым является первым дочерним элементом
        Assert.assertEquals(6, driver.findElements(By.cssSelector("img:first-child")).size());

        // Поиск элемента с тэгом img и которым является последним дочерним элементом
        Assert.assertEquals(8, driver.findElements(By.cssSelector("img:last-child")).size());

        // Поиск элемента с тэгом img и которым является n-ым дочерним элементом
        Assert.assertEquals(2, driver.findElements(By.cssSelector("img:nth-child(2)")).size());

        // Абсолютный xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[1]/a/img")).isDisplayed());

        // Все эелемнты на странице начина с HTML
        driver.findElements(By.xpath("//*"));

        // Аналог поиска по tagName
        Assert.assertFalse(driver.findElement(By.xpath("//a")).isDisplayed());

        // Аналог родительского div и на один уровень ниже р1
        Assert.assertTrue(driver.findElement(By.xpath("//div/a")).isDisplayed());

        // Аналог родительского div и на любом уровене ниже a
        Assert.assertFalse(driver.findElement(By.xpath("//div//a")).isDisplayed());

        // Поиск элемента с тэгом div у которого есть аьттрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением inventory_container
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'inventory_container']")).isDisplayed());

        // Поиск элемента у которого значение аттрибута начинается с inventory
        Assert.assertFalse(driver.findElement(By.xpath("//*[starts-with(@id, 'inventory')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'button')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'inventory_item_img']/a[1]")).isDisplayed());

        //Поиск по аттрибуту
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page_wrapper']")).isDisplayed());

        // Поиск по тексту
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed());

        //Поиск по по частичному совпадению тексту
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'with the sleek')]")).isDisplayed());

        //Поиск по по частичному совпадению тексту
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']//ancestor::div")).isDisplayed());

        // Использование descendant - все дочерние элементы с тэго a от div
        Assert.assertFalse(driver.findElement(By.xpath("//div/descendant::a")).isDisplayed());

        //Использование parent
        Assert.assertTrue(driver.findElement(By.xpath("//a/parent::div")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/ancestor::a")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/a/span")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::img")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[@class='inventory_item']/following::img")).isDisplayed());

        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[@class='inventory_item']/following-sibling::div")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[@class='inventory_item']/preceding::img")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[@class='inventory_item']/preceding-sibling::div")).isDisplayed());
    }
}

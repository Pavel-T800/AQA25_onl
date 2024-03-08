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




    }
}
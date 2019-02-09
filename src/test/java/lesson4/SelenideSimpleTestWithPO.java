package lesson4;

import base.lesson3.IndexPage;
import base.lesson4.SelenideBase;
import base.lesson4.SelenideIndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SelenideSimpleTestWithPO extends SelenideBase {

    private SelenideIndexPage indexPage;

    @BeforeMethod
    public void initTest() {
        open("https://epam.github.io/JDI/index.html");
        indexPage = page(SelenideIndexPage.class);
    }

    @AfterMethod
    public void closeTest() {
        close();
    }

    @Test
    public void SimpleTest() {
        indexPage.login("epam", "1234");
    }
}

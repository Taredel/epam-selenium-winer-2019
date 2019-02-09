package lesson4;

import base.utils.Utils;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class SelenideSimpleTest extends Utils{

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }

    @Test
    public void simpleTest() {
        //Configuration.browser = Browsers.FIREFOX;

        //1
        open("https://epam.github.io/JDI/index.html");

        //2
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //3
        $("[id='user-icon']").click(); //CSS selector
        $("[id='name']").sendKeys("epam");
        $("[id='password']").sendKeys("1234");
        $("[id='login-button']").click();

        $("#user-name").shouldHave(text("PITER CHAILOVSKII"));

        //4
        close();
    }
}
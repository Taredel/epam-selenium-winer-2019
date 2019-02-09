package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class hw1 {

        @Test
        public void hw1Test() {
            //1 setting options
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            //2
            driver.navigate().to("https://epam.github.io/JDI/");


            //4 assert log in using certain userID-password
            driver.findElement(By.cssSelector("[id='user-icon']")).click(); //CSS selector
            driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
            driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
            driver.findElement(By.cssSelector("[id='login-button']")).click();


            //5 assert username
            assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

            //6 assert Browser title
            assertEquals(driver.getTitle(), "Home Page");

            //7 assert header section names
            String[] numberOfLines = driver.findElement(By.className("m-l8")).getText().split("\r\n|\r|\n"); //splitting header sections into separate lines
            assertEquals(numberOfLines.length, 4); //assert number of header sections
            assertEquals(driver.findElement(By.cssSelector("[href='index.html']")).getText(), "HOME" );
            assertEquals(driver.findElement(By.cssSelector("[href='contacts.html']")).getText(), "CONTACT FORM" );
            assertEquals(driver.findElement(By.className("dropdown")).getText().trim(), "SERVICE" );
            assertEquals(driver.findElement(By.cssSelector("[href='metals-colors.html']")).getText(), "METALS & COLORS" );

            //8 assert number of images on the Index page and that they are displayed
            //System.out.println(driver.findElement(By.className("benefits")).getText());

            //9 assert texts under of each icon on the Index page

            //10 assert text of the main header
            assertEquals(driver.findElement(By.cssSelector("[name='main-title']")).getText().trim(), "EPAM FRAMEWORK WISHES…" );
            assertEquals(driver.findElement(By.cssSelector("[name='jdi-text']")).getText().trim(),
                    "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                            "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                            "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
                            "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR." );

            // close Browser
            driver.close();
        }
    /*
    */
}

package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClassWork2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // Bu method sayfadaki her bir web elementi icin
                                                                            //max. bekleme suresini belirler

        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        String actualTitle = driver.getTitle();
        if(actualTitle.contains("facebook")) {
            System.out.println("Title Testi PASSED");
        }else {
            System.out.println("Title Testi FAILED --> " + actualTitle);
        }

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains("facebook")) {
            System.out.println("URL TESTI PASSED");
        }else {
            System.out.println("URL TESTI FAILED " +actualUrl);
        }

        //https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com");

        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualWalmartTitle = driver.getTitle();
        String expectedWalmartTitle = "Walmart.com";
        if(actualWalmartTitle.contains(expectedWalmartTitle)) {
            System.out.println("WALMART TITLE TEST PASSED");
        }else {
            System.out.println("WALMART TITLE TEST FAILED");
        }

        //Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();

        //Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //Browser’i kapatin
        driver.close();

    }
}

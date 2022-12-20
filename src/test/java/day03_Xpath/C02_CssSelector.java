package day03_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_CssSelector {
    //1-C01_TekrarTesti isimli bir class olusturun
    //2- https://www.amazon.com/ adresine gidin
    //3- Browseri tam sayfa yapin
    //4- Sayfayi “refresh” yapin
    //5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    //6 Gift Cards sekmesine basin
    //7 Birthday butonuna basin
    //8 Best Seller bolumunden ilk urunu tiklayin
    //9- Gift card details’den 25 $’i secin
    //10- Urun ucretinin 25$ oldugunu test edin
    //10- Sayfayi kapatin
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Spend less";
        if(actualTitle.contains(expectedTitle)) {
            System.out.println("TITLE TEST PASSED");
        }else {
            System.out.println("TITLE TEST FAILED");
        }
        driver.findElement(By.cssSelector("a[href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']")).click();
        driver.findElement(By.cssSelector("img[src='https://images-na.ssl-images-amazon.com/images/G/01/gift-certificates/consumer/2021/GCLP/Support/2x/Occ_Birthday_346x130.png']")).click();
        List<WebElement> bestSellerB = driver.findElements(By.cssSelector("img[alt='Amazon.com eGift Card']"));
        bestSellerB.get(0).click();
        driver.findElement(By.cssSelector("button[value='25']")).click();
        WebElement urunUcreti = driver.findElement(By.cssSelector("span[id='gc-live-preview-amount']"));
        if(urunUcreti.getText().equals("$25.00")) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.close();

    }
}

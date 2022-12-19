package day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Examples {
    static WebDriver driver;
    public static void main(String[] args) {
        /*
            Ilk once browser'i maximize yapalim sonra tum sayfa icin max bekleme suresi olarak 15 saniye belirtelim.
            Sirasiyla amazon,facebook ve youtube sayfalarina gidelim
            Amazon sayfasina tekrar donelim
            Amazon sayfasinin URL'inin https://www.amazon.com adresine esit oldugunu test edelim.
            Sayfanin konumunu ve size'ini yazdiralim
            Sayfanin konumunu ve size'ini istedigimiz sekilde ayarlayalim
            ve istedigimiz sekilde oldugunu test edelim.
            ve sayfayi kapatalim.
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        //Ilk once browser'i maximize yapalim sonra tum sayfa icin max bekleme suresi olarak 15 saniye belirtelim.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Sirasiyla amazon,facebook ve youtube sayfalarina gidelim
        driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().to("https://www.youtube.com");

        //Amazon sayfasina tekrar donelim
        driver.navigate().back();
        driver.navigate().back();

        //Amazon sayfasinin URL'inin https://www.amazon.com adresine esit oldugunu test edelim.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        if(actualUrl.equals(expectedUrl)) {
            System.out.println("URL TESTI PASSED");
        }else {
            System.out.println("URL TESTI FAILED");
        }

        //Sayfanin konumunu ve size'ini yazdiralim
        System.out.println("Sayfanin size'i = "+driver.manage().window().getSize());
        System.out.println("Sayfanin konumu = "+driver.manage().window().getPosition());

        //Sayfanin konumunu ve size'ini istedigimiz sekilde ayarlayalim
        driver.manage().window().setSize(new Dimension(600,600));
        driver.manage().window().setPosition(new Point(50,50));
        System.out.println("Sayfanin yeni size'i = "+driver.manage().window().getSize());
        System.out.println("Sayfanin yeni konumu = "+driver.manage().window().getPosition());

        //ve istedigimiz sekilde oldugunu test edelim.
        Dimension actualYeniSize = driver.manage().window().getSize();
        if(actualYeniSize.getWidth()==600 && actualYeniSize.getWidth()==600) {
            System.out.println("SIZE TESTI PASSED");
        }else {
            System.out.println("SIZE TESTI FAILED");
        }

        Point actualYeniKonum = driver.manage().window().getPosition();
        if(actualYeniKonum.getX()==50 && actualYeniKonum.getY()==50) {
            System.out.println("KONUM TESTI PASSED");
        }else {
            System.out.println("KONUM TESTI FAILED");
        }

        //ve sayfayi kapatalim.
        driver.close();




    }



}

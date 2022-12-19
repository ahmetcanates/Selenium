package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Amazon sayfasina gidelim
        driver.navigate().to("https://amazon.com");
        Thread.sleep(3000);

        //Hepsiburada sayfasina gidelim
        driver.navigate().to("https://techproeducation.com");
        Thread.sleep(3000);

        //Tekrar amazon sayfasina donelim
        driver.navigate().back();//Amazon sayfasina geri doner.
        Thread.sleep(3000);

        //Tekrar hepsiburada sayfasina gidelim
        driver.navigate().forward();//Techproya gider
        Thread.sleep(3000);

        //Son sayfada sayfayi yenileyelim(refresh)
        driver.navigate().refresh();
        Thread.sleep(3000);
        //Ve sayfayi kapatalim
        driver.close();

    }
}

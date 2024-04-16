package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");
        String url = driver.getCurrentUrl();
        if (url.contains("makemytrip")) {
            System.out.println("Sucessfully navigate to mmt");
        }

        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        WebElement flightElement = driver.findElement(By.xpath("//li[@class=\"menu_Flights\"]"));
        flightElement.click();
        // from
        driver.findElement(By.xpath("//label[@for='fromCity']")).click();
        Thread.sleep(2000);
        // enter blr
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("blr");
        Thread.sleep(2000);
        // select first option
        driver.findElement(By.xpath("//div[@role='listbox']//ul/li[1]")).click();

        // To
        driver.findElement(By.xpath("//label[@for='toCity']")).click();
        Thread.sleep(2000);
        // enter del
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("DEL");
        Thread.sleep(2000);

        // select option
        driver.findElement(By.xpath("//div[@role='listbox']//ul/li[1]")).click();

        // select date
        
        List<WebElement> dateHeading = driver
                .findElements(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[3]/div/div"));

        for (WebElement date : dateHeading) {
            if (date.getText().contains("29")) {
                Thread.sleep(2000);
                Actions actions = new Actions(driver);
                actions.moveToElement(date).click().build().perform();
                // date.click();
                break;
            }
        }

        // click on search
        driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
        Thread.sleep(15000);

        WebElement rsText = driver.findElement(
                By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']"));
        System.out.println("Flight Price: "+rsText.getText());
        System.out.println("end Test case: testCase02");
    }

    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        Thread.sleep(2000);
        //train icon click
        // driver.findElement(By.xpath("//li[@class='menu_Trains']")).click();
         WebElement trainElement = driver.findElement(By.xpath("//li[@class='menu_Trains']"));
         trainElement.click();
         //from+  
         driver.findElement(By.xpath("//label[@for='fromCity']")).click();
         Thread.sleep(2000);
         //enter blr+
         driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("ypr");
         Thread.sleep(4000);
         //select first option+
         driver.findElement(By.xpath("//div[@role='listbox']//ul/li[1]")).click();
         Thread.sleep(2000);
         //To+
         driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).click();
         Thread.sleep(2000);
         //enter del+
         driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("ndls");
         //select option
         driver.findElement(By.xpath("//div[@role='listbox']//ul/li[1]")).click();
         
 
         // select date
         
         List<WebElement> dateHeading = driver
                 .findElements(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[3]/div/div"));
 
         for (WebElement date : dateHeading) {
             if (date.getText().contains("29")) {
                 Thread.sleep(2000);
                 Actions actions = new Actions(driver);
                 actions.moveToElement(date).click().build().perform();
                 // date.click();
                 break;
             }
         }
         
               //select class
              // driver.findElement(By.id("travelClass")).click();
           List<WebElement> ele =driver.findElements(By.xpath("//ul[@class='travelForPopup']/li"));

           for(WebElement el: ele) {
            // System.out.println(el.getSize())  ;
             if(el.getText().contains("Third AC")) {
                el.click();
                break;
             }
             
           }
     
         Thread.sleep(2000);
       //click on search
     WebElement searchbtn =    driver.findElement(By.xpath("//a[@data-cy=\"submit\"]"));
     searchbtn.click();

     WebElement printPrice = driver.findElement(By.xpath("//div[@class='ticket-price justify-flex-end']"));
     System.out.println("train ticket price : "+printPrice.getText());
     System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException{
        Thread.sleep(4000);
        System.out.println("Start Test case: testCase04");
        //Bus icon click
        // driver.findElement(By.xpath("//li[@class='menu_Trains']")).click();
         WebElement trainElement = driver.findElement(By.xpath("//li[@class='menu_Buses']"));
         trainElement.click();
         //from+  
         driver.findElement(By.xpath("//label[@for='fromCity']")).click();
         Thread.sleep(2000);
         //enter blr+
         driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("bangl");
         Thread.sleep(2000);
         //select first option+
         driver.findElement(By.xpath("//div[@role='listbox']//ul/li[1]")).click();
         //Thread.sleep(2000);
         //To+
         driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).click();
         Thread.sleep(2000);
         //enter del+
         driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("del");
         Thread.sleep(2000);
         //select option
         driver.findElement(By.xpath("//div[@role='listbox']//ul/li[1]")).click();
         
 
         // select date
         
         List<WebElement> dateHeading = driver
                 .findElements(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[3]/div/div"));
 
         for (WebElement date : dateHeading) {
             if (date.getText().contains("29")) {
                 Thread.sleep(2000);
                 Actions actions = new Actions(driver);
                 actions.moveToElement(date).click().build().perform();
                 // date.click();
                 break;
             }
         }
            //click on search
     WebElement searchbtn =    driver.findElement(By.xpath("//button[@id='search_button']"));
     searchbtn.click();

     //print price
     
     WebElement print =    driver.findElement(By.xpath("//span[text()='No buses found for 29 Mar']"));
     System.out.println(print.getText());
     if(print.getText().contains("No buses found")){
        System.out.println("No buses found");
     }
     System.out.println("end Test case: testCase04");
         
    }

}

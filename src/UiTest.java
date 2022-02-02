
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UiTest {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","/Users/jfess/chromedriver97/chromedriver.exe");
        ChromeDriver driver =new ChromeDriver();
        driver.get("https://codepen.io/CalendlyQA/full/KKPQLmV");
        driver.manage().window().maximize();

        /*
        Test 1 Verify Correct Character is declared the Winner
        -Create classic 3 row board
        -Make 3 X marks down the left side
        -Validate that "X" is declared the winner
        */
        WebElement txtBox=driver.findElement(By.id("number"));
        txtBox.sendKeys("3");

        WebElement button=driver.findElement(By.id("start"));
        button.click();

        driver.findElement(By.id("0")).click();
        driver.findElement(By.id("2")).click();
        driver.findElement(By.id("3")).click();
        driver.findElement(By.id("5")).click();
        driver.findElement(By.id("6")).click();

        WebElement endMessage = driver.findElement(By.id("endgame"));
        Assert.assertEquals(endMessage.getText(),"Congratulations player X! You've won. Refresh to play again!");

        driver.navigate().refresh();


        /*
        Test 2 Verify that end of game message appears if board is full and there is no winner.
        -Create classic 3 row board
        -Fill the board with no 3 in a row
        -Validate that end of game banner appears
         */
        driver.findElement(By.id("number")).sendKeys("3");

        driver.findElement(By.id("start")).click();

        driver.findElement(By.id("4")).click();
        driver.findElement(By.id("0")).click();
        driver.findElement(By.id("1")).click();
        driver.findElement(By.id("7")).click();
        driver.findElement(By.id("3")).click();
        driver.findElement(By.id("5")).click();
        driver.findElement(By.id("2")).click();
        driver.findElement(By.id("6")).click();
        driver.findElement(By.id("8")).click();

        endMessage = driver.findElement(By.id("endgame"));
        Assert.assertTrue(endMessage.getText().contains("Refresh to play again"));

        driver.navigate().refresh();

        /*
        Test 3 Verify that tic tac toe board is expected size
        -Create 5 row board
        -Click in the bottom left to prove it is present
         */
        driver.findElement(By.id("number")).sendKeys("5");

        driver.findElement(By.id("start")).click();

        WebElement col1Row5 = driver.findElement(By.id("24"));
        col1Row5.click();

        driver.navigate().refresh();

    }
}

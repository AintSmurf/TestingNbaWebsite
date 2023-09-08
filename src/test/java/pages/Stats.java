package pages;


import Utils.waitsHelpers;
import locators.StatsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Require;
import java.util.List;



public class Stats {
    private WebDriver driver;
    private WebElement btnul;
    private List<WebElement> btnli;


    public Stats(WebDriver driver) throws InterruptedException {
        this.driver = (WebDriver) Require.nonNull("Driver", driver);
        this.initPage();
    }

    private void initPage() throws InterruptedException {
        Thread.sleep(1000);
        waitsHelpers.waitTillClickable(driver, 10, StatsLocators.MAINBTN);
        btnul = waitsHelpers.waitTillVisible(driver, 20, StatsLocators.FIRSTUL);
        btnli = btnul.findElements(By.tagName("li"));
    }

    public void navigateToPlayerPage() {
        btnli.get(0).findElement(By.tagName("a")).click();
    }

    public void navigateToTeamPage() {
       WebElement temp =  waitsHelpers.waitTillClickable(driver,20,btnli.get(1).findElement(By.tagName("a")));
       temp.click();

    }



    public TeamInfo getTeam(String team){
        return null;
    }


}

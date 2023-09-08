package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.PlayerInfo;
import pages.Stats;
import pages.TeamInfo;

@Slf4j
public class Hooks {
    public WebDriver driver;


    @Before
    public void setUp(){
        setDriver();
        log.info("driver is initialized.");
    }

    private void setDriver() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    public Stats getMainPage() throws InterruptedException {
        return new Stats(getDriver());
    }
    public PlayerInfo getPlayerPage(){
        log.info("Trying to access the player page ...");
        return new PlayerInfo(getDriver());
    }
    public TeamInfo getTeamPage(){
        log.info("Trying to access the team page ...");
        return new TeamInfo(getDriver());
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown() {

        if(driver != null)
            getDriver().quit();
        log.info("driver is closed.");
    }


}

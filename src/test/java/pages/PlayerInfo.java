package pages;

import Utils.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Require;

public class PlayerInfo {
    private WebDriver driver;
    private String name;
    private String team;
    private int age;
    private int gamesPlayed;
    private int wins;
    private int loses;
    private double minutesPlayed;

    public PlayerInfo(String name, String team, int age, int gamesPlayed, int wins, int loses, double minutesPlayed) {
        this.name = name;
        this.team = team;
        this.age = age;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.loses = loses;
        this.minutesPlayed = minutesPlayed;
    }

    public PlayerInfo(String name, String team) {
        this.name = name;
        this.team = team;
    }
    public PlayerInfo(WebDriver driver){
        this.driver = (WebDriver) Require.nonNull("Driver", driver);
    }
    public void chooseSeason(String date){
        Helpers.changeSeason(driver, date);
    }
    public void clickOnHeader(String text, int timeout, int ret) throws InterruptedException {
        Helpers.ClickOnHeader(driver,text,timeout,ret);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public double getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(double minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", age=" + age +
                ", gamesPlayed=" + gamesPlayed +
                ", wins=" + wins +
                ", loses=" + loses +
                ", minutesPlayed=" + minutesPlayed +
                "}\n";
    }
}

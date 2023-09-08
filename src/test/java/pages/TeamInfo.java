package pages;

import Utils.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Require;

public class TeamInfo {
    private WebDriver driver;
    private static  int count = 0;
    private String team;
    private int gamesPlayed;
    private int wins;
    private int loses;
    private double minutesPlayed;

    public TeamInfo(String team,  int gamesPlayed, int wins, int loses, double minutesPlayed) {
        this.team = team;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.loses = loses;
        this.minutesPlayed = minutesPlayed;
        count++;
    }
    public TeamInfo(WebDriver driver){
        this.driver = (WebDriver) Require.nonNull("Driver", driver);
    }
    public void clickOnHeader(String text, int timeout,int ret) {
        Helpers.ClickOnHeader(driver,text,timeout,ret);
    }
    public void chooseSeason(String date){
        Helpers.changeSeason(driver, date);
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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
        return "TeamInfo{" +
                "team='" + team + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", wins=" + wins +
                ", loses=" + loses +
                ", minutesPlayed=" + minutesPlayed +
                '}';
    }
}

package steps;

import Utils.Helpers;
import io.cucumber.java.en.*;
import pages.TeamInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamWithTheMostLosesSteps {
    private Hooks hooks;
    public TeamWithTheMostLosesSteps(Hooks hooks){
        this.hooks = hooks;
    }
    @Given(": user on stats page")
    public void user_on_stats_page() {
        hooks.getDriver().get("https://www.nba.com/stats/leaders");
    }
    @When("user switches to team page")
    public void user_switches_to_team_page() throws InterruptedException {
        this.hooks.getMainPage().navigateToTeamPage();
    }
    @When("user click on L in the table")
    public void user_click_on_l_in_the_table(){
        this.hooks.getTeamPage().chooseSeason("2013-14");
        this.hooks.getTeamPage().clickOnHeader("L",20,30);
        this.hooks.getTeamPage().clickOnHeader("L",20,30);
    }
    @Then("{string} on the top")
    public void on_the_top(String name) {
        String team = Helpers.getTableData(hooks.getDriver(), TeamInfo.class).get(0).getTeam();
        assertEquals(name, team);
    }

}

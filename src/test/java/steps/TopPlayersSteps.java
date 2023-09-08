package steps;

import Utils.Helpers;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import pages.PlayerInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopPlayersSteps {
    private Hooks hooks;

    public TopPlayersSteps(Hooks hooks) {
        this.hooks = hooks;
    }

    @Given("User on stats Page")
    public void user_on_stats_page() throws PendingException {
        hooks.getDriver().get("https://www.nba.com/stats/leaders");
    }

    @When("User switches to Players page")
    public void user_switches_to_players_page() throws PendingException, InterruptedException {
        hooks.getMainPage().navigateToPlayerPage();
    }

    @And("^User clicks on (.*) in the table$")
    public void user_clicks_on_header_in_the_table(String header) throws InterruptedException {
        hooks.getPlayerPage().clickOnHeader(header,20,30);
    }

    @Then("^(.*) is at the top$")
    public void playername_is_at_the_top(String name) throws InterruptedException {
        String player = Helpers.getTableData(hooks.getDriver(),PlayerInfo.class).get(0).getName();
        assertEquals(name, player);
    }
}

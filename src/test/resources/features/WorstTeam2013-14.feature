Feature: Top Team in 2013-14
  Scenario: verify the team with most loses in years 2013-14 is Milwaukee Bucks
    Given : user on stats page
    When user switches to team page
    And user click on L in the table
    Then "Milwaukee Bucks" on the top
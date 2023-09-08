Feature: Players Validation

  Scenario Outline: Verify Top player using scenario outline
    Given User on stats Page
    When User switches to Players page
    And User clicks on <header> in the table
    Then <playername> is at the top

    Examples:
      | header | playername        |
      | PTS    | Alondes Williams  |
      | L      | Kenyon Martin Jr. |
      | W      | Brook Lopez       |
      | 3PA    | Stephen Curry    |
      | GP     | Mikal Bridges      |

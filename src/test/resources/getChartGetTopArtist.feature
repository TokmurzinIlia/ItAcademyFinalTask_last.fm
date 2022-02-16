@test
Feature: Get top chart artists
  Scenario: Get top chart artists
    When The user sends a request to get the best performers by the following parameters of the number of performers in the list.
      |5|
    And The user receives a response status code of 200 upon request
    Then The list of top chart artists obtained from the query is equivalent to the desired one
      |The Weeknd|
      |Kanye West|
      |Doja Cat|
      |Taylor Swift|
      |Billie Eilish|
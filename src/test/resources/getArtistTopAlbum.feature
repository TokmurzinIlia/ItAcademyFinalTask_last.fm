@test
Feature: Get artist's top albums
  Scenario: Get artist's top albums
    When User is sends a get request to get the numbers top albums artists on following parameters.
    |numbers|3          |
    |artists|joesatriani|
    Then The list of top albums obtained from the query is equivalent to the desired one
    |Surfing With The Alien|
    |The Extremist|
    |Flying In A Blue Dream|









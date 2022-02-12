@test
Feature: Get session key
   Scenario: Get session key
        When User is sends a get request to get the token
        Then User get response status code is 200
        And User get token
        And User write token in file "authToken.txt"
        Then User open page user authorization request
        And User logs in
        And User give access to his Last.fm account
        And User close browser
        Then User is sends a get request to get the session
        Then User get response status code is 200
        And User get session key
        And User write session key in file "sessionKey.txt"
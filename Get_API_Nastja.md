Feature: Getting draft posts
In order to manage draft posts
As a registered user
I want to be able to get a list of draft posts

Scenario: Successful retrieval of draft posts
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a GET request to "/api/posts/drafts"                                                                                                                                                                                                                                                                                                                                          And a list of draft posts should be returned
Then the response status should be 200
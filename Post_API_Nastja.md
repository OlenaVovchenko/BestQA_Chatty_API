Feature: Post Creation
In order to add new content to the system
As a registered user
I want to be able to create new posts

Scenario: Successful post creation
Given the user is on the post creation page
When the user enters valid post data
And sends a request to create the post by base URI: "http://chatty.telran-edu.de:8989"
And the post should be successfully created
Then the response status should be 200
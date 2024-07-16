# Requirements

MPP-01 Chatty web site allows to find an existing information about a post

## Test Procedure

### Test Setup


Feature: User Deletion
In order to manage user information
As an administrator
I want to be able to delete user information

Scenario: Verify user can be deleted
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a DELETE request to "/api/users/{id}"                                                                          And the user should be successfully deleted
Then the response status should be 200
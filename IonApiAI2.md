

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
When I send a DELETE request to "/api/users/{id}"
Then the response status should be 200

### Test Scenarios

#### Scenario Positive:

MP-006-1 Verify that post can be got by id

Given the API server is running
And the base URL is set to "http://chatty.telran-edu.de:8089"
When Autotest Framework gets post via Get http method (endpoint "/api/posts" + id, id in path) from server
Then server returns the whole information about post with the requested id.

### Test Clean Up

Given test scenario is completed
When Autotest Framework returns added post via Get http method, endpoint "/api/posts/" + id, api_key in header "special-key"
Then post is returned
# Test Design: *CaseApiTestIon2*

## Test Design Inputs

### Requirements

MPP-02 Chatty web site allows to find an existing information about a post

## Test Procedure

### Test Setup

Feature: Post Creation
Scenario: Successful post creation
Given the user is on the post creation page
When the user enters valid post data
And sends a request to create the post by base URI: "http://chatty.telran-edu.de:8989"
And the post should be successfully created
Then the response status should be 200

### Test Scenarios

#### Scenario Positive:

MP-006-1 Verify that post can be created

Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When Autotest Framework sends post data via POST http method (endpoint "/api/posts")
Then the server creates the post with the provided data

### Test Clean Up

Given test scenario is completed
When Autotest Framework verifies post via GET http method, endpoint "/api/posts/" + id, api_key in header "special-key"
Then post is returned
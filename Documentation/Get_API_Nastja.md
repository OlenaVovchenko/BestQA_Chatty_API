# Test Design: *API_Test01_Nastja.md*

## Test Design Inputs

### Requirements

MPP-03 Chatty web site allows to retrieve a list of draft posts

## Test Procedure

### Test Setup

Feature: Getting draft posts
Scenario: Successful retrieval of draft posts
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a GET request to "/api/posts/drafts"
And a list of draft posts should be returned
Then the response status should be 200

### Test Scenarios

#### Scenario Positive:

MP-006-1 Verify that draft posts can be retrieved

Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When Autotest Framework sends a GET request to "/api/posts/drafts"
Then the server returns a list of draft posts

### Test Clean Up

Given test scenario is completed
When Autotest Framework verifies the draft posts
Then the draft posts are returned
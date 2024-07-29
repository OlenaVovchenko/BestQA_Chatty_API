# Test Case 1:Verify user posts can be retrieved

## Feature: Get User Posts

### Scenario: 01 Verify user posts can be retrieved successfully


```gherkin
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a GET request to "/api/users/{user_id}/posts" with the user_id "some-valid-uuid" and query parameters skip=0 and limit=10
Then the response status should be successful
And the response body should contain a list of posts for the user
```


# Test Case 2: Verify error on retrieving posts with invalid user_id

## Feature: Get User Posts

### Scenario: Verify error on retrieving posts with invalid user_id
```gherkin
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a GET request to "/api/users/{user_id}/posts" with an invalid user_id "invalid-uuid"
Then the response status should be unsuccessful
And the response body should contain an error message
```



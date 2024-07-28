# TestEx Case 1:Verify user posts can be retrieved

## Feature: Get Current User Information

### Scenario:  Verify current user information can be retrieved successfully


```gherkin
    Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a GET request to "/api/me"
Then the response status should be 200
And the response body should contain the current user information
```


# TestEx Case 2: Verify error on retrieving current user information with bad request

## Feature: Get Current User Information

### Scenario: Verify error on retrieving current user information with bad request
```gherkin
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a malformed GET request to "/api/me"
Then the response status should be 400
And the response body should contain an error message
```



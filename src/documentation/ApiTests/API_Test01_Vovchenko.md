# TestEx Case 1:Verify user password can be updated

## Feature: Update User Password

### Scenario: 01 Verify user password can be updated successfully


```gherkin
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a PUT request to "/api/user/password/update" with the correct JSON in
the body
Then the response should be successful
And the response body should be empty
```


# TestEx Case 2: Verify error on updating password with invalid data

## Feature: Update User Password

### Scenario: Verify error on updating password with invalid data
```gherkin
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a PUT request to "/api/user/password/update" with an invalid JSON body
Then the response status should be unsuccessful
And the response body should contain an error message
```



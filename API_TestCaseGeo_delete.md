
**01**

```gherkin

Test case 1: Verify post can be deleted 
Feature: Delete Post
Scenario: Verify post can be deleted successfully
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a DELETE request to "/api/posts/{id}" with a valid post id
Then the response status should be 200
And the response body should be empty





Test Case 2: Verify error on deleting post with invalid id

Feature: Delete Post
Scenario: Verify error on deleting post with invalid id
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a DELETE request to "/api/posts/{id}" with an invalid post id
Then the response status should be 400
And the response body should contain an error message




Test Case 3: Verify unauthorized error on deleting post without authentication
Feature: Delete Post
Scenario: Verify unauthorized error on deleting post without authentication
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a DELETE request to "/api/posts/{id}" without proper authentication
Then the response status should be 401
And the response body should contain an error message

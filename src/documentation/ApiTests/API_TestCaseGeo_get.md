**02**

```gherkin



TestEx Case 1:Verify all posts can be retrieved


Feature: Get All Posts
Scenario: Verify all posts can be retrieved successfully
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a GET request to "/api/posts" with query parameters skip=0 and limit=10
Then the response status should be 200
And the response body should contain a list of posts




TestEx Case 2: Verify error on retrieving posts with invalid parameters

Feature: Get All Posts
Scenario: Verify error on retrieving posts with invalid parameters
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a GET request to "/api/posts" with invalid query parameters skip=-1 and limit=-1
Then the response status should be 400
And the response body should contain an error message


TestEx Case 3: Verify unauthorized error on retrieving posts without authentication

Feature: Get All Posts
Scenario: Verify unauthorized error on retrieving posts without authentication
Given the API server is running
And the base URI is set to "http://chatty.telran-edu.de:8989"
When I send a GET request to "/api/posts" without proper authentication
Then the response status should be 401
And the response body should contain an error message

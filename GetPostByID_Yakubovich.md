# Test Design: *MyApiTestCase-001*

## Test Design Inputs

### Requirements

MPP-01 Chatty web site allows to find an existing information about a post

## Test Procedure

### Test Setup

```gherkin
Given Autotest Framework is launched
And chatty server base URI: "http://chatty.telran-edu.de:8989/swagger-ui/index.html#/" is set
And new post with random name (length from 3 to 7 symbols included, only Latin letters)
and random <status>  is created
And new post is added to server via Post http method (endpoint "/api/posts", body)
And added post id is returned
```

### Test Scenarios

#### Scenario Positive:
**MP-006-1** Verify that post can be got by id
```gherkin
Given the Api server is running
And the base URL is set to "http://chatty.telran-edu.de:8089"
When Autotest Framework gets post via Get http method (endpoint "/api/posts" + id, id
in path) from server
Then server returns the whole information about post with the requested id.

### Test Clean Up
Given test scenario is completed
When Autotest Framework returns added post via Get http method, endpoint "/api/posts/" + id,
api_key in header "special-key"
Then post is returned

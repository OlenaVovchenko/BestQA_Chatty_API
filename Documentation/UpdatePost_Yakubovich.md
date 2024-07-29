# Test Design: *MyApiTestCase-002*

## Test Design Inputs

### Requirements

MPP-02  Chatty allows to update the information about existing post

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
**MP-007-1** Verify post can be updated
```gherkin
Given initial setup
When Autotest Framework updates post via Put http method (endpoint "/api/posts" + id, id
in path) with the correct JSON body 
Then server returns updated post information
And Autotest Framework compares information about created in precondition post and the updated post. Assert they're not equal

```

### Test Clean Up
```gherkin
Given test scenario is completed
When Autotest Framework updated post via Put http method (endpoint "/api/posts" + id, id 
in path)

Then post is updated
```

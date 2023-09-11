Github repositories searcher
=============

This is a Spring Boot application whose main functionality is to fetch information from Github REST API about repositories, their branches, and the last commit SHA by providing a username.

---

## Technologies Used
- Java 17
- Spring Boot 3.1.3
- Maven

## Usage

Endpoint
```Http
/api/repositories/{username}
```
provides information about a user's repositories, including their branches and the last commit SHA.

**Example use:**

```http
/api/repositories/octocat
```
response:

```json
[
    {
        "name": "git-consortium",
        "ownerName": "octocat",
        "branchList": [
            {
                "name": "master",
                "commitSha": "b33a9c7c02ad93f621fa38f0e9fc9e867e12fa0e"
            }
        ],
        "fork": false
    },
    {
        "name": "hello-worId",
        "ownerName": "octocat",
        "branchList": [
            {
                "name": "master",
                "commitSha": "7e068727fdb347b685b658d2981f8c85f7bf0585"
            }
        ],
        "fork": false
    },
    {
        "name": "Hello-World",
        "ownerName": "octocat",
        "branchList": [
            {
                "name": "master",
                "commitSha": "7fd1a60b01f91b314f59955a4e4d4e80d8edf11d"
            },
            {
                "name": "octocat-patch-1",
                "commitSha": "b1b3f9723831141a31a1a7252a213e216ea76e56"
            },
            {
                "name": "test",
                "commitSha": "b3cbd5bbd7e81436d2eee04537ea2b4c0cad4cdf"
            }
        ],
        "fork": false
    }
]
``` 


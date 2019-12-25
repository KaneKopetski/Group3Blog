Base local URL: localhost:4000
Base cloud URL: https://zcw-group3blogproject.cfapps.io/

## Authentication Endpoints:

------------------

Base endpoint:

/api/auth

Methods accepted: None

/signup
Methods accepted: POST
JSON Payload:
{
"username": "yourdesiredsernamehere",
"password": "yourdesiredpasswordhere",
"email": "youremailaddresshere"
}

/login
Methods accepted: POST
JSON Payload:
{
"username": "yourusernamehere",
"password": "yourpasswordhere",
}

------------------

## Post Endpoints:

------------------

/api/posts
Methods accepted: GET, POST, PUT

###GET
Returns paginated list of all posts. Dynamically paged using URL params.

###POST:
Creates a new post.
JSON Payload:
{
"title": "desiredtitlehere",
"content": "desiredcontenthere",
"username": "authenticatedusernamehere"
}

###PUT:
Updates given post. Throws PostNotFoundException if post provided does not exist.
JSON Payload:
{
"postId": "idtoupdatehere",
"title": "desiredtitlehere",
"content": "desiredcontenthere",
"username": "authenticatedusernamehere"
}

------------------

/api/posts/:postId
Methods accepted: GET

###GET
Return post with provided post ID.

------------------

/api/posts/delete/:postId
Methods accepted: DELETE

###DELETE:
Delete post with provided post ID.

------------------

## Comment Endpoints

------------------

/api/comments
Methods accepted: GET, POST, PUT

###GET
Returns paginated list of all comments. Dynamically paged using URL params.

###POST:
Creates a new comment.
JSON Payload:
{
"postId": idhere,
"content": "desiredcontenthere",
"username": "authenticatedusernamehere"
}

###PUT:
Updates given comments. Throws CommentNotFoundException if comment provided does not exist.
JSON Payload:
{
"commentId": "idtoupdatehere",
"content": "desiredcontenthere",
"username": "authenticatedusernamehere"
}

------------------

/api/comments/:commentId
Methods accepted: GET

###GET
Return comment with provided comment ID.

------------------

/api/comments/delete/:commentId
Methods accepted: DELETE

###DELETE:
Delete comment with provided comment ID.

------------------

/post/{postId}

Methods accepted: GET

###GET

Returns comments associated with provided post ID.



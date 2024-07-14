curl --location 'http://localhost:8080/api/todos' \
--header 'Content-Type: application/json' \
--data '{
    "title": "sample title",
    "description": "description",
    "belongTo": "user1"
}'

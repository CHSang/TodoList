curl --location --request DELETE 'http://localhost:8080/api/todos/3' \
--header 'Content-Type: application/json' \
--data '{
    "title": "sample title",
    "description": "description_after_update_call",
    "belongTo": "user1"
}'

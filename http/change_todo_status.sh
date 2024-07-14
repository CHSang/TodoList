curl --location --request PUT 'http://localhost:8080/api/todos/5/changeStatus' \
--header 'Content-Type: application/json' \
--data '{
    "title": "sample title",
    "description": "description_after_update_call",
    "belongTo": "user1"
}'

curl --location --request GET 'http://localhost:8080/api/todos?user=user1' \
--header 'Content-Type: application/json' \
--data '{
    "title": "sample title",
    "description": "description_after_update_call",
    "belongTo": "user1"
}'

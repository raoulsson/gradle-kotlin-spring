#!/bin/bash
mysqldump -u user -ppassword --no-create-db --ignore-table=video_games.flyway_schema_history --extended-insert=FALSE --databases video_games > ../../../../../tmp/video_games_db.sql
echo "DROP DATABASE video_games" | mysql -u user -ppassword
echo "CREATE DATABASE video_games" | mysql -u user -ppassword
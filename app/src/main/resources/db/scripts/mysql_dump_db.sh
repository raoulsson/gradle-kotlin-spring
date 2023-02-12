#!/bin/bash
mysqldump -u user -ppassword --ignore-table=video_games.flyway_schema_history --extended-insert=FALSE --databases video_games > ../../../../../tmp/video_games_db.sql
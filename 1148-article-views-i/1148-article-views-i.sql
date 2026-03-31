# Write your MySQL query statement below
SELECT DISTINCT sub.viewer_id AS id
        FROM(
            SELECT article_id, 
                    author_id,
                    viewer_id
                FROM Views WHERE author_id=viewer_id
        ) sub ORDER BY id;
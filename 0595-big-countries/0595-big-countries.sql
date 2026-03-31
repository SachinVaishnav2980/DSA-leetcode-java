# Write your MySQL query statement below
SELECT sub.*
    FROM(
        SELECT name, 
               population,
               area
            FROM World
            WHERE area >= 3000000 OR population >= 25000000
    ) sub; 
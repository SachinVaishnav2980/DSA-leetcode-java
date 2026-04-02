# Write your MySQL query statement below
SELECT prd.product_name, 
        s.year,
        s.price
    FROM Sales s
JOIN 
    Product prd ON s.product_id=prd.product_id; 
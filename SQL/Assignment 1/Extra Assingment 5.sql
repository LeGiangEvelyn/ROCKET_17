USE `adventureworks`;
-- Exercise 1: Subquery
/*Question 1: Write a query that filters data and return the column “Name” from table Production.Product. 
The filtering of rows is achieved by a WHERE clause that compares a single value from a subquery
The inner subquery shall return a specific ProductSubcategoryID that the outer query uses as a filter of products to include in the report. 
The inner query will use its own WHERE clause to deliver its value, 
the ProductSubcategoryID, by retrieving it where the column “Name” in table Production.ProductSubcategory have the value of ‘Saddles’. */
SELECT `name`
FROM product 
WHERE ProductSubcategoryID = (SELECT ProductSubcategoryID
								FROM productsubcategory
                                WHERE `name` LIKE "Saddles");

/* Question 2: In this exercise you can change the previous query to deliver the following result set. 
The WHERE clause in the subquery will now use the wildcard string ‘Bo%’ for a comparison.*/
SELECT `name`
FROM product 
WHERE ProductSubcategoryID IN (SELECT ProductSubcategoryID
								FROM productsubcategory
                                WHERE `name` LIKE "Bo%");

/* Question 3:
Write a query that return all products that has the same price as the cheapest (lowest ListPrice) Touring Bike (ProductSubcategoryID = 3). 
Use the MIN() aggregate function in the subquery to return the lowest ListPrice to the outer query. */
SELECT `Name`, ProductNumber
FROM product
WHERE listPrice = (SELECT MIN(listPrice)
						FROM product
						WHERE ProductSubcategoryID = 3);

/* Exercise 2: JOIN nhiều bảng
Question 1: Write a query that lists the country and province names stored in AdventureWorks2008sample database. 
In the Person schema you will find the CountryRegion and StateProvince tables.
Join them and produce a result set similar to the following. Notice that there is no particular sort order in the result set */
SELECT c.Name AS Country, s.name AS Province
FROM countryregion c
JOIN stateprovince s ON c.CountryRegionCode = s.CountryRegionCode;

/* Question 2: Continue to work with the previous query and add a filter to only list the countries Germany and Canada.
Also notice the sort order and column headings of the result set. */
SELECT c.Name AS Country, s.name AS Province
FROM countryregion c
JOIN stateprovince s ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.Name IN ("Germany", "Canada")
ORDER BY c.Name, s.name;

/* Question 3:
We want information about orders. From the Sales.SalesOrderHeader table we want the SalesOrderID, OrderDate and SalesPersonIDcolums. 
From the Sales.SalesPerson table we want the BusinessEntityID (which identifies the sales person), Bonus and 
the SalesYTD (how much this person sold for yet this year) columns. */
/* As an aside, note that joining SalesOrderHeader to SalesPerson will restrict the result to non-Internet orders
(order processed on the Internet has 1 in the OnlineOrderFlag, 
and has NULL for the SalesPersonID column */
SELECT soh.SalesOrderID, DATE(soh.OrderDate) AS OrderDate, soh.SalesPersonID, sp.SalesPersonID AS BusinessEntityID, sp.Bonus, sp.SalesYTD
FROM salesorderheader soh
JOIN salesperson sp ON soh.SalesPersonID = sp.SalesPersonID
WHERE soh.OnlineOrderFlag != 1 AND soh.SalesOrderID IS NOT NULL;

/* Question 4:
Use above query, add JobTitle and remove the SalesPersonID and the BusinessEntityID columns. 
You need to join to the HumanResources.Employee table. */
SELECT soh.SalesOrderID, DATE(soh.OrderDate) AS OrderDate, e.title AS JobTitle, sp.Bonus, sp.SalesYTD
FROM salesorderheader soh
JOIN salesperson sp ON soh.SalesPersonID = sp.SalesPersonID
JOIN employee e ON soh.SalesPersonID = e.employeeID
WHERE soh.OnlineOrderFlag != 1 AND soh.SalesOrderID IS NOT NULL;
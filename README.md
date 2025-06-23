

## How to Run the Application

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Tomcat 8.5 or higher
- MySQL Server 5.7 or higher
- Eclipse IDE for Java EE Developers (or any IDE that supports web applications)

### Database Setup
1. Install and start MySQL Server
2. Create a database named `OnlineFoodOrderDB`:
   ```sql
   CREATE DATABASE OnlineFoodOrderDB;
   ```
3. Use the database:
   ```sql
   USE OnlineFoodOrderDB;
   ```
4. Create the required tables using these SQL commands:
   ```sql
   -- Customer table
   CREATE TABLE customer (
       customer_id INT PRIMARY KEY,
       customer_name VARCHAR(100),
       customer_emailID VARCHAR(100),
       customer_password VARCHAR(100),
       customer_address VARCHAR(255)
   );

   -- Food table
   CREATE TABLE food (
       food_id INT PRIMARY KEY,
       food_name VARCHAR(100),
       food_price INT
   );

   -- Drinks table
   CREATE TABLE drinks (
       drink_id INT PRIMARY KEY,
       drink_name VARCHAR(100),
       drink_price INT
   );

   -- FoodOrder table
   CREATE TABLE foodOrder (
       fo_id INT PRIMARY KEY AUTO_INCREMENT,
       order_id INT,
       food_id INT,
       quantity INT,
       price INT
   );

   -- DrinkOrder table
   CREATE TABLE drinkOrder (
       do_id INT PRIMARY KEY AUTO_INCREMENT,
       order_id INT,
       drink_id INT,
       quantity INT,
       price INT
   );

   -- TotalOrder table (if needed)
   CREATE TABLE totalOrder (
       order_id INT PRIMARY KEY,
       customer_id INT,
       total_price INT
   );
   ```

5. Add sample food and drink items:
   ```sql
   -- Adding food items
   INSERT INTO food VALUES (1, 'Chicken Biryani', 200);
   INSERT INTO food VALUES (2, 'Vegetable Pulao', 180);
   INSERT INTO food VALUES (3, 'Chicken Arabiata Pasta', 200);
   INSERT INTO food VALUES (4, 'Mushroom Penne Pasta', 180);
   INSERT INTO food VALUES (5, 'Chicken Barbeque Pizza', 250);
   INSERT INTO food VALUES (6, 'Farmhouse Vegetable Pizza', 230);
   INSERT INTO food VALUES (7, 'Caesar Salad', 180);
   INSERT INTO food VALUES (8, 'Chocolate Mousse', 150);
   INSERT INTO food VALUES (9, 'Rasgulla', 50);

   -- Adding drink items
   INSERT INTO drinks VALUES (101, 'Lemon Iced Tea', 40);
   INSERT INTO drinks VALUES (102, 'Lassi', 40);
   INSERT INTO drinks VALUES (103, 'Cold Drink', 40);
   ```

### Application Setup
1. Import the project into Eclipse:
   - Go to File > Import > Existing Projects into Workspace
   - Select the root directory of your project
   - Click Finish

2. Configure Tomcat in Eclipse:
   - Go to Window > Preferences > Server > Runtime Environments
   - Add your Tomcat server
   - Right-click in Servers view and select "New > Server"
   - Choose Apache > Tomcat v8.5 (or your version)
   - Set the server directory to your Tomcat installation

3. Add the project to the server:
   - Right-click on the server
   - Select "Add and Remove..."
   - Add the Food-ordering-system project to the configured server

4. Configure JDBC:
   - Make sure the MySQL JDBC connector JAR is in your project's `WebContent/WEB-INF/lib` directory
   - If not, download it from the MySQL website and add it to your build path

5. Check database connection settings:
   - Ensure the database connection string in the Java files matches your MySQL setup
   - Default settings used in the project:
     - URL: `jdbc:mysql://localhost:3306/OnlineFoodOrderDB?autoReconnect=true&useSSL=false`
     - Username: `root`
     - Password: `root`
   - Update these settings if your MySQL configuration differs

### Running the Application
1. Start the MySQL server
2. Right-click on the Tomcat server in Eclipse and select "Start"
3. Access the application in your browser: http://localhost:8080/Food-ordering-system/
4. You should see the login page
5. Register a new user or log in with an existing account

### Troubleshooting
- If you encounter database connection issues, verify MySQL is running and check your connection parameters
- For HTTP 404 errors, ensure the application is properly deployed to Tomcat
- For compilation errors, make sure all dependencies are properly set up in the build path


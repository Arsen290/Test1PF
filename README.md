# Test project from 1PF

This Java REST API application is designed to download data in JSON format from the web API České spořitelně, process it or store it in a Postgresql database. The data can get from web API or our database,it depends on boolean parameter. The application populates one database table: 'rate_cards' , where stores information of rate card. The application is written in Java using the Spring Boot framework by pattern REST API.
## Installation

To run this application, you'll need to follow these steps:

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17 or higher installed
- Apache Maven for building the project
- A PostgreSQL database set up

### Step 1: Clone the Repository

``` 
git clone https://github.com/Arsen290/Test1PF.git
```

### Step 2: Build the Project
<p>Navigate to the project directory and build it using Maven:</p>
React

Navigate to the React project directory:
```
cd Test1PF\my-react-app
```
Install dependencies:

```
npm install
```
Build the project:
```
npm run build
```
After running this command, you will find the compiled files in the build directory.

Open the directory
```
cd Test1PF 
```

Mvn install
```
mvn clean install 
```
Install Node.js if not already installed.
Ensure Maven is installed.

### Step 3: Set Up the Database

<p>Create a PostgreSQL database for the application. You can use the following configuration in your application.properties:</p>

``` 
spring.datasource.url=jdbc:postgresql://localhost:5432/{your_database_name}
spring.datasource.username={your_username}
spring.datasource.password={your_password}
spring.datasource.driver-class-name=org.postgresql.Driver 
/** 
 *Make sure to replace yourpassword with your actual PostgreSQL password. 
 */
```

### Step 4: Run the Application
You can run the application using the Spring Boot Maven plugin:

```
mvn spring-boot:run 
```
<p>The application should now be accessible at http://localhost:8080. Use a web browser or tools like Postman to interact with it.</p>

## Usage
<p>?useDb=true: This is a query parameter appended to the URL.If useDb is true:It retrieves all rate cards from the local database using. If false:It constructs the URL for an external API České spořitelně and save it in db</p>

Example using cURL:

```
localhost:8080/api/v1/ratecards?useDb=true
```

<p>For more information on using the application, refer to the controller in the project.</p>

## Configuration
<p>You can find configuration settings in the application.properties file.</p>

## Additional Information
<p>I have three additional three branches in my project:

In the frontend (FE), Thymeleaf was used with an assistant controller method. This branch has not been merged yet.

In the backend (BE), a REST API project was created.

In the frontend with React (FEReact), connected the backend with the frontend part and attempted to create a view using React. 
React project is located in the folder my-react-app.</p>
```
localhost:3000/ - get all rate cards with mid values
localhost:3000/details - get rate card by shortname with all details 
```\\
### License
<p>This project is licensed under the MIT License - see the LICENSE.md file for details.</p>

### Credits
<p>This project uses Spring Boot, PostgreSQL, and other open-source libraries.</p>

### Contact
<p>For questions, feedback, or collaboration, you can contact me.</p>
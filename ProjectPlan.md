git 
## Project Plan

1. *Git init*
-[ ] Create team repo (Github)<br><br>
2. *Maven init / config*
-[ ] Set up Maven project
-[ ] Update POM.xml with dependencies<br><br>
3. *Database init*
-[ ] Set up CCR database / visual representation
-[ ] Set up project with hibernate (production & test)
-[ ] Set up project with Database (production & test db + dump files)
-[ ] Set up SessionFactory class
-[ ] Set up PropertiesLoader<br><br>
4. *Java Bean, generic dao + Hibernate init / config*
-[ ] Create beans for entities
    -[ ] Student
    -[ ] RideForm
    -[ ] Location
-[ ] Annotate beans with Hibernate
-[ ] Map beans in Hibernate config file
-[ ] Set up GenericDao
-[ ] Create tests for beans<br><br>
5. *Google API place autocomplete & place details search init*
-[ ] Use Robopojo generator to create beans / map Google API response
    -[ ] AutocompleteDao
      -[ ] AutocompleteDao test 
    -[ ] PlaceDetailsDao
      -[ ] PlaceDetailsDao test 
-[ ] Create client resource for Google API
  -[ ] Create google.properties file for accessing API<br><br>
6. *Search class init*
-[ ] Create search/filter class to return results based off radius<br><br> 
7. *REST / Service init*
-[ ] Create REST entry point w/ application path "/services"
-[ ] Place REST entry point into Application startup class 
-[ ] Create methods for GET, POST, DELETE 
-[ ] Test endpoints with CURL<br><br>
8. *JSP + front end init*
-[ ] Create JSP's and corresponding servlets
-[ ] Create necessary JS files / ajax calls<br><br>
-[ ] Implement CSS / site theme
-[ ] Double check for consistency -- header, footer, nav, etc. 
-[ ] Ensure all classes have Javadoc<br><br>
-[ ] Deploy to AWS
-[ ] Create documentation for resources


## <center> Database Tasks </center>

***CampusCoRide (Database)***<br>

Student Table
: id (pk, auto incr.)
: first_name
: last_name
: student_id<br><br>

Request_Form Table 
: id (pk, auto incr.)
: request_type
: destination_type
: date
: time
: notes
: student_id (fk, references id in student table)<br><br>

Location Table
: id (pk, auto incr.)
: location_name
: lat
: lng
: postal_code

### Entity Relationships

Student ➔ Request_Form: one to many<br>
Request_Form ➔ Student: many to one

Request_Form ➔ Location: one to one (location FK goes on RF table)<br>

*** 

## Jsp Tasks

>***User Sign Up Page*** &nbsp;(*signup.jsp*)<br>
Registration page to use Campus Co-Ride's services

**<ins>Registration Form</ins>**<br>
- FORM DETAILS
  - name = registrationForm
  - id = registrationForm
  - method = POST
  - enctype = application/x-www-form-urlencoded
  - action = "/addStudent" ➔ SignUp servlet
- FORM FIELDS
  - firstName = text, req.
  - lastName = text, req.
  - email = email, req.
  - student = id # number, req.
  - submit btn w an id = submitRegistration<br><br>

**<ins>Sign Up Servlet</ins>**<br>
- SERVLET DETAILS
  - name = registrationServlet
  - urlPatterns = "/addStudent"
- doPost method
  - GET QUERY PARAMS / SET BEAN FIELDS
    - firstName, lastName, email, studentId
    - create new Student
      - insert student w/ GenericDao
      - set User obj. into req. session
    - request dispatcher ➔ forward response to "/homepage.jsp"


> ***Ride Request / Provider Form*** &nbsp;(*ride-form.jsp*)<br>
Students can request or offer ride services by submitting a form. Requests can be made for a specific date/time or omitted.<br>
If omitted, students can leave a description of the type of arrangement they're seeking in the *'notes'* field.<br>
For safety purposes, students are encouraged to use nearby landmarks, street names, or zip codes for their location.

**<ins>Ride Request Form</ins>**<br>
- FORM DETAILS
  - name = rideRequestForm
  - id = rideRequestForm
  - data-user-id = user_id from req. session 
- FORM FIELDS 
  - requestType = select, req
    - Options: Rider or Provider
  - destinationType = radio, req
    - Options: To Campus or From Campus
  - location = text *(should be \<ul\> element with each AutocompletePrediction appended as an \<li\> element )*
  - postal_code = number
  - lat = hidden (get from place details results)
  - lng = hidden (get from place details results)
  - date = date
  - time = time
  - notes = textarea
  - submit btn w an id = submitRequestForm<br><br>

**<ins>Ride Request Form JS</ins>** *(rideForm.js)*
- event listener for location field to retrieve user input on 'keydown'.
  - input to be sent (via fetch) to REST endpoint to retrieve List<AutocompletePredictions
    - create a function that will append each item to the 'location' field \<ul\>
- event listener to retrieve 'place_id' when a user selects a place from the list of predictions
  - take place_id and make a fetch call to REST endpoint
  - fill in 'location', 'lat' & 'lng', and 'postal_code'
- use event listener to stop form propagation
- get form values by ID
  - send values to endpoint via POST fetch



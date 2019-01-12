# uTutor
Android App

uTUTOR
Patrick Daley 

Student Objectives
The overall goal of this project was to become more familiar with the mobile application process. I now have a better understand Android Studio Framework. I also gained experience with the complete life cycle of a project, working with a database, and API. 
Problem Specification
My project is a mobile application for connecting students to tutors. This application is designed so that students have more off campus options of getting help with class. Through-out my college career I have lived off-campus with multiple jobs. This made it very difficult to find time to get help in class. I wanted something that was more convenient and helpful. So, I thought of uTutor.
In uTutor, Student and tutors can customize their profile to display their current status in school and what type of learner they are. This is used to help match students to the proper tutor. Students use a filtering system to then locate different tutors. Students may message tutors through email, and tutors will get a request notification message in their feed. 
Amendments
Due to my partners medical issue the originally purposed document has been amended. I have removed stripe api, chatbox api, and a geolocator from the scope of this project. These apis will later be produced by my capstone partner. Stripe api is already set up within the project and there are some commits on the api. 
Dan will also implement a tutor rating system and more filtering for searching for tutors. This will allow the student to have a better experience inside the application. Students will be able to find tutors close by with a good rating.

Architecture 
In project folders, are two diagrams. One for my UI design and one for my database design. Both of these designs were deeply thought about to optimize security and reduce confusion for the user. I wanted to make sure that users were only accessing data they should be able to access. I also wanted to make sure that the user could navigate easily through-out the application. 
My database design is composed of three tables, student, tutor and relation. Tutor and Student tables include the user’s information, and the userid. Every time a new user is added they must authenticate their account, or they will not be allowed to access any data. This allows for security against dummy accounts. Once authorized the users can then make connections to tutors. Userids are populated into the relational table based on these tutor connections. The overall scheme is clean and simple. 
My UI design is composed of multiple xml files. The overall schema is so that the user can easily register, log in and log out. Users also have the ability to go back and forth between the appropriate interfaces. I have placed back buttons and a navigation bar that allow for this. 


Front-end
The frontend is composed of multiple XML files. These files implement text-boxes, spinners, navigation, buttons and etc. Each XML files is made up of different layouts including constraint, relative, and linear based on what the file contained. Files also implemented attributes from the resource’s files. Such as, Strings and arrays because you are not allowed to hard code anything into the XML file. The major xml files that I created include login page, register page, settings page, feed page, searching page, and a profile page. To navigate through these files I had to create intents within the resource file. These intents basically state that you can change activities with in a xml file. 
	My overall experience with the GUI’s was good. However, androids feature can be very overwhelming. There is a lot provided, but you need to understand what each component is used for. 
	When the application is first launching the user will be presented with an interface containing two buttons. These buttons will direct the user to either login or registration. So, a first-time user would select register. The user would then be directed to another interface with the option to choose to register as a student or tutor. Both of these options are displayed as buttons, and there is also a button that allows the user to go back.  Both, registration pages will contain the same interface. But, on save the user will be stored in the database as a tutor or a student based on what the user selected. The registration interface contains an edit text box for name, location, gpa, age, description, and school. This page also contains a dropdown menu to select your major, which is a spinner. Last there is a save button that the user can select once they have entered at least their email, name and password. If this is not entered that will be prompted. Once this is completed and the user hits the save button, they will be directed back to the interface they started at. They will then select the login button. Then they will choose the tutor, or student login in button based on what they registered as. This page also contains a button to go back. Next, the user is directed to login. This page contains an edit text box for email and password entries. This also contains three buttons. One is for login in based on the information entered, another is for going back to the home page and the last is for resetting your email. This reset button will direct you to a page with an edit text to enter your email, a submit button and a back button. The user must enter the correct email or will be prompted. After sending the request to reset the information the user is sent back to the home page. Back to the login page. The user must also enter the right credentials and verify their email before login. If not, the user will be prompted to do so. 
Once the user properly logs in, they are directed to their profile page. This page is populated with all the information already stored in the database. It is the same layout as the registration page with edit text boxes and a spinner for information. But this page has a save button that will update the page when the data is changed. This page also contains a bottom navigation bar for the user. This navigation is similar, but not the same for the student and tutor. The difference is the home button. For the tutor this contains a feed, and for the student this is a tutor searching component. The students feed is made up of two text views to display the student’s names and location that reached out. Then there is set text that says, “Incoming requests”. The Students page is a list view. This is built up of two xml pages. One is each individual block containing text views for name, location description and a contact button. The other xml file is the container, which is also composed of the spinner that allows filtering by major. 
The other two pages that the navigation directs to are settings and an information page. The information page just contains test that say for users to contact a general email for questions or concerns. This gives the users direct communication with administrators to resolve any unknown issues. The settings pages are composed of an edit text box for emails, and three buttons, which are for deleting your account, resetting your password and lastly logging out. 

Back-end

The backend is composed of multiple java file and my database. I have a corresponding java file for each XML layout. These java files not only start the activity’s so you can view the XML layouts, but also perform actions based on their responsibility’s. Most of these actions would communicate with my database. Whenever, a user was logging in, registering, updating data, delete data, searching for data methods to firebase were called.
To implement all of the methods that I used from firebase and etc. I needed dependencies. These dependencies are very tricky because they need to be the correct version to work with in the overall system. I was also constantly updating these dependencies to get a better overall system. However, methods varied version to version. Overall, I have 12 dependencies in my system. Half of these are for firebase and the other half are android support. 
My first major component is the registration page. Here, users enter in all of their information. The use must enter in their email, password and name, or they will be prompted to do so. Passwords need to be a certain length for firebase to accept them. Once, those conditions are met, if there is no user stored in the database with that email the user will be created. This is done through a createUserWithEmailAndPassword method and sendEmailVerification method. Both of these methods are provided with firebase. The tricky part is that firebase is very sensitive. For this to work your OS needs to be up to date and the network connection needs to be good. 
The user then directs to the login page and is sent an email verification. On the log in page, the user must enter their credentials. All information must be correct, or the user will be prompted and unable to log in. The user must have also verified their email. These conditions are check through three methods. The first method called checks to make sure all the text fields are entered and then signs in the user. Next, a method called check if user exist is called to confirm that user still has a account in the database. Then lastly emailVerfied method is called. This checks a Boolean value to make sure that the user has verified their email. This is to prevent mass dummy accounts. If all the information is correct the user is directed to the profile page.
This page allows the user to update their data and navigate through the application. On the profile page the user’s current data is posted. I have also ensured that there are requirements in each text field for type and length by creating if statements. After updating, data the user can direct to three pages based on if they are a tutor or student. This is done through a switch statement that is constrained to each button in the navigation. Tutors may direct to the settings page, feed page, and help forum. If they are a student they may direct to the settings page, searching page, and help forum. Settings contains options for logging out, resetting password, and deleting accounts. If you select reset your email you will be sent an email to do so. The help forum displays an email to contact for questions. The major difference between the students and tutors’ pages are the feed and searching components. Searching is used to find a proper tutor. This display a list view of all the profiles in the database and allows filtering by major. This is conducted through an adapter class and storing all of the user data in an array. I had to use adapter because I had to create two xml files. One for the list-view and spinner.  Then one for the element within each profile block, so a text view for name, description, location and a contact button. This data is also continently updated by a on data change function that searches through my database. Students are able to contact the tutor by clicking on the contact button. This button will then redirect the student to an email that is populated already. This onclick action also establishes a relationship between the tutor and student, which is saved in my data base by storing the student and tutor ids.  This table is then examined by the tutors feed page. In the tutors feed there is a on data change function that will search through the table. Then display all the relationships with students that tutor has in a text view. 
	In conclusion, a lot of the backend functionality was produced by method calls to firebase api. It was very important that data was stored and accessed properly. Firebase methods were very useful, but also very sensitive to use. You needed to make sure that the correct user’s profile was always synced to the pages. The application is also very dependent on the network connecting because it is making calls to the api.






Tools
1.Version Control
●	GitHub was used to collaborate on the project without overwriting important data. This was also used for project management. I logged all of my commits. I also set up a chart of project goals. 

2. Android Studio and Java 
●	Java is the primary development language for Android
●	Android Studio provides necessary tools and a user-friendly development environment 

3. Firebase is a NoSQL database. This allowed for information to be stored dynamically by using a JSON File to pass data. My database contains rules only allowing authorized user to read and write.

4. Communication
●	 Slack for communication
●	Zoom
●	Skype
●	Commenting and writing clean code

6. Diagrams
●	Lucid Charts 

7. APIs and Libraries/Packages
●	Firebase


 Benchmark Specifications

●	Set up Firebase Connection 
●	Set up Student and Tutor Registration
●	Set up Student and Tutor Login  
●	Navigation
●	Profile Functionality 
●	Communication Component 
●	Revising Design 

Time Schedule

●	Week 1:  Set up android studio and VC
●	Week 1-3: Database connection and rules
●	Week 2-5: Implementing registering 
●	Week 5-7: Implementing login
●	Week 7-9: Implementing profiles  
●	Week 9: Navigation component 
●	Week 10: Implementing settings 
●	Week 10-13: Tutor connection component 
●	Week 13:  Revising 

Grading Scheme

●	Uis Design 30%
●	Database 15%
●	Tutor connection component 25%
●	Testing 10%
●	Presentation 10% 
●	Report 10% 

Deliverables
●	Original proposal document
●	Amendments to proposal
●	Presentation 
●	Source code
●	Documentation
●	Post-mortem 
●	Journal (VC)












Post-Mortem

I was success in creating a functional app that creates a connection and relationship between tutors and students. This application displayed a good overall user interface experience. The application covered all of my corner cases. So, the user would not experience any crashing, or confusion. Data was also properly stored and access in my database. The rules and methods allowed for data security, and a good overall schema. 
 However, I learned I need to work on some aspects of the product life cycle. I was very under prepared for unforeseen events. After my capstone partner had to leave, my time schedule and benchmarks had to be amended. I was no longer able to implement stripe and chat APIs. Which were two features that I put an immense amount of research into. I need prepare more and work on the most important fundamental features. Before moving to the more advanced components. 






# Epic Quest: My Booklix Account
**`Quest giver: Inkmaster Jo Po`**
>People are constantly asking for recommendations.  I want to be able to give out recommendations accurately, but I cannot keep track of everything in my head.  It gets a little overwhelming.  I have begun to collect information about the ratings for various books and the information on the books themselves.  I need to start combining that information and be able to output it to people who ask.  Can you help with this, if it works out I will give you service for free when it eventually turns into subscriptions.

## Quest Overview
This quest has us simulating a book recommending system.  Think about how Netflix/YouTube recommends videos for you to watch (Netflix is more a realistic example, the YouTube algorithm is... yeah).

It involves reading and writing into a text file.  It will outline some basic concepts of machine learning, as prediction algorithms fall into that broad category.

Being able to make accurate predictions for customers is an important task for a lot of service companies.  Netflix, Amazon, YouTube, Spotify, and more rely on accurately being able to predict other things you might enjoy.  It is part of machine learning, which is part of artificial intelligence in computer science.

Consider movie recommendations, yes we are doing books but go with movies for a moment.  If a friend tells you movies they enjoy and you also happen to enjoy those movies.  Then if this friend would recommend a new movie to you then you would most likely want to watch it.  The same can be said for our book recommendation system.  Pretend we have a user, Alyssa, for which we want to make recommendations.  As we go through this example.

A system could calculate how similar two users' interests are by treating each of their ratings as a unique vector and calculating the dot product of these two vectors.

**The dot product is just the sum of the products of each of the corresponding elements.**

For example, suppose we had 3 books in our database and Alyssa rated them [5, 3,-5] (the rating system will be outlined below).  Kinsey rated them [1, 5,-3], Scott rated them [1, 3, 0], and Eric rated them [5, -3, 5].

The similarity between Alyssa and Scott is calculated as: (5 x 1) + (3 x 3) + (-5 x 0) = 5 + 9 + 0 = 14. The similarity between Alyssa and Kinsey is: (5 x 1) + (3 x 5) + (-5 x -3) = 5 + 15 + 15 = 35. The similarity between Alyssa and Eric is (5 x 5) + (3 x -3) + (-5 x 5) = 25 - 9 - 25 = -9.

We can see that if both people like a book (rating it with a positive number) it increases their similarity and if both people dislike a book (both giving it a negative number) it also increases their similarity.

Once you have calculated the pair-wise similarity between Alyssa and every other customer, you can then identify whose ratings are most similar to Alyssa's. In this case, Kinsey is most similar to Alyssa, so we would recommend to Alyssa the top books from Kinsey's list that Alyssa hadn't already rated.

In our database, the ratings are based on the following table

|   Rating     |   Meaning                                     |
| :----------: |:-----------------------------------------     |
| -5           | hate it with the passion of 1000 burning suns |
| -3           | dislike it                                    |
| 0            | have not read it                              |
| 1            | meh - neither hate nor like                   |
| 3            | like it                                       |
| 5            | LOVE IT                                       |

## Objectives Required to complete
### Objective 1 - Designing a Plan
Our design plan should outline the steps being accomplished in each method of our program.  The [design example](designexample.txt) displays a design plan to base the one needed for this project.  When creating a design plan for this project it could be done in either a text file or as a comment on the top of a code file.  Remember design plans should be pushed and requested for approval before coding.

### Objective 2 - Cloning
- Clone this project into IntelliJ
    - remember to place it into a correct folder

### Objective 3 - Branching from the main
- Click on the word "Git" in the bottom left corner of IntelliJ
    - Right-click on the word "main"
    - Choose "New branch from selected"
- On the popup name the branch `dev`
    - Leave the checkmark in "Checkout Branch"
    - Click "Create"

Now we have our `dev` branch, we double-check the bottom right corner it should say `dev`, not main.

We can now work on this `dev` branch.

## Quest Requirements
The bullet points in this section are the bare minimum needed.  There are often times when exact details are missing as it would give away the answer.  Therefore, we should realize that some more work and logic are required with certain steps.

Class and method names should be written as they are described below.  Variable names can be anything you choose as long as they follow naming conventions.

**NOTE: Only array types (not the Arrays class) or ArrayLists are allowed to be used for the necessary collections in this quest.  No other data structures or collections can be used at any point, doing so will result in a loss of points.**

### Objective 1 - Book Class
We will need to create an appropriate class for holding all our information about a Book.

- Create a class called `Book`
    - make the class in the following location (-> denotes going to a sub-folder)
        - `src` -> `main` -> `java`

- Create appropriate instance variables
- Create a constructor, take a single parameter
    - `String` filename
    - this should read in the data from the file and store it in an appropriate collection (Array or ArrayList)

This class should hold the following information about a book:
- ISBN number: string that uniquely identifies a book
- Title: multiple books may have the same title
- Year: year the book was published
- Author

We must look at the book file to determine the order of this information when it is being read in.

- Create setters and getters for instance variables needed
- Create an addBook method
    - this method should take all the appropriate information about a book as parameters
    - it should make sure that the ISBN number given is unique
    - if the number is unique add the book to the collection
    - otherwise do not add the book to the collection
    
### Objective 2 - Person Class
We will need to create an appropriate class for holding all our information about a Person.

- Create a class called `Person`
    - make the class in the following location (-> denotes going to a sub-folder)
        - `src` -> `main` -> `java`
      
This class should hold the following information about a Person:
- Name: full name of the person
- Age: age of the person in years

- Create appropriate instance variables
- Create a constructor, that takes a parameters
    - `String` the name of the person
    - `int` the age of the person
- Create appropriate setters and getters

### Objective 3 - Members Class
We will need to create an appropriate class for holding all our information about the Members.

- Create a class called `Members`
    - make the class in the following location (-> denotes going to a sub-folder)
        - `src` -> `main` -> `java`
    - it should extend `Person`
      
This class should hold the following information about a member:
- Account Name: this is the username for a member.  This must be unique, no two members may have the same name.  If a member wishes to have a name that is taken they must be told to pick a different name.
- Account Creation Year: year the account was made

- Create appropriate instance variables
- Create a constructor, that takes parameters
    - remember to call the super constructor
    - set instance variables for this class
- Create appropriate setters and getters
- Other methods to make sure usernames are unique and other features may be needed

### Objective 4 - Ratings Class
We will need to create an appropriate class for holding all our information about a combination of Members and Books.

- Create a class called `Ratings`
    - make the class in the following location (-> denotes going to a sub-folder)
        - `src` -> `main` -> `java`
      
- Create appropriate instance variables
- Create a constructor, that takes three parameters
    - `String`, the book
    - `String`, the member username
    - `int`, the number rating based on the numbers at the top of the quest
- Create appropriate setters and getters
- There might be other methods that get coded here to help with the main method interactions

### Objective 5 - Bookflix Class
We will need to create an appropriate class for running our program.

- Create a class called `Bookflix`
    - make the class in the following location (-> denotes going to a sub-folder)
        - `src` -> `main` -> `java`

- Create a main method
- Below is a list of operations that the program should accomplish
    - Set up all the data with appropriate data structures
        - Each person in the ratings file needs to be made into a member (you can treat the names as member full names and account names)
        - The ratings in that file corresponding to the book list in order
    - Give the user the option to either create a new account or enter an existing account name to log into the program
    - Add a new book to the database
        - its info should be added to the book file
        - everybody should receive a default rating of 0 for this book
    - Switch users
    - View the user's current ratings for all books
        - the account name should be displayed with the ratings too
    - Rate a book that does not have a rating for that user
    - See recommended books for the user
    - Quit

- Any changes made to the books, users, or ratings need to be saved back into their appropriate text files upon quitting the program

Many details are unspecified, this is for a reason. For example, when rating a book, does the program show a list of books, or must the user type its name out fully, or does the user type the author? When a user asks to see recommended books, how many do they see?

Part of this quest is to make these decisions. The quality of these decisions will be part of the grade received.

### Bonus
#### Option 1
Enhance the rating system to the following.  This new system would use all other users to make the recommendations to Alyssa instead of only Kinsey.

(Scott's ratings) x (Scott's similarity to Alyssa) + (Kinsey's ratings) x (Kinsey's similarity to Alyssa) + (Eric's ratings) x (Eric's similarity to Alyssa)

This would breakdown into the following:

= [1, 3, 0] x 14 + [1, 5,-3] x 35 + [5, -3, 5] x -9
= [14, 42, 0] + [35, 175, -105] + [-45, 27, -45]
= [4, 244, -150]

Based on these final ratings we would recommend that Alyssa reads book 2, book 1, and then book 3.  Now we would only want to make recommendations on books that Alyssa has not yet read, so for this example, it wouldn't work as Alyssa has already read all the books in our database.

#### Option 2
Incorporate passwords, these will need to be saved into a file so they can be read in when collecting all the data.  It could be different or added to the given text files.

#### Option 3
Have an admin account that has special privileges.  For example, deleting a user's account, changing a password for a user, or other ideas.

#### Option 4
Come up with your own idea that needs to be approved by me before it will receive credit.  This will be extremely difficult to get approval for.

#### Grading
|   Points              |   Requirement                                           |
| :--------------------:|:------------------------------------------------------- |
| Person Class          |                                                         |
|  5                    |  instance variables                                     |
|  5                    |  constructor                                            |
| Members Class:        |                                                         |
|  5                    |  instance varaibles                                     |
| 10                    |  inheritance used correctly                             |
| 10                    |  unique members only                                    |
| Book Class:           |                                                         |
|  5                    |  instance varaibles                                     |
| 10                    |  constructor (init from file)                           |
| 10                    |  addBook()                                              |
| Main Program / Class: |                                                         |
| 10                    |  Setup collections correct                              |
|  5                    |  ability to add a book                                  |
| 10                    |  ability to switch users                                |
| 10                    |  view a users ratings for all books                     |
|  5                    |  rate a book for a user                                 |
| 20                    |  see recommendations of books for a user                |
| 20                    |  decisions to implement the interactions                |
| 10                    |  "Good" Objected Oriented Style                         |
|  5                    |  Submission                                             |
|  5                    |  Documentation                                          |

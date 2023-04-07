# JavaAssignment

Display 
This class has the main and calls to display the GUI class.
GUI
This is a java class that creates as user interface including buttons, textfields ,labels and scroll pane. It takes in a user search term and sends it into the FileSearch class. This class returns results which are then displayed from the GUI class.
File Search
File Search is a Java program that allows you to search for a term across a set of text sources (e.g. groups of text files). The user enters a search term into a GUI, and the program checks the contents of a set of text files to find the files that contain the search term. The program ranks the files based on how many times the search term appears in each file, and returns the most similar files at the top of the list.


Features
Search for a single word or multiple words
Use wildcards to make the search smarter (e.g. this word AND this word OR this word)
More sophisticated searching options: exact phrase matches, comma-separated words, and wildcards (such as walk* to find walked, walking, walk etc.)
Select the search space (i.e. the text files to be searched)
Ranking mechanism that returns the strongest match first

With more time further improvements could have been implemented such as 
-Spelling correction that can correct the wrong spelling of search terms
-Improved user interface 
-A search history 

Installation
To run the program, you will need to have Java 7 or higher installed on your computer. You can download the latest version of Java from the official website.

Once you have Java installed, you can download the FileSearch.java and GUI.java files from this repository and compile them using the following command:

Copy code
javac FileSearch.java GUI.java
This will create two .class files that you can run using the following command:

Copy code
java GUI
This will launch the GUI, and you can start searching for files.


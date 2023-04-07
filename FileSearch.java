package homework;

//Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FileSearch { //Class that will read files in a directory and compare them to the user search

    public static List<String> searchFiles(String userSearch, String directory) {
        List<String> results = new ArrayList<>();
        File[] files = new File(directory).listFiles();
        if (files != null) {//makes sure file isnt empty
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) { //reads only .txt files
                    try {
                        Scanner scanner = new Scanner(file);
                        int count = 0;
                        while (scanner.hasNext()) { //loop runs until all files have been read
                        	String line = scanner.nextLine(); //creates a string containing the line in a text file
                        	
                        	//reads the line variable and checks if it contains anything the user has typed 
                            if (line.toLowerCase().contains(userSearch.toLowerCase())){ //sets everything to lower case
                                count++;
                            }
                        }
                        scanner.close(); //close scanner
                        if (count > 0) {
                            results.add(file.getName() + " (" + count + " occurrences)");
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        // Sort results by count in descending order
        Collections.sort(results, new Comparator<String>() {
            
            public int compare(String o1, String o2) {
                int count1 = getCount(o1);
                int count2 = getCount(o2);
                return count2 - count1;
            }
            
            private int getCount(String s) {
                int index = s.indexOf("(");
                if (index != -1) {
                    String countString = s.substring(index + 1, s.length() - 13);
                    try {
                        return Integer.parseInt(countString.trim());
                    } catch (NumberFormatException e) {
                        // Ignore invalid count strings
                    }
                }
                return 0;
            }
        });
        
        return results;
    }
}



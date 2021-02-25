package scorelistdemo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wael Hawa 
 * Class CIS 2353 
 * Fall 2020
 * Project 2
 *
 */
public class ScoreListDemo {

    public static void main(String[] args) {

        Scanner scan = null;
        FileReader input = null;
        PrintWriter output = null;
        int selection = 0;
        String text = null;
        String name = null;
        int score = 0;
        ScoreList list = new ScoreList();
        ScoreList list2 = null;
        try {
            input = new FileReader("scores.txt");
            output = new PrintWriter(new BufferedWriter(new FileWriter("scores.txt", true)));
            scan = new Scanner(input);
            while (scan.hasNext()) {
                text = scan.nextLine();
                name = text.substring(0, 1).toUpperCase() + text.substring(1, text.indexOf(" ")).toLowerCase();
                score = Integer.parseInt(text.substring(text.indexOf(" ") + 1));
                list.add(name, score);
            }//end while-loop

            list.print();
            list2 = new ScoreList(list);
            System.out.println("\n\nList copy\n");
            list2.print();

        }//end try
        catch ( FileNotFoundException e) {
            System.out.println("File Not Found.");
        } catch (IOException | StringIndexOutOfBoundsException | NumberFormatException ex) {
            System.out.println("File Format Error. Please check text file format as follows:-\n Name 1234");
        }//end catch
        while (true) {
            System.out.print("\nWould you like to add another (1) or quit the program (2)?\n");
            selection = menuItem();
            switch (selection) {
                case 1:
                    text = addNode();
                    output.println(text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase());
                    name = text.substring(0, 1).toUpperCase() + text.substring(1, text.indexOf(" ")).toLowerCase();
                    score = Integer.parseInt(text.substring(text.indexOf(" ") + 1));
                    list.add(name, score);
                    break;

                case 2:
                    System.out.println("Thanks for using the program!\tGoodbuy!\n\nList Copy\n\n");
                    //list2 = new ScoreList(list);
                    list2.print();
                    try {
                        /*
                        Prints a copy of the original list chain
                        to show that new data entered is not affecting the original chain.
                         */
                        input.close();
                        output.flush();
                    } catch (Exception e) {

                    }
                    System.exit(0);
                default:
                    System.out.println("Invalid Entry.");

            }
            list.print();
        }

    }//end main

    /*
    Gets an integer from the user entry.
     */
    public static int menuItem() {
        String entry;
        int item = 0;
        Scanner scan = new Scanner(System.in);
        try {
            entry = scan.nextLine();
            item = Integer.parseInt(entry);
            return item;

        } catch (Exception e) {
            return 0;
        }
    }//end menuItem

    /*
    Method to check the correct format to return as text to be processed.
     */
    public static String addNode() {
        Scanner scan = new Scanner(System.in);
        String text;
        char[] letters = null;
        char[] numbers = null;
        boolean name = true;
        boolean score = true;
        while (true) {
            System.out.println("\nWrite the name followed by score");
            text = scan.nextLine();
            System.out.println();
            try {
                letters = text.substring(0, text.indexOf(" ")).toCharArray();
                numbers = text.substring(text.indexOf(" ") + 1).toCharArray();
                for (char x : letters) {
                    if (!Character.isLetter(x)) {
                        name = false;
                    }
                }
                for (char x : numbers) {
                    if (!Character.isDigit(x)) {
                        score = false;
                    }
                }
                if (name && score) {
                    return text;
                } else {
                    System.out.println("Invalid Format (Ex: Wael 100");
                }
            } catch (Exception e) {
                System.out.println("Invalid Format (Ex: Wael 100)");
            }

        }//end while
    }//end addNode

}//end class

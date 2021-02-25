package imagesearch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author waelh
 */
public class ImageSearch {

    static boolean animals = false, flowers = false, people = false, buildings = false, landscapes = false, operand = true;

    public static void main(String[] args) {
        FileReader input;
        Scanner scan;
        String text;
        String fileName;
        String description;
        String[] searchParam;
        ArrayList<String> array;
        boolean error = false;
        

        ImageList list = new ImageList();
        try {
            input = new FileReader("images.txt");
            scan = new Scanner(input);
            while (scan.hasNext()) {
                text = scan.nextLine();
                fileName = text.substring(0, text.indexOf(".") + 4);
                description = text.substring(text.indexOf(".") + 5);
                String[] properties = description.split(" ");
                reset();
                for (String attribute : properties) {

                    if (attribute.equalsIgnoreCase("animals")) //1
                    {
                        animals = true;
                    }
                    if (attribute.equalsIgnoreCase("flowers")) //2
                    {
                        flowers = true;
                    }
                    if (attribute.equalsIgnoreCase("people")) //3
                    {
                        people = true;
                    }
                    if (attribute.equalsIgnoreCase("buildings")) //4
                    {
                        buildings = true;
                    }
                    if (attribute.equalsIgnoreCase("landscapes")) //5
                    {
                        landscapes = true;
                    }
                }//end for-loop
                list.add(fileName, animals, flowers, people, buildings, landscapes);
            }//end while-loop
            input.close();
        }//end try
        catch (IOException e) {
            System.out.println("The file \"images.txt\" is not found");

        }//end catch
        text = null;
        scan = new Scanner(System.in);
        while (true) {
            reset();
            System.out.println("What would you like to search for? type (exit) to exit :");
            text = scan.nextLine();
            if (text.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            searchParam = text.split(" ");
            if (searchParam.length > 3 || searchParam.length % 2 == 0) {

                System.out.println("Incorrect search parameter syntax");
                error = true;
            } else {
                for (int x = 0; x < searchParam.length; x += 2) {
                    if (searchParam[x].equalsIgnoreCase("animals")) {
                        animals = true;
                    }
                    if (searchParam[x].equalsIgnoreCase("flowers")) {
                        flowers = true;
                    }
                    if (searchParam[x].equalsIgnoreCase("people")) {
                        people = true;
                    }
                    if (searchParam[x].equalsIgnoreCase("buildings")) {
                        buildings = true;
                    }
                    if (searchParam[x].equalsIgnoreCase("landscapes")) {
                        landscapes = true;
                    }

            }//end for
            }//end if-else
            if(searchParam.length > 1){
                if (searchParam[1].equalsIgnoreCase("and") || searchParam[1].equalsIgnoreCase("or")){
                if (searchParam[1].equalsIgnoreCase("and")){
                    operand = false;
                }
                if (searchParam[1].equalsIgnoreCase("or")){
                    operand = true;
                }
                } else {
                    System.out.println("Wrong parameter syntax (use and/or for multiple searches)");
                    error = true;
                }
            }
            if(!error){
            array = list.search(operand, animals, flowers, people, buildings, landscapes);
            if (array.isEmpty()){
                System.out.println("Your search returned no results.");
            } else {
            for (String x : array)
                System.out.println(x);
            System.out.println("\n\n");
            }
            }

        }//end while
        
    }//end main

    public static void reset() {
        animals = false;
        flowers = false;
        people = false;
        buildings = false;
        landscapes = false;
        operand = true;
    }
}//end class

package university;

/**
 * Wael Hawa
 * CIS 2353
 * Winter 2020
 * Prof. John Baugh
 */

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author waelh
 */
public class University {

    public static void main(String[] args) {
        Map<String, ArrayList<String>> university = new HashMap<>();
        FileReader input;
        Scanner scan;
        String text, name, dept;
        ArrayList<String> list = new ArrayList<>();

        try {
            input = new FileReader("departments.txt");
            scan = new Scanner(input);
            while (scan.hasNext()) {
                text = scan.nextLine().toUpperCase();
                text = text.trim();
                if (university.containsKey(text)) {
                    university.put(text, list);
                } else {
                    list = new ArrayList<>();
                    university.put(text, list);
                }
            }
            input.close();
        } catch (Exception e) {
            System.out.println("File departments.txt not found");
        }

        try {
            input = new FileReader("faculty.txt");
            scan = new Scanner(input);
            while (scan.hasNext()) {
                text = scan.nextLine().trim();
                name = indent(text.substring(0, text.indexOf(",")));
                dept = text.substring(text.indexOf(",") + 2).toUpperCase();
                if (!university.get(dept).contains(name)) {
                    university = addEntry(university, name, dept);
                } else {
                    System.out.println("Cannot add " + name + " to " + dept + " because they already exist there.");
                }
            }
            input.close();
        } catch (Exception e) {
            System.out.println("File faculty.txt not found");
        }
        scan = new Scanner(System.in);
        System.out.println("\nWelcome the Faculty Directory Program\n");
        while (true) {
            System.out.println("Use commands:\n"
                    + " list all\n"
                    + " list DEPT_NAME\n"
                    + " add DEPT_NAME, FIRST LAST\n"
                    + " remove DEPT_NAME, FIRST LAST\n"
                    + " remove DEPT_NAME\n"
                    + " exit");
            text = scan.nextLine();
            text = text.trim();
            if (text.contains(",")) {   //1
                if (text.toUpperCase().startsWith("ADD")) {
                    dept = text.substring(4, text.indexOf(",")).toUpperCase();
                    name = indent(text.substring(text.indexOf(",") + 2));
                    addEntry(university, name, dept);
                } else if (text.toUpperCase().startsWith("REMOVE")) {
                    dept = text.substring(7, text.indexOf(",")).toUpperCase();
                    name = indent(text.substring(text.indexOf(",") + 2));
                    university = removeEntry(university, name, dept);
                } else {
                    System.out.println("Please use commands appropriately.");
                }

            } else {
                if (text.equalsIgnoreCase("exit")) {
                    onExit(university);
                } else if (text.equalsIgnoreCase("list all")) {
                    listAll(university);
                } else if (text.toUpperCase().startsWith("LIST ")) {
                    if (university.containsKey(text.toUpperCase().substring(text.indexOf(" ") + 1))) {
                        listDept(university.get(text.toUpperCase().substring(text.indexOf(" ") + 1)));
                    } else {
                        System.out.println("Department name is invalid or not available");
                    }
                } else if (text.toUpperCase().startsWith("REMOVE ")) {
                    if (university.containsKey(text.toUpperCase().substring(text.indexOf(" ") + 1))) {
                        dept = text.substring(6).toUpperCase().trim();
                        university = removeDept(university, dept);
                    }

                } else {
                    System.out.println("Please use commands appropriately.");

                }
            }//end 1

        }//end while
    }//end main

    public static void listAll(Map<String, ArrayList<String>> university) {
        System.out.println();
        for (String dept : university.keySet()) {
            for (String name : university.get(dept)) {
                System.out.println(name + ", " + dept);
            }
        }
        System.out.println();
    }//end listAll

    public static void listDept(ArrayList<String> names) {
        System.out.println();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println();
    }//end listDept

    public static Map<String, ArrayList<String>> addEntry(Map<String, ArrayList<String>> university, String name, String dept) {
        ArrayList<String> list;
        if (!university.containsKey(dept)) {
            list = new ArrayList<>();
            university.put(dept, list);
            university.get(dept).add(name);
        } else {
            university.get(dept).add(name);
        }
        System.out.println("OK, added " + name + " to " + dept);
        return university;

    }//end addEntry

    public static Map<String, ArrayList<String>> removeEntry(Map<String, ArrayList<String>> university, String name, String dept) {
        university.get(dept).remove(name);
        if (university.get(dept).isEmpty()) {
            university.remove(dept);
        }
        System.out.println("OK, removed " + name + " frome " + dept);
        return university;
    }//end removeEntry

    public static String indent(String text) {
        String[] fullName;
        fullName = text.split(" ");
        for (int x = 0; x < fullName.length; x++) {
            fullName[x] = fullName[x].substring(0, 1).toUpperCase() + fullName[x].substring(1).toLowerCase();
        }

        text = fullName[0] + " " + fullName[1];

        text = text.trim();
        return text;
    }//end indent

    public static Map<String, ArrayList<String>> removeDept(Map<String, ArrayList<String>> university, String dept) {
        university.remove(dept);
        System.out.println("OK, removed " + dept);
        return university;
    }//end removeEntry

    public static void onExit(Map<String, ArrayList<String>> university) {
        try {
            PrintWriter faculty = new PrintWriter(new BufferedWriter(new FileWriter("faculty.txt", false)));
            PrintWriter departments = new PrintWriter(new BufferedWriter(new FileWriter("departments.txt", false)));
            for (String dept : university.keySet()) {
                departments.println(dept);
                for (String name : university.get(dept)) {
                    faculty.println(name + ", " + dept);
                }
            }
            faculty.flush();
            faculty.close();
            departments.flush();
            departments.close();
            
            System.out.println("Goodbye! Have a nice day!");
            System.exit(0);
        } catch (Exception e) {

        }
    }//end onExit

}// end class

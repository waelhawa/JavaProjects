/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author waelh
 */
public class EmployeeDemo {

    public static void main(String[] args) {
        int item = 0;
        int x = 0;
        int index = 0;
        int counter = 1;
        int i = 1;
        boolean working = true;
        ArrayList<Employee> employeeList = new ArrayList();
//        for (int u = 0; i < 10; i++)
//            employeeList.add(u, generate());
        while (working) {
            item = 0;
            while (item < 1 || item > 6) {
                System.out.println("\nMain Menu\n---------");
                System.out.print("1- Add Employee\n2- Remove Employee\n3- Employee List\n4- Employee Info\n5- Compare Employees\n6- Exit\n\nEntry: ");
                item = menuItem();
                if (item < 1 || item > 6) {
                    System.out.println("\nInvalid Entry\n");
                }
            }
            switch (item) {
                case 1:
                    employeeList.add(index, addEmployee());
                    index++;
                    System.out.println("\nEmployee added Successfully\n");
                    break;
                case 2:
                    listOfEmployees(employeeList);
                    if (!(employeeList.size() == 0)) {
                        System.out.print("\nEntry: ");
                        item = menuItem();
                        if (item <= employeeList.size() && item > 0) {
                            employeeList.remove(item - 1);
                            index--;
                            System.out.print("\nEmployee removed successfully\n");
                        }
                        listOfEmployees(employeeList);
                    }
                    break;
                case 3:
                    listOfEmployees(employeeList);
                    break;

                case 4:
                    listOfEmployees(employeeList);
                    if (!(employeeList.size() == 0)) {
                        System.out.print("\nEntry: ");
                        item = menuItem();
                        if (item <= employeeList.size() && item > 0) {
                            System.out.print("\n" + employeeList.get(item - 1).toString() + "\n");
                        }
                    }
                    break;
                case 5:
                    i = 1;
                    listOfEmployees(employeeList);
                    if (!(employeeList.size() == 0)) {
                        System.out.print("\nEntry: ");
                        item = menuItem();
                        x = item;
                        if (item <= employeeList.size() && item > 0) {
                            System.out.print("\nCompare to: \n");
                            counter = 1;
                            for (Employee employee : employeeList) {
                                if (!(i == x)) {
                                    System.out.print(counter + "- " + employee.getFirstName() + " " + employee.getLastName() + "\n");
                                    counter++;
                                }
                                i++;

                            }
                            item = menuItem();
                            if (item >= x) {
                                item++;
                            }
                            if (item <= employeeList.size() && item > 0 && !(item == x)) {
                                if (employeeList.get(x - 1).equals(employeeList.get(item - 1)))
                                    System.out.println("Employees are equal");
                                else
                                    System.out.println("Employees are not equal");
                                
                                if(employeeList.get(x-1).compareTo(employeeList.get(item-1)) == 1)
                                    System.out.println(employeeList.get(x-1).getFullName() + " is higher than " + employeeList.get(item-1).getFullName());
                                if(employeeList.get(x-1).compareTo(employeeList.get(item-1)) == 0)
                                    System.out.println(employeeList.get(x-1).getFullName() + " and " + employeeList.get(item-1).getFullName() + " are equal");
                                if(employeeList.get(x-1).compareTo(employeeList.get(item-1)) == -1)
                                    System.out.println(employeeList.get(x-1).getFullName() + " is lower than " + employeeList.get(item-1).getFullName());

                            } else {
                                System.out.println("\nInvalid Entry");
                            }

                        } else {
                            System.out.println("\nInvalid Entry");
                        }

                    } else {
                        System.out.print("\nList is empty\n");
                    }
                    break;

                default:
                    System.exit(0);
            }
        }
    }

    public static boolean checker(String toCheck) {
        boolean check = true;
        for (char seek : toCheck.toCharArray()) {
            if (!Character.isAlphabetic(seek)) {
                check = true;
            } else {
                check = false;
            }

        }
        return check;

    }

    public static String indent(String text) {
        text = text.substring(0, 1).toUpperCase() + text.substring(1);
        return text;
    }

    public static Employee addEmployee() {
        String entry;
        String degreeType = " ";
        String firstName = "";
        String lastName = "";
        int experience = 0;
        int degreeValue = 0;
        int counter = 0;
        boolean check = true;
        Scanner scan = new Scanner(System.in);
        Employee employee;
        while ((degreeValue < 1) || (degreeValue > 5)) {
            System.out.print("\n1- None\n2- Associate\n3- Bachelors\n4- Masters\n5- Doctorate\n\nPlease enter Degree:- ");
            degreeValue = menuItem();
            if ((degreeValue >= 1) && (degreeValue <= 5)) {
                switch (degreeValue) {
                    case 1:
                        degreeType = "None";
                        break;
                    case 2:
                        degreeType = "Associate";
                        break;
                    case 3:
                        degreeType = "Bachelors";
                        break;
                    case 4:
                        degreeType = "Masters";
                        break;
                    default:
                        degreeType = "Doctorate";
                }
            } else {
                System.out.println("Please enter a valid value");
            }
        }
        while (check) {
            System.out.println("Enter First Name:");
            firstName = scan.nextLine();
            if (checker(firstName)) {
                System.out.println("First Name contains non-Alphabetic characters");
            } else {
                check = false;
            }

        }
        check = true;
        while (check) {
            System.out.println("Enter Last Name:");
            lastName = scan.nextLine();
            if (checker(lastName)) {
                System.out.println("Last Name contains non-Alphabetic characters");
            } else {
                check = false;
            }
        }

        firstName = indent(firstName);
        lastName = indent(lastName);

        check = true;
        while (check) {
            System.out.println("Please enter years of experience:");
            entry = scan.nextLine();
            try {
                experience = Integer.parseInt(entry);
                if (experience >= 0 && experience <= 60) {
                    check = false;
                } else {
                    System.out.println("Please enter a valid amount of years (0 - 60.");
                }
            } catch (Exception e) {
                System.out.println("Invalid entry.");
            }
        }
        employee = new Employee(degreeType, firstName, lastName, experience, degreeValue);
        return employee;
    }

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
    }

    public static void listOfEmployees(ArrayList<Employee> array) {
        if (!(array.size() == 0)) {
            int counter = 1;
            for (Employee i : array) {
                System.out.print(counter + "- " + i.getFirstName() + " " + i.getLastName() + "\n");
                counter++;
            }
        } else {
            System.out.print("\nList is empty\n");
        }
    }
    
    public static Employee generate(){
        Random rand = new Random();
        int r = rand.nextInt(7)+1;
        Employee employee = new Employee("none", String.valueOf(r), String.valueOf(r) , r, r);
        return employee;
    }
    
}

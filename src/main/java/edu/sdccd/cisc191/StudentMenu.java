package edu.sdccd.cisc191;
import java.util.Scanner;
/**
 * (1) 2D Array
 */
public class StudentMenu {
    private static final int MAX_STUDENTS = 1000;
    private Student[][] studentArray = new Student[MAX_STUDENTS][];
    private int studentCount = 0;
    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("STUDENT DATABASE");
            System.out.println("1. ADD STUDENT");
            System.out.println("2. REMOVE STUDENT");
            System.out.println("3. DISPLAY ALL STUDENTS WITH GPA");
            System.out.println("4. SEARCH BY STUDENT SSID");
            System.out.println("5. SEARCH BY GPA");
            System.out.println("6. EXIT");
            System.out.print("ENTER CHOICE: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    searchBySSID();
                    break;
                case 5:
                    searchByGPA();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE. TRY AGAIN.");
            }
        } while (choice != 6);
        scanner.close();
    }
    public void addStudent() {
        if (studentCount < MAX_STUDENTS) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("SSID: ");
            String studentId = scanner.next();
            System.out.print("FIRST NAME: ");
            String firstName = scanner.next();
            System.out.print("LAST NAME: ");
            String lastName = scanner.next();
            System.out.print("GPA: ");
            double currentGPA = scanner.nextDouble();
            studentArray[studentCount] = new Student[] { new Student(studentId, firstName, lastName, currentGPA) };
            studentCount++;
            System.out.println("STUDENT ADDED");
        } else {
            System.out.println("STUDENT DATABASE FULL. STUDENT NEEDS TO BE ADDED TO WAIT LIST.");
        }
    }
    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("SSID OF STUDENT TO REMOVE: ");
        String removeSSID = scanner.next();
        boolean removed = false;
        for (int i = 0; i < studentCount; i++) {
            if (studentArray[i][0].getSSID().equals(removeSSID)) {
                for (int j = i; j < studentCount - 1; j++) {
                    studentArray[j][0] = studentArray[j + 1][0];
                }
                studentCount--;
                removed = true;
                System.out.println("STUDENT REMOVED.");
                break;
            }
        }
        if (!removed) {
            System.out.println("SSID " + removeSSID + " NOT FOUND.");
        }
    }
    public void printAll() {
        for (int i = 0; i < studentCount; i++) {
            studentArray[i][0].displayStudentInfo();
        }
    }
    public void searchBySSID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("SSID TO SEARCH: ");
        String searchSSID = scanner.next();
        for (int i = 0; i < studentCount; i++) {
            if (studentArray[i][0].getSSID().equals(searchSSID)) {
                studentArray[i][0].displayStudentInfo();
                return;
            }
            System.exit(0);
        }
        System.out.println("STUDENT WITH SSID " + searchSSID + " NOT FOUND.");
    }
    public void searchByGPA() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("GPA TO SEARCH: ");
        double searchGPA = scanner.nextDouble();
        boolean found = false;
        System.out.println("STUDENTS WITH GPA " + searchGPA + ":");
        for (int i = 0; i < studentCount; i++) {
            if (studentArray[i][0].getCurrentGPA() == searchGPA) {
                studentArray[i][0].displayStudentInfo();
                found = true;
            }
            System.exit(0);
        }
        if (!found) {
            System.out.println("NO STUDENTS WITH GPA " + searchGPA + "FOUND.");
        }
    }
    public int getStudentCount() { return studentCount; }

    //private StudentCollection studentCollection = new StudentCollection(); // 5
    //private StudentLinkedList studentLinkedList = new StudentLinkedList(); // 6


    public static void main(String[] args) {
        StudentMenu studentMenu = new StudentMenu();
        studentMenu.runMenu();
    }
}


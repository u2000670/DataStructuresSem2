package com.company.Week5DoublyLinkedList.Lab5.QN2StudentList;

import java.util.Scanner;

public class Kindergarten {
    public static void main(String[] args) {
        SinglyLinkedList<String> studentList = new SinglyLinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("enter your student name. Enter 'n' to end . . . ");
        String input = sc.nextLine();

        while (!input.equalsIgnoreCase("n")) {
            studentList.add(input);
            input = sc.nextLine();
        }

        System.out.println("You have entered the following student names :");
        studentList.printList();
        System.out.println("The number of students entered is: " + studentList.getSize());

        while (true) {

            System.out.println("==================== ACTIONS =====================");
            System.out.println("I would like to . . .");
            System.out.println("0) exit");
            System.out.println("1) add a student");
            System.out.println("2) correct a student's name");
            System.out.println("3) remove a student from the list");
            System.out.print("choose an action: ");

            int action = sc.nextInt();
            sc.nextLine();
            if (action == 0) {
                break;
            } else if (action == 1) {
                System.out.println("enter your student's name. Enter 'n' to end . . . ");
                input = sc.nextLine();
                while (!input.equalsIgnoreCase("n")) {
                    studentList.add(input);
                    input = sc.nextLine();
                }
                System.out.println("The updated student list is :");
                studentList.printList();
                System.out.println("The updated number of students is: " + studentList.getSize());
                System.out.println();

            } else if (action == 2) {
                System.out.print("Enter the existing student's name: ");
                String oldName = sc.nextLine();
                System.out.print("Enter the new name: ");
                String newName = sc.nextLine();
                studentList.replace(oldName, newName);
                System.out.println("The new student list is :");
                studentList.printList();
                System.out.println();

            } else if (action == 3) {
                System.out.print("Enter the student name that you wish to remove : ");
                input = sc.nextLine();
                studentList.removeElement(input);
                System.out.println("The updated number of students is : " + studentList.getSize());
                System.out.println("The updated student list is : ");
                studentList.printList();
                System.out.println();

            }
        }
        System.out.println("All student data completely captured. Thank You ! ");
    }
}


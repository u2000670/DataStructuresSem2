package com.company.Week1OOPRevision.Lab1;


import java.io.*;
import java.util.Scanner;

public class ReadMyLetter_U2000670 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line;
        String file = "C:\\Users\\LENOVO\\OneDrive - Universiti Malaya\\Desktop\\TasneemSofiyyah_U2000670.txt";
        BufferedReader bf;

        try {
            // Store current System.out before assigning a new value
            PrintStream console = System.out;

            // Creating file output stream
            PrintStream fileOut = new PrintStream(new FileOutputStream(file, true));

            System.out.println("Enter data line by line. Type exit to terminate the ");

            // Redirecting standard console output to a file.
            System.setOut(fileOut);

            // Get input using Scanner from Console
            // Read string line.
            // Write exit to terminate the program
            String inputLine = s.nextLine();

            while (true) {

                // If user input 'quit' then break the loop.
                if ("exit".equalsIgnoreCase(inputLine)) {
                    break;
                }

                System.out.println(inputLine);

                // Get next user input line text.
                inputLine = s.nextLine();
            }

            // Use stored value for output stream
            System.setOut(console);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            bf = new BufferedReader(new FileReader(file));
            line = bf.readLine();
            while (line != null) {
                System.out.println(line);
                line = bf.readLine();
            }

            bf.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}


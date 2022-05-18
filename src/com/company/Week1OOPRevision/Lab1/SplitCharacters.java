package com.company.Week1OOPRevision.Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SplitCharacters {


    public static void delimiter(String pattern, String filepath, int fileNum) {
        String line;
        BufferedReader br;
        StringBuilder sb = new StringBuilder(300);

        try {
            br = new BufferedReader(new FileReader(filepath));
            line = br.readLine();
            while (line != null) {
                String[] chars = (line.split(pattern));

                for (String c : chars) {
                    System.out.print(c + " ");
                }
                System.out.println("");

                for (String aChar : chars) {
                    sb.append(aChar);
                }

                line = br.readLine();
            }

            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println("");

    }

    public static void main(String[] args) {
        String file1 = "C:\\Users\\LENOVO\\OneDrive - Universiti Malaya\\Documents\\NetBeansProjects\\DataStructure\\files\\text1.txt";
        String file2 = "C:\\Users\\LENOVO\\OneDrive - Universiti Malaya\\Documents\\NetBeansProjects\\DataStructure\\files\\text2.txt";
        String file3 = "C:\\Users\\LENOVO\\OneDrive - Universiti Malaya\\Documents\\NetBeansProjects\\DataStructure\\files\\text3.txt";
        String file4 = "C:\\Users\\LENOVO\\OneDrive - Universiti Malaya\\Documents\\NetBeansProjects\\DataStructure\\files\\text4.txt";

        delimiter(",", file1, 1);
        delimiter(", ", file2, 2);
        delimiter("; ", file3, 3);
        delimiter("123|456|789", file4, 4);
        //regex OR operator -> | <-

    }
}


package com.company.Week9LabTest2.LabTest2;

import java.io.*;
import java.util.ArrayList;

public class Question1_Queue {
    public static void main(String[] args) {
        File filePath = new File(
                "C:\\Users\\LENOVO\\OneDrive - Universiti Malaya\\Documents\\Tasneem Docs\\Degree\\DS\\program3\\DataStructures\\src\\com\\company\\Week9LabTest2\\LabTest2\\labtest2.txt");

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath));

            ArrayList<String> productCodes = new ArrayList<>();
            ArrayList<MyQueue<String>> listOfProductQueues = new ArrayList<>();

            String input;
            while ((input = br.readLine()) != null) {
                //input would be one line of the text file
                String[] inputArray = input.split(" ");
                int count = 0;

                for (int i = 0; i < inputArray.length; i++) {

                    //if product code hasn't existed yet in productCodes list
                    if (!productCodes.contains(inputArray[i])) {

                        productCodes.add(inputArray[i]);    //add product code to prodcutCode list
                        listOfProductQueues.add(new MyQueue<>());   //creates a new Queue in the array list
                        listOfProductQueues.get(i - count).enqueue(inputArray[++i]);    //adds the product into the queue

                    } else {    //if it's an existing product code
                        int queueIndex = productCodes.indexOf(inputArray[i]);       //find index for the existing product coed in productCode list
                        listOfProductQueues.get(queueIndex).enqueue(inputArray[++i]);   //adds the product into the queue of the corresponding product code
                        count++;
                    }
                    count++;
                }
            }
            //printing the productcodes along with its queues
            for (int i = 0; i < productCodes.size(); i++) {
                System.out.println(productCodes.get(i));
                System.out.println(listOfProductQueues.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


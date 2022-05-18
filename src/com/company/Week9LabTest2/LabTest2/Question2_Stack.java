package com.company.Week9LabTest2.LabTest2;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Question2_Stack {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\LENOVO\\OneDrive - Universiti Malaya\\Documents\\Tasneem Docs\\Degree\\DS\\program3\\DataStructures\\src\\com\\company\\Week9LabTest2\\test.xml";
//        String filePath = "test.xml";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filePath));
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

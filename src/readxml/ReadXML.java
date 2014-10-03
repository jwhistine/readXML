/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readxml;

import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * @author mormon
 */
public class ReadXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ReadXML().run();
    }
    
    public void run() {
        String file = "c:/books.xml";
        List<String> list = readFile(file);
        //displayList(list);
    }
    
    // <Entry>
    public List<String> readFile(String file) {
        try {
            File xmlFile = new File("c:/books.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            
            doc.getDocumentElement().normalize();
            
            System.out.println("Loading File \"" + file + "\"...\n");
            
            NodeList list = doc.getElementsByTagName("entry");
            
            System.out.println("Journal: \n");
            
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                
                System.out.println("Entry: ");
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                   Element element = (Element) node;
                  
                   String date = element.getAttribute("date");
                   System.out.println("Date: " + date);
                   System.out.println("Content: " + element.getTextContent().trim());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void displayList(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}

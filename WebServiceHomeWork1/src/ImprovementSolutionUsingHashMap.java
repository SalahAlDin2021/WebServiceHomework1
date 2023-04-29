import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// this solution to improve time complexity from O(n) to O(1) using HashMap Data Structure
// we load the book elements to the HashMap and set the key is id and the value is Book Element
// then every time we need to search the book using id we just set the key id, and if this id is exist -> print it

public class ImprovementSolutionUsingHashMap {
static HashMap<String,Element> bookMap=new HashMap<>();
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		

        File inputFile = new File("books.xml");
		
		//create DocumentBuilderFactoury and DocumentBuilder
		DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//Create a Document from a file or stream
		Document document = builder.parse(inputFile);
		document.getDocumentElement().normalize();
		//get book elements from the xml file
        NodeList bookList = document.getElementsByTagName("book");
        for (int i = 0; i < bookList.getLength(); i++) {
            Element book = (Element) bookList.item(i);
            String book_id = book.getAttribute("id");
            bookMap.put(book_id, book);
          }
        //get the id of the book from user from consol
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the ID of the book:");
        String id=scan.next();
        scan.close();
        //call the function to get book using ID
        getBookFromID( id);
	}
	
	
	
	private static void getBookFromID(String id) {
			//get the book element from the HashMap(bookMap)
	        Element book = bookMap.get(id);
	        //check if the book with needed id is exist
	        if (book!= null) {
	        	//print book information
	          String author = book.getElementsByTagName("author").item(0).getTextContent();
	          String title = book.getElementsByTagName("title").item(0).getTextContent();
	          String genre = book.getElementsByTagName("genre").item(0).getTextContent();
	          String price = book.getElementsByTagName("price").item(0).getTextContent();
	          String publishDate = book.getElementsByTagName("publish_date").item(0).getTextContent();
	          String description = book.getElementsByTagName("description").item(0).getTextContent();

	          System.out.println("Book ID: " + id);
	          System.out.println("Author: " + author);
	          System.out.println("Title: " + title);
	          System.out.println("Genre: " + genre);
	          System.out.println("Price: " + price);
	          System.out.println("Publish Date: " + publishDate);
	          System.out.println("Description: " + description);
	          System.out.println("--------------------------");
	        }
	}

}

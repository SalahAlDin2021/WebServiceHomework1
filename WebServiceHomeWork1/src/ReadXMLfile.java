import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Scanner;

public class ReadXMLfile {
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
        //get the id of the book from user from consol
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the ID of the book:");
        String id=scan.next();
        scan.close();
        //call
        getBookFromID(bookList, id);
	}
	
	
	
	private static void getBookFromID( NodeList bookList,String id) {
		//loop the books in the bookList
		for (int i = 0; i < bookList.getLength(); i++) {
			//get the book element from the bookList
	        Element book = (Element) bookList.item(i);
	        //get the id of the book element
	        String book_id = book.getAttribute("id");
	        //check if the book id equals the needed id and print the data of book if there are equals
	        if (book_id.equals(id)) {
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
	          break;
	        }
	      }
	}

}

package Lessons.Lesson21.XML.DOM;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Person {
    String firstName;
    String secondName;
    PlaceOfBirth placeOfBirth;
    String id;

    static class PlaceOfBirth {
        String city;
        String country;
    }
}

public class XMLDomParser {
    public static void main(String[] arg) throws SAXException, IOException {
        List<Person> l = new ArrayList<Person>();
        Document doc = null;
        DOMParser parser = new DOMParser();

        parser.parse("first.xml");
        doc = parser.getDocument();
        Element root = doc.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName("person");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element person = (Element) nodeList.item(i);
            Person p = new Person();
            p.id = person.getAttribute("id");

            Element firstName = (Element) person.getElementsByTagName("firstName").item(0);
            p.firstName = ((Text) firstName.getFirstChild()).getNodeValue();

            Element secondName = (Element) person.getElementsByTagName("secondName").item(0);
            p.secondName = ((Text) secondName.getFirstChild()).getNodeValue();

            Element placeOfBirth = (Element) person.getElementsByTagName("placeOfBirth").item(0);
            Person.PlaceOfBirth p1 = new Person.PlaceOfBirth();
            p.placeOfBirth = p1;

            Element city = (Element) placeOfBirth.getElementsByTagName("city").item(0);
            p1.city = ((Text) city.getFirstChild()).getNodeValue();


            Element country = (Element) placeOfBirth.getElementsByTagName("country").item(0);
            p1.country = ((Text) country.getFirstChild()).getNodeValue();

            l.add(p);
        }
        for (Person p : l) {
            System.out.println("-----------------------");
            System.out.println(p.id);
            System.out.println(p.firstName);
            System.out.println(p.secondName);
            System.out.println(p.placeOfBirth.city);
            System.out.println(p.placeOfBirth.country);
        }
    }
}

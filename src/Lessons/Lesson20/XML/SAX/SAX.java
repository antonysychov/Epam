package Lessons.Lesson20.XML.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAX {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        Persons persons = new Persons();
        parser.parse("first.xml", persons); //в Persons заключена логика парсера
        List<Person> personsList = persons.getPersons();
        for (Person person : personsList) {
            System.out.println();
            System.out.println(person.firstName);
            System.out.println(person.secondName);
            System.out.println(person.id);
            System.out.println(person.placeOfBirth);
        }
    }
}

class Persons extends DefaultHandler {
    List<Person> l = new ArrayList<>();
    Person p;
    int flag = 0;

    public List<Person> getPersons() {
        return l;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("starting parsing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "root":
                break;
            case "person":
                p = new Person();
                p.id = attributes.getValue("id"); // or getValue(0)
                break;
            case "firstName":
                flag = 1;
                break;
            case "secondName":
                flag = 2;
                break;
            case "placeOfBirth":
                p.placeOfBirth = new Person.PlaceBirth();
                break;
            case "city":
                flag = 3;
                break;
            case "country":
                flag = 4;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String s = new String(ch, start, length);
        switch (flag) {
            case 1:
                p.firstName = s;
                break;
            case 2:
                p.secondName = s;
                break;
            case 3:
                p.placeOfBirth.city = s;
                break;
            case 4:
                p.placeOfBirth.country = s;
                break;
            default:
                System.out.println("error");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "root":
                break;
            case "person":
                l.add(p);
                p = null;
                flag = 0;
                break;
        }
    }
}

class Person {
    String firstName;
    String secondName;
    PlaceBirth placeOfBirth;
    String id;

    static class PlaceBirth {
        String city;
        String country;

    }
}


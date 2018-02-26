package xmltask;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xmltask.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CustomHandler extends DefaultHandler {

    private List<Person> people = new ArrayList<>();

    private Person person = new Person();

    private boolean isName;
    private boolean isAddress;
    private boolean isCash;


    public List<Person> getPerson() {
        return people;
    }



    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if(isName) {
            person.setName(new String(ch,start,length));
            isName = false;
        }
        if(isAddress) {
            person.setAddress(new String(ch,start,length));
            isAddress = false;
        }
        if(isCash) {
            person.setCash(Integer.parseInt(new String(ch,start,length)));
            isCash = false;
        }
        super.characters(ch, start, length);
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if(qName.equalsIgnoreCase("person")) {
            person = new Person();
        }

        if(qName.equals("name")) {
            isName = true;
        }
        if(qName.equals("address")) {
            isAddress = true;
        }
        if(qName.equals("cash")){
            isCash = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("person")) {
            people.add(person);
            person = null;
        }
    }
}

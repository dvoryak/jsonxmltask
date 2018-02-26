package xmltask;

import org.xml.sax.SAXException;
import xmltask.model.Catalog;
import xmltask.model.Notebook;
import xmltask.model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Application application = new Application();
        application.xmlSaxParse();
    }

    public void createXmlFile(String path) throws IOException {
        File file = new File(path);
        if(!file.exists()) {
            file.createNewFile();
        }

        Person person = new Person(1,"name","address",9999,"ntu");
        Person person1 = new Person(2,"name","address",9999,"ntu");
        Person person2 = new Person(3,"name","address",9999,"ntu");

        Notebook notebook = new Notebook(Arrays.asList(person,person1,person2));
        Catalog catalog = new Catalog();
        catalog.setNotebook(notebook);

        try {
            Marshaller marshaller = JAXBContext.newInstance(Catalog.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(catalog,file);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public void xmlSaxParse() throws ParserConfigurationException, SAXException, IOException {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        CustomHandler dh = new CustomHandler();
        saxParser.parse(new File("file.xml"), dh);
        for (Person person : dh.getPerson()) {
            if(person.getCash() > 10000) {
                System.out.println(person);
            }
        }
    }
}

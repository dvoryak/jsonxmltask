package xmltask.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Notebook {
    private List<Person> person;

    public Notebook(List<Person> person) {
        this.person = person;
    }

    public Notebook() {
        this.person = new ArrayList<>();
    }

    @XmlElement
    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "person=" + person +
                '}';
    }
}

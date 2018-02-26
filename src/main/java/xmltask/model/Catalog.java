package xmltask.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Catalog {
    private Notebook notebook;

    public Catalog() {
    }

    public Catalog(Notebook notebook) {
        this.notebook = notebook;
    }

    @XmlElement
    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "notebook=" + notebook +
                '}';
    }
}

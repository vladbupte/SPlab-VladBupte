
package ro.uvt.dp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("BOOK")
public class Book extends BaseElement {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Author> authors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BaseElement> contents = new ArrayList<>();

    public Book() { super(); }

    public Book(String title) { super(title); }

    public List<Author> getAuthors() { return authors; }
    public List<BaseElement> getContents() { return contents; }

    public void addAuthor(Author a) { authors.add(a); }
    public void addContent(BaseElement e) { contents.add(e); }

    @Override
    public void print() {
        System.out.println("Book: " + getTitle());
        System.out.println("Authors:");
        for (Author a : authors) {
            System.out.println("Author: " + a.getName());
        }
        for (BaseElement e : contents) {
            e.print();
        }
    }
}

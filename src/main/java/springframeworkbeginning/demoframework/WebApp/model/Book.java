package springframeworkbeginning.demoframework.WebApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String isbn;

    @OneToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book",joinColumns = @JoinColumn(name="book_id"),
    inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors=new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //constructor
    public Book(){
    }

    //constructor with first name and last name
    public Book(String title, String isbn, Publisher publisher){
        this.title=title;
        this.isbn=isbn;
        this.publisher=publisher;
    }
    public Book(String title, String isbn, Publisher publisher, Set<Author> authors){
        this.title=title;
        this.isbn=isbn;
        this.publisher=publisher;
        this.authors =authors;
    }

    //methods

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
    public Set<Author> getAuthors() {
        return authors;
    }
}

package springframeworkbeginning.demoframework.WebApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    // id for connection
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //the first name and the last name
    private String fname;
    private String lname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books=new HashSet<>();

    //constructor
    public Author(){
    }

    //constructor with first name and last name
    public Author(String fname, String lname){
        this.fname=fname;
        this.lname=lname;
    }
    public Author(String fname, String lname, Set<Book> books){
        this.fname=fname;
        this.lname=lname;
        this.books=books;
    }

    //methods

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setFname(String fname){
        this.fname=fname;
    }
    public String getFname(){
        return fname;
    }
    public void setLname(String lname){
        this.lname=lname;
    }
    public String getLname() {
        return lname;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    public Set<Book> getBooks() {
        return books;
    }
}

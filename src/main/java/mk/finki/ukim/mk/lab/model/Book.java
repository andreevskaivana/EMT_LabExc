package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.mk.lab.model.enumeration.BookCategory;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private BookCategory category;
    @ManyToOne
    private Author author;
    private int availableCopies;

    public Book(String name,BookCategory category,Author author,int availableCopies){
        this.name=name;
        this.category=category;
        this.author=author;
        this.availableCopies=availableCopies;
    }

    public Book() {

    }
}


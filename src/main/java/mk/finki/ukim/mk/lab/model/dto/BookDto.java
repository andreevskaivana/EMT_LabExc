package mk.finki.ukim.mk.lab.model.dto;

import lombok.Data;
import mk.finki.ukim.mk.lab.model.enumeration.BookCategory;

@Data
public class BookDto {
    private String name;
    private BookCategory bookCategory;
    private Long authorId;
    private int availableCopies;

    public BookDto(String name, BookCategory bookCategory, Long authorId, int availableCopies) {
        this.name = name;
        this.bookCategory = bookCategory;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}

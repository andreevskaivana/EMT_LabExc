package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.enumeration.BookCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesRestController {


    @GetMapping
    public ResponseEntity<BookCategory[]>findCategories(){
        return ResponseEntity.ok(BookCategory.values());
    }
}
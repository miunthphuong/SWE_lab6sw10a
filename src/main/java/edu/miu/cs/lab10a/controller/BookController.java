package edu.miu.cs.lab10a.controller;

import edu.miu.cs.lab10a.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    @GetMapping("/elibrary/book/list")
    public String listBooks(Model model) {
        List<Book> books = List.of(
                new Book(1L, "978-0134685991", "Effective Java", "Joshua Bloch", 45.99),
                new Book(2L, "978-1617294945", "Spring in Action", "Craig Walls", 39.99),
                new Book(3L, "978-0596009205", "Head First Java", "Kathy Sierra", 35.50),
                new Book(4L, "978-0321356680", "Java Concurrency in Practice", "Brian Goetz", 49.99),
                new Book(5L, "978-0132350884", "Clean Code", "Robert C. Martin", 42.00)
        );

        model.addAttribute("books", books);
        return "book/list";
    }
}
package com.catalog.demo;

import com.catalog.domain.Book;
import com.catalog.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile(value = "testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;
    private final Environment environment;

    public BookDataLoader(BookRepository bookRepository, Environment environment) {
        this.bookRepository = bookRepository;
        this.environment = environment;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();
        var book1 = Book.of("1234567891", "Northern Lights", "Lyra Silvedrstar", 9.90);
        var book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90);
        bookRepository.saveAll(List.of(book1, book2));
    }
}

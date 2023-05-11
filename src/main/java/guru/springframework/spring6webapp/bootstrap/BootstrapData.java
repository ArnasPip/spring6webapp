package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author johnSaved = authorRepository.save(john);
        Book dddSaved = bookRepository.save(ddd);

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Coolio");

        Book tr = new Book();
        tr.setTitle("Two Roosters");
        tr.setIsbn("414132432");

        Author ericSaved = authorRepository.save(eric);
        Book trSaved = bookRepository.save(tr);

        johnSaved.getBooks().add(dddSaved);
        ericSaved.getBooks().add(trSaved);

        authorRepository.save(johnSaved);
        authorRepository.save(ericSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

    }
}

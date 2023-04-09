package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author sam=new Author();
        sam.setNom("sam");
        sam.setPrenom("francaois");

        Book maths=new Book();
        maths.setTitle("mathematique pour les nul");
        maths.setIsbn("d56226d");

        Author quak=new Author();
        quak.setNom("quak");
        quak.setPrenom("quak quak");

        Book gamers=new Book();
        gamers.setTitle("mathematique pour les gamers");
        gamers.setIsbn("gamers");

        Author samSaved= authorRepository.save(sam);
        Book mathSaved= bookRepository.save(maths);

        Author quakSaved= authorRepository.save(quak);
        Book gamersSaved= bookRepository.save(gamers);

        samSaved.getBooks().add(mathSaved);
        quakSaved.getBooks().add(gamersSaved);

        authorRepository.save(samSaved);
        authorRepository.save(quakSaved);

        System.out.println("Bootstrap:----");
        System.out.println("Authors Count : "+authorRepository.count());
        System.out.println("Books : "+bookRepository.count());

        Publisher salah=new Publisher();
        salah.setPublisherName("salah");
        Publisher saka=new Publisher();
        saka.setPublisherName("saka");

        publisherRepository.save(salah);
        publisherRepository.save(saka);
        System.out.println("Publishers : "+publisherRepository.count());




    }
}

package dao;

import models.Book;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class FakeBookDao implements BookDao {

    final Book fakeBook = new Book(1, "Fake Book");

    public Book create(Book book) {
        return fakeBook;
    }

    public Optional<Book> read(Integer Id) {
        return Optional.of(fakeBook);
    }

    public Book update(Book book) {
        return fakeBook;
    }
    public Book delete(Integer Id) {
        return  fakeBook;
    }

    public Collection<Book> all() {
        return Arrays.asList(fakeBook);
    }
}

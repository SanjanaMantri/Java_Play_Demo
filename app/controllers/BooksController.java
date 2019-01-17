package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dao.BookDao;
import dao.BookDaoImpl;
import com.google.inject.Inject;
import models.Book;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Collection;
import java.util.Optional;


public class BooksController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(BooksController.class);
    final BookDao bookDao;

    @Inject
    public BooksController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

//    int index = 0;
//    final Map<Integer , Book> books = new HashMap<>();
    @Transactional
    public Result createBook()  {
        final JsonNode json = request().body().asJson();

        final Book book = Json.fromJson(json, Book.class);

        LOGGER.debug("Book title = " + book.getTitle());
        LOGGER.error("This is an error");

        if (null == book.getTitle()) {
            return badRequest("Title must be provided");
        }

        final Book newBook = bookDao.create(book);

        final JsonNode result = Json.toJson(newBook);

        return ok(result);

    }

    @Transactional
    public Result getBookById(Integer Id) {

        if (null == Id) {
            return badRequest("Id must be provided");
        }
        final Optional<Book> book = bookDao.read(Id);
        if(book.isPresent()) {

            final JsonNode result = Json.toJson(book.get());
            return ok(result);
        }
        else {
            return notFound();
        }

    }

    @Transactional
    public Result updateBookById(Integer Id) {

        if(null == Id){
            return badRequest("Id must be provided");
        }
        final JsonNode json = request().body().asJson();
        final Book newBook = Json.fromJson(json, Book.class);

        newBook.setId(Id);

        final Book updatedBook = bookDao.update(newBook);

        final JsonNode result = Json.toJson(updatedBook);


        return ok(result);
    }

    @Transactional
    public Result deleteBookById(Integer Id) {
    if (null == Id) {
        return badRequest("Id must be provided");
    }

    final Book book = bookDao.delete(Id);


    final JsonNode result = Json.toJson(book);
    return ok(result);
    }

    @Transactional
    public Result getAllBooks() {

    /*TypedQuery<Book> query = jpaApi.em().createQuery("SELECT b FROM Book b", Book.class);
    List<Book> books = query.getResultList();*/

    Collection<Book> books = bookDao.all();

    final JsonNode result = Json.toJson(books);

    return ok(result);
    }

}

package ru.mirea.smirnov.library;

import ru.mirea.smirnov.book.Book;
import ru.mirea.smirnov.reader.Reader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private final Map<String, Book> catalogBook;

    private final Map<Integer, Reader> readers;

    public Library() {
        this.catalogBook = new HashMap<>();
        this.readers = new HashMap<>();
    }

    public Book getBook(String name) {
        return this.catalogBook.remove(name);
    }

    public void addToCatalog(Book book) {
        this.catalogBook.putIfAbsent(book.getName(), book);
    }

    public void addReader(Reader reader) {
        this.readers.putIfAbsent(reader.getrId(), reader);
    }

    public List<Book> getCatalog() {
        return this.catalogBook.values().stream().toList();
    }

    public List<Reader> getReaders() {
        return this.readers.values().stream().toList();
    }

}

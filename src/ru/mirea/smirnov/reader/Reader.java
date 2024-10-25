package ru.mirea.smirnov.reader;

import ru.mirea.smirnov.book.Book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Reader {

    private int rId;

    private String name;

    private LocalDate registrationDate;

    private Map<String, Book> takenBooks;

    public Reader(String name){
        this.name = name;
        this.rId = ThreadLocalRandom.current().nextInt(1000);
        this.registrationDate = LocalDate.now();
        this.takenBooks = new HashMap<>();
    }

    public int getrId() {
        return rId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getTakenBooks(){
        return takenBooks.values().stream().toList();
    }

    public void takeBook(Book book){
        this.takenBooks.putIfAbsent(book.getName(), book);
    }

    @Override
    public String toString() {
        return this.getName();
    }

}

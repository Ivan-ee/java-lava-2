package ru.mirea.smirnov.book;

public class Book {
    private String name;

    private String author;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

import ru.mirea.smirnov.book.Book;
import ru.mirea.smirnov.library.Library;
import ru.mirea.smirnov.reader.Reader;

public class Main {
    public static void main(String[] args) {

        int maxBookToGive = 3;

        String[] bookNames = new String[]{
                "Звёздные Путешественники",
                "Тайна Лунного Кристалла",
                "Остров Сокровищ",
                "Идиот",
                "Преступление и наказание",
                "Вишнёвый сад",
                "Отцы и дети",
                "Евгений Онегин",
                "Ревизор",
                "Мёртвые души"
        };

        String[] readerNames = new String[]{
                "Митя",
                "Роман",
                "Митрофан",
                "Никита",
                "Артём"
        };

        Library library = new Library();

        for (String bookName : bookNames) {
            Book book = new Book(bookName);
            library.addToCatalog(book);
        }

        System.out.println("Книги в библиотеке:");
        System.out.println(library.getCatalog().toString());

        for (String readerName : readerNames) {
            Reader reader = new Reader(readerName);
            library.addReader(reader);
        }

        System.out.println("Читатели в библиотеке:");
        System.out.println(library.getReaders().toString());

        int countBooksInLibrary = library.getCatalog().size();

        for (Reader reader : library.getReaders()) {
            if (countBooksInLibrary == 0) {
                System.out.println("В библиотеке закончились книги");
                break;
            }

            int countBooksToGive = (int) (Math.random() * maxBookToGive + 1);

            if (countBooksToGive == 0) {
                System.out.printf("Читатель %s не хочет брать книги", reader.getName());
                continue;
            }

            if (countBooksInLibrary < countBooksToGive) {
                System.out.printf("Читатель %s хочет взять больше книг (%d), чем есть в библиотеке (%d)%n", reader.getName(), countBooksToGive, countBooksInLibrary);
                countBooksToGive = (int) (Math.random() * countBooksInLibrary + 1);
            }

            System.out.printf("%s возьмёт %d шт%n", reader.getName(), countBooksToGive);

            for (int i = 0; i < countBooksToGive; i++) {

                int idx = (int) (Math.random() * library.getCatalog().size());

//              Вот этот момент не нравится, получается дважды беру книгу
                Book book = library.getCatalog().get(idx);
                book = library.getBook(book.getName());

                reader.takeBook(book);

                System.out.printf("%s взял книгу %s%n", reader.getName(), book.getName());

                countBooksInLibrary--;
            }
        }

        int countBooksInReaders = 0;

        for (Reader reader : library.getReaders()) {

            int countBooks = reader.getTakenBooks().size();

            countBooksInReaders += countBooks;

            if (countBooks == 0) {
                System.out.printf("У %s нет книг%n", reader.getName());
                continue;
            }

            System.out.printf("У %s такие книги:%n", reader.getName());

            for (Book book : reader.getTakenBooks()) {
                System.out.println(book.getName());
            }

            System.out.println(" ");
        }

        System.out.printf("Всего у читателей %d книг%n", countBooksInReaders);

        System.out.printf("Оставшихся книг в библиотеке: %d%n", countBooksInLibrary);

        if (countBooksInLibrary > 0) {
            for (Book book : library.getCatalog()) {
                System.out.println(book.getName());
            }
        }
    }
}
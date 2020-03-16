public class Book implements Item {

    private String bookName;
    private int pagesNumber;
    private double bookValue;


    public Book(String bookName, int pagesNumber, double bookValue) {
        this.bookName = bookName;
        this.pagesNumber = pagesNumber;
        this.bookValue = bookValue;
    }

    @Override
    public String getName() {
        return bookName;
    }

    @Override
    public double getValue() {
        return bookValue;
    }

    @Override
    public double getWeight() {
        return pagesNumber / 100.0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", pagesNumber=" + pagesNumber +
                ", value=" + bookValue +
                ", weight=" + getWeight() +
                ", profitFactor=" + getProfitFactor() +
                '}';
    }
}

package peaksoft.book;

import peaksoft.exceptions.InvalidPercentException;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.BiFunction;

/**
 * @author Beksultan
 */
public class Book {
    private String bookName;
    private String authorFullName;
    private TypeOfBook typeOfBook;
    private int pageSize;
    private BigDecimal price;
    private boolean bestSeller;
    private LocalDate yearOfIssue;
    private int like;
    private int discount;

    public Book() {
    }

    public Book(String bookName,
                String authorFullName,
                TypeOfBook typeOfBook,
                int pageSize,
                BigDecimal price,
                boolean bestSeller,
                LocalDate yearOfIssue,
                int like,
                int discount) {
        this.bookName = bookName;
        this.authorFullName = authorFullName;
        this.typeOfBook = typeOfBook;
        this.pageSize = pageSize;
        this.price = price;
        this.bestSeller = bestSeller;
        this.yearOfIssue = yearOfIssue;
        this.like = like;
        this.discount = discount;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountedPrice() {
        BiFunction<BigDecimal, Integer, BigDecimal> findByPercent = (bigDecimal, percent) -> {
            if (percent > 100 || percent < 0) {
                throw new InvalidPercentException(
                        "percent should be less than 100 and more than 0: your percent: " +  percent
                );
            }

            BigDecimal bigDecimalPercent = BigDecimal.valueOf(percent);
            BigDecimal hundredPercent = BigDecimal.valueOf(100);
            BigDecimal result = bigDecimal.multiply(bigDecimalPercent).divide(hundredPercent);
            return bigDecimal.subtract(result);
        };
        return findByPercent.apply(price, discount);
    }

    @Override
    public String toString() {
        return "Book [" +
                "bookName = " + bookName +
                " authorFullName = " + authorFullName +
                " pageSize = " + pageSize +
                " price = " + price +
                " bestSeller = " + bestSeller +
                " like = " + like +
                " discount = " + discount +
                ']';
    }
}

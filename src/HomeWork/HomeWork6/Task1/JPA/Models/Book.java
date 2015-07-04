package HomeWork.HomeWork6.Task1.JPA.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "BOOKS", schema = "APP", catalog = "")
public class Book {
    private int librarykey;
    private String title;
    private Date publishingdate;
    private String publishingplace;
    private String publishinghouse;

    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    private User occupiedBy;

    public User getOccupiedBy() {
        return occupiedBy;
    }

    public void setOccupiedBy(User occupiedBy) {
        this.occupiedBy = occupiedBy;
    }

    @Id
    @Column(name = "LIBRARYKEY", nullable = false, insertable = true, updatable = true)
    public int getLibrarykey() {
        return librarykey;
    }

    public void setLibrarykey(int librarykey) {
        this.librarykey = librarykey;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, insertable = true, updatable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "PUBLISHINGDATE", nullable = false, insertable = true, updatable = true)
    public Date getPublishingdate() {
        return publishingdate;
    }

    public void setPublishingdate(Date publishingdate) {
        this.publishingdate = publishingdate;
    }

    @Basic
    @Column(name = "PUBLISHINGPLACE", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPublishingplace() {
        return publishingplace;
    }

    public void setPublishingplace(String publishingplace) {
        this.publishingplace = publishingplace;
    }

    @Basic
    @Column(name = "PUBLISHINGHOUSE", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPublishinghouse() {
        return publishinghouse;
    }

    public void setPublishinghouse(String publishinghouse) {
        this.publishinghouse = publishinghouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book that = (Book) o;

        if (librarykey != that.librarykey) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (publishingdate != null ? !publishingdate.equals(that.publishingdate) : that.publishingdate != null)
            return false;
        if (publishingplace != null ? !publishingplace.equals(that.publishingplace) : that.publishingplace != null)
            return false;
        if (publishinghouse != null ? !publishinghouse.equals(that.publishinghouse) : that.publishinghouse != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = librarykey;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (publishingdate != null ? publishingdate.hashCode() : 0);
        result = 31 * result + (publishingplace != null ? publishingplace.hashCode() : 0);
        result = 31 * result + (publishinghouse != null ? publishinghouse.hashCode() : 0);
        return result;
    }
}

package HomeWork.HomeWork6.Task1.JPA.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "USERS", schema = "APP", catalog = "")
public class User {
    private int librarycard;
    private String surname;
    private String name;
    private String patronymic;
    private Date checkindate;


    @Id
    @Column(name = "LIBRARYCARD", nullable = false, insertable = true, updatable = true)
    public int getLibrarycard() {
        return librarycard;
    }

    public void setLibrarycard(int librarycard) {
        this.librarycard = librarycard;
    }

    @Basic
    @Column(name = "SURNAME", nullable = false, insertable = true, updatable = true, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PATRONYMIC", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "CHECKINDATE", nullable = false, insertable = true, updatable = true)
    public Date getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(Date checkindate) {
        this.checkindate = checkindate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (librarycard != that.librarycard) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;
        if (checkindate != null ? !checkindate.equals(that.checkindate) : that.checkindate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = librarycard;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (checkindate != null ? checkindate.hashCode() : 0);
        return result;
    }
}

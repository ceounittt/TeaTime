package ru.ceounit.teatime.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ListIterator;
import java.util.Objects;

@Entity
@Table(name = "usr")
public class User implements ListIterator<User> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.email);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' + ", email='" + this.email + '\'' + '}';
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public User next() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public User previous() {
        return null;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(User user) {

    }

    @Override
    public void add(User user) {

    }
}

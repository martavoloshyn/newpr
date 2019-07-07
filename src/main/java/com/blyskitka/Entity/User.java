package Entity;

import java.util.Objects;

public class User {
    Integer id;
    String surname;
    String name;
    String phoneNumber;
    String email;
    String city;
    String street;
    Integer house;
    Integer apartment;
    String login;
    String password;

    public User() {
    }

    public User(Integer id, String surname, String name, String phoneNumber, String email, String city, String street, Integer house, Integer apartment, String login, String password) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                surname.equals(user.surname) &&
                name.equals(user.name) &&
                phoneNumber.equals(user.phoneNumber) &&
                email.equals(user.email) &&
                city.equals(user.city) &&
                street.equals(user.street) &&
                house.equals(user.house) &&
                apartment.equals(user.apartment) &&
                login.equals(user.login) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, login);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

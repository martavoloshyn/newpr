package Entity;

import java.util.Objects;

public class Article {
    Integer id;
    String name;
    String category;
    Double price;
    String description;
    String country;
    String photo;
    Double volume;
    String tradeMark;

    public Article() {
    }

    public Article(Integer id, String name, String category, Double price, String description, String country, String photo, Double volume, String tradeMark) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.country = country;
        this.photo = photo;
        this.volume = volume;
        this.tradeMark = tradeMark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id) &&
                name.equals(article.name) &&
                category.equals(article.category) &&
                price.equals(article.price) &&
                Objects.equals(description, article.description) &&
                country.equals(article.country) &&
                Objects.equals(photo, article.photo) &&
                Objects.equals(volume, article.volume) &&
                tradeMark.equals(article.tradeMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, country, volume, tradeMark);
    }
    //vfd
}

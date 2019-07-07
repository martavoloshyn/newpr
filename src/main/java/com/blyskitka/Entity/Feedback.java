package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Feedback {
    Integer id;
    Integer idArticle;
    Integer idUser;
    String text;
    LocalDate publicationDate;
    Integer starsAmount;

    public Feedback() {
    }

    public Feedback(Integer id, Integer idArticle, Integer idUser, String text, LocalDate publicationDate, Integer starsAmount) {
        this.id = id;
        this.idArticle = idArticle;
        this.idUser = idUser;
        this.text = text;
        this.publicationDate = publicationDate;
        this.starsAmount = starsAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getStarsAmount() {
        return starsAmount;
    }

    public void setStarsAmount(Integer starsAmount) {
        this.starsAmount = starsAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return id.equals(feedback.id) &&
                idArticle.equals(feedback.idArticle) &&
                idUser.equals(feedback.idUser) &&
                Objects.equals(text, feedback.text) &&
                publicationDate.equals(feedback.publicationDate) &&
                starsAmount.equals(feedback.starsAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idArticle, idUser, publicationDate);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", idArticle=" + idArticle +
                ", idUser=" + idUser +
                ", text='" + text + '\'' +
                ", publicationDate=" + publicationDate +
                ", starsAmount=" + starsAmount +
                '}';
    }
}

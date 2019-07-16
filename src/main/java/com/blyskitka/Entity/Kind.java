package com.blyskitka.Entity;

import com.blyskitka.Enums.Category;

import java.util.Objects;

public class Kind {
    Integer id;
    String kind;
    Category category;

    public Kind() {
    }

    public Kind(Integer id, String kind, Category category) {
        this.id = id;
        this.kind = kind;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kind kind1 = (Kind) o;
        return id.equals(kind1.id) &&
                kind.equals(kind1.kind) &&
                category == kind1.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kind, category);
    }

    @Override
    public String toString() {
        return "Kind{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", category=" + category +
                '}';
    }
}

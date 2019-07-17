package com.blyskitka.Entity;

import java.util.Objects;

public class Category {

    private Integer id;

    private String category;

    public Category() {
    }

    public Category(Integer id, String category) {
        this.id = id;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category1 = (Category) o;
        return id.equals(category1.id) &&
                category.equals(category1.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }

    @Override
    public String toString() {
        return "Category{"
                + "id=" + id
                + ", category=" + category + '\''
                + '}';
    }
}

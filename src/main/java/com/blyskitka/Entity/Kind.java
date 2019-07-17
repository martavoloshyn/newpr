package com.blyskitka.Entity;


import java.util.Objects;

public class Kind {

    private Integer id;

    private String kind;

    private Integer idCategory;


    public Kind() {
    }

    public Kind(Integer id, String kind, Integer idCategory) {
        this.id = id;
        this.kind = kind;
        this.idCategory = idCategory;
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

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kind kind1 = (Kind) o;
        return id.equals(kind1.id) &&
                kind.equals(kind1.kind) &&
                idCategory == kind1.idCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kind, idCategory);
    }

    @Override
    public String toString() {
        return "Kind{"
                + "id=" + id +
                ", kind='" + kind + '\'' +
                ", idCategory=" + idCategory +
                '}';
    }
}

package com.blyskitka.DAO.Interfaces;
import Entity.Article;

import java.util.List;

public interface ArticleDao extends Dao<Article> {
    List<Article> getByCategory(String category);
    List<Article> getByName(String name);
    List<Article> getFromPriceDiapason(double fromPrice,double toPrice);

}

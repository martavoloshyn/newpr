package com.blyskitka.DAO.Interfaces;
import Entity.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao extends Dao<Article> {
    List<Article> getByCategory(String category) throws SQLException;
    List<Article> getByName(String name) throws SQLException;
    List<Article> getFromPriceDiapason(double fromPrice,double toPrice) throws SQLException;

}

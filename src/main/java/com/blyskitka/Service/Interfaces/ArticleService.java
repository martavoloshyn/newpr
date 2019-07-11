package com.blyskitka.Service.Interfaces;

import java.sql.SQLException;
import java.util.List;
import Entity.Article;

public interface ArticleService extends Service<Article> {
    List<Entity.Article> getByCategory(String category) throws SQLException;
    List<Entity.Article> getByName(String name) throws SQLException;
    List<Entity.Article> getFromPriceDiapason(double fromPrice, double toPrice) throws SQLException;
}

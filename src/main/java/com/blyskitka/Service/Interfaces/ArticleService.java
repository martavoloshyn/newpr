package com.blyskitka.Service.Interfaces;

import java.sql.SQLException;
import java.util.List;
import com.blyskitka.Entity.Article;

public interface ArticleService extends Service<Article> {
    List<Article> getByKind(Integer idKind) throws SQLException;
    List<Article> getByName(String name) throws SQLException;
    List<Article> getFromPriceDiapason(double fromPrice, double toPrice) throws SQLException;
}

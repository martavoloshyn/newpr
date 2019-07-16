package com.blyskitka.Service.Implementations;

import com.blyskitka.Entity.Article;
import com.blyskitka.DAO.Implementations.ArticleDaoImpl;
import com.blyskitka.DAO.Interfaces.ArticleDao;
import com.blyskitka.Service.Interfaces.ArticleService;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;

    public ArticleServiceImpl() {
        articleDao = new ArticleDaoImpl();
    }

    @Override
    public List<Article> getByKind(Integer idKind) throws SQLException {
        return articleDao.getByKind(idKind);
    }

    @Override
    public List<Article> getByName(String name) throws SQLException {
        return articleDao.getByName(name);
    }

    @Override
    public List<Article> getFromPriceDiapason(double fromPrice, double toPrice) throws SQLException {
        return articleDao.getFromPriceDiapason(fromPrice, toPrice);
    }

    @Override
    public void insert(Article obj) throws SQLException {
        articleDao.insert(obj);
    }

    @Override
    public Article getById(int id) throws SQLException {
        return articleDao.getById(id);
    }

    @Override
    public void update(Article obj) throws SQLException {
        articleDao.update(obj);
    }

    @Override
    public void delete(Article obj) throws SQLException {
        articleDao.delete(obj);
    }

    @Override
    public List<Article> getAll() throws SQLException {
        return articleDao.getAll();
    }
}

package com.blyskitka.DAO.Implementations;

import com.blyskitka.Entity.Article;
import com.blyskitka.DAO.Interfaces.ArticleDao;
import com.blyskitka.JDBC.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    private Connection connection ;

    public ArticleDaoImpl() {
        connection= DBConnection.getConnection();
    }

    public List<Article> getByKind(Integer idKind) throws SQLException {
        String query = "SELECT * FROM articles WHERE idKind = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,idKind);
        List<Article> articles = new ArrayList<Article>() ;
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Article article = new Article();
            article.setId(set.getInt("id"));
            article.setName(set.getString("name"));
            article.setCountry(set.getString("country"));
            article.setDescription(set.getString("description"));
            article.setPhoto(set.getString("photo"));
            article.setPrice(set.getDouble("price"));
            article.setTradeMark(set.getString("tradeMark"));
            article.setVolume(set.getDouble("volume"));
            article.setIdKind(set.getInt("idKind"));
            articles.add(article);
        }
        set.close();
        statement.close();
        return  articles;
    }

    public List<Article> getByName(String name) throws SQLException {
        String query =
                "SELECT * FROM articles WHERE name LIKE CONCAT('%',?,'%')  ;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,name);
        List<Article> articles = new ArrayList<Article>() ;
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Article article = new Article();
            article.setId(set.getInt("id"));
            article.setName(set.getString("name"));
            article.setCountry(set.getString("country"));
            article.setDescription(set.getString("description"));
            article.setPhoto(set.getString("photo"));
            article.setPrice(set.getDouble("price"));
            article.setTradeMark(set.getString("tradeMark"));
            article.setVolume(set.getDouble("volume"));
            article.setIdKind(set.getInt("idKind"));
            articles.add(article);
        }
        set.close();
        statement.close();
        return  articles;
    }

    public List<Article> getFromPriceDiapason(double fromPrice, double toPrice) throws SQLException {
        String query = "SELECT * FROM articles WHERE price>=? AND price<?=;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDouble(1,fromPrice);
        statement.setDouble(2,toPrice);
        List<Article> articles = new ArrayList<Article>() ;
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Article article = new Article();
            article.setId(set.getInt("id"));
            article.setName(set.getString("name"));
            article.setCountry(set.getString("country"));
            article.setDescription(set.getString("description"));
            article.setPhoto(set.getString("photo"));
            article.setPrice(set.getDouble("price"));
            article.setTradeMark(set.getString("tradeMark"));
            article.setVolume(set.getDouble("volume"));
            article.setIdKind(set.getInt("idKind"));
            articles.add(article);
        }
        set.close();
        statement.close();
        return  articles;
    }

    public void insert(Article obj) throws SQLException {
        String query = "INSERT INTO articles (id, name, price, description, country, " +
                "photo, volume, tradeMark, idKind ) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.setString(2,obj.getName());
        statement.setDouble(3,obj.getPrice());
        statement.setString(4,obj.getDescription());
        statement.setString(5,obj.getCountry());
        statement.setString(6,obj.getPhoto());
        statement.setDouble(7,obj.getVolume());
        statement.setString(8,obj.getTradeMark());
        statement.setInt(9,obj.getIdKind());
        statement.execute();
        statement.close();
    }

    public Article getById(int id) throws SQLException {
        String query = "SELECT * FROM articles WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        Article article = new Article();
        ResultSet set = statement.executeQuery();
        if(set.next()){
            article.setId(set.getInt("id"));
            article.setName(set.getString("name"));
            article.setCountry(set.getString("country"));
            article.setDescription(set.getString("description"));
            article.setPhoto(set.getString("photo"));
            article.setPrice(set.getDouble("price"));
            article.setTradeMark(set.getString("tradeMark"));
            article.setVolume(set.getDouble("volume"));
            article.setIdKind(set.getInt("idKind"));
        }
        set.close();
        statement.close();
        return  article;
    }

    public void update(Article obj) throws SQLException {
        String query = "UPDATE articles SET name=?, price=?, description=?, " +
                "country=?, photo=?, volume=?, tradeMark=? , idKind=?  WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,obj.getName());
        statement.setDouble(2,obj.getPrice());
        statement.setString(3,obj.getDescription());
        statement.setString(4,obj.getCountry());
        statement.setString(5,obj.getPhoto());
        statement.setDouble(6,obj.getVolume());
        statement.setString(7,obj.getTradeMark());
        statement.setInt(8,obj.getId());
        statement.setInt(9,obj.getIdKind());
        statement.execute();
        statement.close();
    }

    public void delete(Article obj) throws SQLException {
        String query = "DELETE FROM articles WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.execute();
        statement.close();
    }

    public List<Article> getAll() throws SQLException {
        String query = "SELECT * FROM articles ";
        PreparedStatement statement = connection.prepareStatement(query);
        List<Article> articles = new ArrayList<Article>() ;
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Article article = new Article();
            article.setId(set.getInt("id"));
            article.setName(set.getString("name"));
            article.setCountry(set.getString("country"));
            article.setDescription(set.getString("description"));
            article.setPhoto(set.getString("photo"));
            article.setPrice(set.getDouble("price"));
            article.setTradeMark(set.getString("tradeMark"));
            article.setVolume(set.getDouble("volume"));
            article.setIdKind(set.getInt("idKind"));
            articles.add(article);
        }
        set.close();
        statement.close();
        return  articles;
    }
}

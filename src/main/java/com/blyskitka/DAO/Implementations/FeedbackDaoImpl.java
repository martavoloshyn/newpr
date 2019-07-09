package com.blyskitka.DAO.Implementations;

import Entity.Feedback;
import com.blyskitka.DAO.Interfaces.FeedbackDao;
import com.blyskitka.JDBC.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDaoImpl implements FeedbackDao {

    private Connection connection;

    public FeedbackDaoImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public List<Feedback> getByArticle(int idArticle) throws SQLException {
        String query = "SELECT * FROM articles WHERE idArticle = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idArticle);
        List<Feedback> feedbacks = new ArrayList<Feedback>();
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Feedback feedback = new Feedback();
            feedback.setId(set.getInt("id"));
            feedback.setIdArticle(set.getInt("idArticle"));
            feedback.setIdUser(set.getInt("idUser"));
            feedback.setPublicationDate(set.getDate("publicationDate").toLocalDate());
            feedback.setStarsAmount(set.getInt("starsAmount"));
            feedbacks.add(feedback);
        }
        set.close();
        statement.close();
        return feedbacks;
    }

    @Override
    public List<Feedback> getByUser(int idUser) throws SQLException {
        String query = "SELECT * FROM articles WHERE idUser = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idUser);
        List<Feedback> feedbacks = new ArrayList<Feedback>();
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Feedback feedback = new Feedback();
            feedback.setId(set.getInt("id"));
            feedback.setIdArticle(set.getInt("idArticle"));
            feedback.setIdUser(set.getInt("idUser"));
            feedback.setPublicationDate(set.getDate("publicationDate").toLocalDate());
            feedback.setStarsAmount(set.getInt("starsAmount"));
            feedbacks.add(feedback);
        }
        set.close();
        statement.close();
        return feedbacks;
    }

    @Override
    public void insert(Feedback obj) throws SQLException {
        String query = "INSERT INTO feedbacks (id, idArticle, idUser, text, " +
                "publicationDate, starsAmount) VALUES(?,?,?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.setInt(2,obj.getIdArticle());
        statement.setInt(3,obj.getIdUser());
        statement.setString(4,obj.getText());
        statement.setDate(5, Date.valueOf(obj.getPublicationDate()));
        statement.setInt(6,obj.getStarsAmount());
        statement.execute();
        statement.close();
    }

    @Override
    public Feedback getById(int id) throws SQLException {
        String query = "SELECT * FROM articles WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        Feedback feedback = new Feedback();

        ResultSet set = statement.executeQuery();
        if (set.next()) {
            feedback.setId(set.getInt("id"));
            feedback.setIdArticle(set.getInt("idArticle"));
            feedback.setIdUser(set.getInt("idUser"));
            feedback.setPublicationDate(set.getDate("publicationDate").toLocalDate());
            feedback.setStarsAmount(set.getInt("starsAmount"));
        }
        set.close();
        statement.close();
        return feedback;
    }

    @Override
    public void update(Feedback obj) throws SQLException {
        String query ="UPDATE feedbacks SET idArticle=?, idUser=?, text=?, publicationDate=?, starsAmount=?  WHERE id=?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getIdArticle());
        statement.setInt(2,obj.getIdUser());
        statement.setString(3,obj.getText());
        statement.setDate(4, Date.valueOf(obj.getPublicationDate()));
        statement.setInt(5,obj.getStarsAmount());
        statement.setInt(6,obj.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public void delete(Feedback obj) throws SQLException {
        String query = "DELETE FROM feedbacks WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public List<Feedback> getAll() throws SQLException {
        String query = "SELECT * FROM articles;";
        PreparedStatement statement = connection.prepareStatement(query);
        List<Feedback> feedbacks = new ArrayList<Feedback>();
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Feedback feedback = new Feedback();
            feedback.setId(set.getInt("id"));
            feedback.setIdArticle(set.getInt("idArticle"));
            feedback.setIdUser(set.getInt("idUser"));
            feedback.setPublicationDate(set.getDate("publicationDate").toLocalDate());
            feedback.setStarsAmount(set.getInt("starsAmount"));
            feedbacks.add(feedback);
        }
        set.close();
        statement.close();
        return feedbacks;
    }
}

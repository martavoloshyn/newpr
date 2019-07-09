package com.blyskitka.DAO.Interfaces;
import Entity.Feedback;

import java.sql.SQLException;
import java.util.List;

public interface FeedbackDao extends Dao<Feedback> {
    List<Feedback> getByArticle(int idArticle) throws SQLException;
    List<Feedback> getByUser (int idUser) throws SQLException;

}

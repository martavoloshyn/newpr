package com.blyskitka.Service.Interfaces;

import Entity.Feedback;

import java.sql.SQLException;
import java.util.List;

public interface FeedbackService extends Service<Feedback> {
    List<Feedback> getByArticle(int idArticle) throws SQLException;
    List<Feedback> getByUser (int idUser) throws SQLException;

}

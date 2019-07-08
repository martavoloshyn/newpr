package com.blyskitka.DAO.Interfaces;
import Entity.Feedback;

import java.util.List;

public interface FeedbackDao extends Dao<Feedback> {
    List<Feedback> getByArticle(int idArticle);
    List<Feedback> getByUser (int idUser);

}

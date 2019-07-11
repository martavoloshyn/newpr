package com.blyskitka.Service.Implementations;

import Entity.Feedback;
import com.blyskitka.DAO.Implementations.FeedbackDaoImpl;
import com.blyskitka.DAO.Interfaces.FeedbackDao;
import com.blyskitka.Service.Interfaces.FeedbackService;

import java.sql.SQLException;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackDao feedbackDao;

    public FeedbackServiceImpl() {
        feedbackDao = new FeedbackDaoImpl();
    }

    @Override
    public List<Feedback> getByArticle(int idArticle) throws SQLException {
        return feedbackDao.getByArticle(idArticle);
    }

    @Override
    public List<Feedback> getByUser(int idUser) throws SQLException {
        return feedbackDao.getByUser(idUser);
    }

    @Override
    public void insert(Feedback obj) throws SQLException {
        feedbackDao.insert(obj);
    }

    @Override
    public Feedback getById(int id) throws SQLException {
        return feedbackDao.getById(id);
    }

    @Override
    public void update(Feedback obj) throws SQLException {
        feedbackDao.update(obj);
    }

    @Override
    public void delete(Feedback obj) throws SQLException {
        feedbackDao.delete(obj);
    }

    @Override
    public List<Feedback> getAll() throws SQLException {
        return feedbackDao.getAll();
    }
}

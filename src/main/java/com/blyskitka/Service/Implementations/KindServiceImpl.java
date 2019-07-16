package com.blyskitka.Service.Implementations;

import com.blyskitka.DAO.Implementations.KindDaoImpl;
import com.blyskitka.DAO.Interfaces.KindDao;
import com.blyskitka.Entity.Kind;
import com.blyskitka.Enums.Category;
import com.blyskitka.Service.Interfaces.KindService;

import java.sql.SQLException;
import java.util.List;

public class KindServiceImpl implements KindService {

    private KindDao kindDao;

    public KindServiceImpl() {
        kindDao = new KindDaoImpl();
    }

    @Override
    public List<Kind> getByCategory(Category category) throws SQLException {
        return kindDao.getKindByCategory(category);
    }

    @Override
    public void insert(Kind obj) throws SQLException {
        kindDao.insert(obj);
    }

    @Override
    public Kind getById(int id) throws SQLException {
        return kindDao.getById(id);
    }

    @Override
    public void update(Kind obj) throws SQLException {
        kindDao.update(obj);
    }

    @Override
    public void delete(Kind obj) throws SQLException {
        kindDao.delete(obj);
    }

    @Override
    public List<Kind> getAll() throws SQLException {
        return kindDao.getAll();
    }
}

package com.blyskitka.DAO.Interfaces;

import com.blyskitka.Entity.Kind;

import java.sql.SQLException;
import java.util.List;

public interface KindDao extends Dao<Kind> {
    List<Kind> getKindByCategory(Integer idCategory) throws SQLException;
}

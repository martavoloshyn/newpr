package com.blyskitka.DAO.Interfaces;

import com.blyskitka.Entity.Kind;
import com.blyskitka.Enums.Category;

import java.sql.SQLException;
import java.util.List;

public interface KindDao extends Dao<Kind> {
    List<Kind> getKindByCategory(Category category) throws SQLException;
}

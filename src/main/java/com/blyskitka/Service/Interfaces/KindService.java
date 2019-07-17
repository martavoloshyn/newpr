package com.blyskitka.Service.Interfaces;

import com.blyskitka.Entity.Kind;

import java.sql.SQLException;
import java.util.List;

public interface KindService extends Service<Kind> {
    List<Kind> getByCategory(Integer categoryId) throws SQLException;
}

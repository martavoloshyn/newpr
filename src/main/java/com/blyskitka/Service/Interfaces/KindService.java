package com.blyskitka.Service.Interfaces;

import com.blyskitka.Entity.Kind;
import com.blyskitka.Enums.Category;

import java.sql.SQLException;
import java.util.List;

public interface KindService extends Service<Kind> {
    List<Kind> getByCategory(Category category) throws SQLException;
}

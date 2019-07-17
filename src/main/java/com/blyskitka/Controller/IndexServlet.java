package com.blyskitka.Controller;

import com.blyskitka.Entity.Category;
import com.blyskitka.Entity.Kind;
import com.blyskitka.Service.Implementations.CategoryServiceImpl;
import com.blyskitka.Service.Implementations.KindServiceImpl;
import com.blyskitka.Service.Interfaces.CategoryService;
import com.blyskitka.Service.Interfaces.KindService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryService categoryService = new CategoryServiceImpl();
        try {
            List<Category> categoryList = categoryService.getAll();
            req.setAttribute("categoryList", categoryList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

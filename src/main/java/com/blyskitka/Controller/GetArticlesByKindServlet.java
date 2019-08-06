package com.blyskitka.Controller;

import com.blyskitka.Entity.Article;
import com.blyskitka.Service.Implementations.ArticleServiceImpl;
import com.blyskitka.Service.Interfaces.ArticleService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetArticlesByKindServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer kindId = Integer.parseInt(req.getParameter("idKind"));
        ArticleService articleService = new ArticleServiceImpl();
        try {
            List<Article> selectedArticles = articleService.getByKind(kindId);
            String json = new Gson().toJson(selectedArticles);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

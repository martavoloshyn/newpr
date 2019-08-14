package com.blyskitka.Controller;

import com.blyskitka.Entity.Article;
import com.blyskitka.Entity.Category;
import com.blyskitka.Entity.Kind;
import com.blyskitka.Service.Implementations.ArticleServiceImpl;
import com.blyskitka.Service.Implementations.CategoryServiceImpl;
import com.blyskitka.Service.Implementations.KindServiceImpl;
import com.blyskitka.Service.Interfaces.ArticleService;
import com.blyskitka.Service.Interfaces.CategoryService;
import com.blyskitka.Service.Interfaces.KindService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class ArticlePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArticleService articleService = new ArticleServiceImpl();
        KindService kindService = new KindServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();

        try {

            int idArticle = Integer.parseInt(req.getParameter("idArticle"));
            Article article = articleService.getById(idArticle);
            req.setAttribute("article", article);

            Kind kind = kindService.getById(article.getIdKind());
            req.setAttribute("kindName",kind.getKind());

            Category category = categoryService.getById(kind.getIdCategory());
            req.setAttribute("categoryName", category.getCategory());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("webapp/pages/articlePage.jsp").forward(req, resp);
    }
}

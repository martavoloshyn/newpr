package com.blyskitka.Controller;

import com.blyskitka.Entity.Kind;
import com.blyskitka.Service.Implementations.KindServiceImpl;
import com.blyskitka.Service.Interfaces.KindService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetKindsByCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
        KindService kindService = new KindServiceImpl();
        try {
            List<Kind> selectedKinds = kindService.getByCategory(categoryId);
            String json = new Gson().toJson(selectedKinds);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

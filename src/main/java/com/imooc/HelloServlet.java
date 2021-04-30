package com.imooc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <br>创建时间：2021/4/28
 *
 * @author 吴翔龙
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "";
        req.setAttribute("name", name);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
    }
}

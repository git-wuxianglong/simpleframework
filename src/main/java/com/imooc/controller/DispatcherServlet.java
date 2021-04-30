package com.imooc.controller;

import com.imooc.controller.frontend.MainPageController;

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
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath() == "/frontend/getmainpageinfo" && req.getMethod() == "GET") {
            new MainPageController().getMainPageInfo(req, resp);
        }
    }
}

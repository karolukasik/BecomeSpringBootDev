package io.datajek.springmvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/player.do")
public class PlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playerName = request.getParameter("name");
        request.setAttribute("name", playerName);
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        
    }

}

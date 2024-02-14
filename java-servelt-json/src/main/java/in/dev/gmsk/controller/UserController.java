package in.dev.gmsk.controller;

import com.google.gson.Gson;
import in.dev.gmsk.service.UserService;
import in.dev.gmsk.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/users.do"}, name = "UserController", description = "UserController return json.")
public class UserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();
        String userJson = gson.toJson(userService.getAllUserList());

        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        printWriter.write(userJson);
        printWriter.close();
    }
}

package com.item.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.item.model.User;
import com.item.service.UserService;
import com.item.service.impl.UserServiceImpl;

@WebServlet("/AuthController")
public class AuthController extends HttpServlet {

    @Resource(name = "jdbc/item")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        if (action == null) action = "";

        UserService userService = new UserServiceImpl(dataSource);

        switch (action) {
            case "signup":
                handleSignup(request, response, userService);
                break;
            case "login":
                handleLogin(request, response, userService);
                break;
            default:
                showLoginPage(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "loginPage";

        switch (action) {
            case "logout":
                handleLogout(request, response);
                break;
            case "loginPage":
                showLoginPage(request, response);
                break;
            case "signupPage":
                showSignupPage(request, response);
                break;
            default:
                showLoginPage(request, response);
                break;
        }
    }

    private void handleSignup(HttpServletRequest request, HttpServletResponse response, UserService userService)
            throws IOException, ServletException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(username, email, password);
        boolean registered = userService.registerUser(user);

        if (registered) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            Cookie cookie = new Cookie("username", user.getUsername());
            cookie.setMaxAge(3600);
            response.addCookie(cookie);

            response.sendRedirect(request.getContextPath() + "/ItemController");
        } else {
            request.setAttribute("error", "Signup failed");
            showSignupPage(request, response);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response, UserService userService)
            throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.loginUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            Cookie cookie = new Cookie("username", user.getUsername());
            cookie.setMaxAge(3600);
            response.addCookie(cookie);

            response.sendRedirect(request.getContextPath() + "/ItemController");
        } else {
            request.setAttribute("error", "Invalid login");
            showLoginPage(request, response);
        }
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.getSession().invalidate();
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath() + "/AuthController?action=loginPage");
    }

    private void showLoginPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    private void showSignupPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }
}

package com.item.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.item.model.Item;
import com.item.model.User;
import com.item.service.ItemService;
import com.item.service.impl.ItemServiceImpl;

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {

    @Resource(name = "jdbc/item")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ 1. Security check: Session first
        HttpSession session = request.getSession(false);
        User loggedUser = null;

        if (session != null) {
            loggedUser = (User) session.getAttribute("user");
        }

        // ✅ 2. Check cookie if session not found
        if (loggedUser == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        loggedUser = new User();
                        loggedUser.setUsername(cookie.getValue());

                        session = request.getSession(true);
                        session.setAttribute("user", loggedUser);
                        break;
                    }
                }
            }
        }

        // ✅ 3. If still no user → redirect to login
        if (loggedUser == null) {
            response.sendRedirect(request.getContextPath() + "/AuthController?action=loginPage");
            return;
        }

        // ✅ 4. Decide action
        String action = request.getParameter("action");
        if (Objects.isNull(action)) {
            action = "getItems";
        }

        switch (action) {
            case "getItems":
                getItems(request, response);
                break;
            case "getItem":
                getItem(request, response);
                break;
            case "addItem":
                addItem(request, response);
                break;
            case "editItem":
                editItem(request, response);
                break;
            case "deleteItem":
                deleteItem(request, response);
                break;
            default:
                getItems(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // We funnel all POST requests to doGet for simplicity
        doGet(request, response);
    }

    // ========== Item operations ==========

    private void getItems(HttpServletRequest request, HttpServletResponse response) {
        ItemService itemService = new ItemServiceImpl(dataSource);
        List<Item> items = itemService.loadItems();
        request.setAttribute("allItems", items);

        try {
            request.getRequestDispatcher("/showItems.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void getItem(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        ItemService itemService = new ItemServiceImpl(dataSource);
        Item item = itemService.loadItem(id);

        request.setAttribute("item", item);

        try {
            request.getRequestDispatcher("/update-item.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            Double price = Double.parseDouble(request.getParameter("price"));
            int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));

            Item item = new Item(name, price, totalNumber);
            ItemService itemService = new ItemServiceImpl(dataSource);
            itemService.addItem(item);

            response.sendRedirect(request.getContextPath() + "/ItemController?action=getItems");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editItem(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name");
            Double price = Double.parseDouble(request.getParameter("price"));
            int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));

            Item item = new Item(id, name, price, totalNumber);
            ItemService itemService = new ItemServiceImpl(dataSource);
            itemService.editItem(item);

            response.sendRedirect(request.getContextPath() + "/ItemController?action=getItems");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            ItemService itemService = new ItemServiceImpl(dataSource);
            itemService.removeItem(id);

            response.sendRedirect(request.getContextPath() + "/ItemController?action=getItems");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

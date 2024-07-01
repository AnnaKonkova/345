package servlets;

import hospital.domain.Department;
import hospital.integration.database.ConnectionManager;
import hospital.integration.database.DepartmentRepositoryImpl;
import hospital.service.DepartmentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ListD extends HttpServlet {
    ConnectionManager manager =new ConnectionManager();
    DepartmentService service = new DepartmentService(new DepartmentRepositoryImpl(manager.getConnection()));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<String> departments = service.getAllDep();
            request.setAttribute("departments",departments );
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
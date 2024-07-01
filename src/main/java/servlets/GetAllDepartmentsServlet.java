package servlets;

import hospital.integration.database.ConnectionManager;
import hospital.integration.database.DepartmentRepositoryImpl;
import hospital.service.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class GetAllDepartmentsServlet extends HttpServlet {
    ConnectionManager manager =new ConnectionManager();
    DepartmentService service = new DepartmentService(new DepartmentRepositoryImpl(manager.getConnection()));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            var departments = service.getAllDep();

            response.setStatus(HttpServletResponse.SC_OK);
            response.setCharacterEncoding("UTF-16LE");
            response.getWriter().write(departments);
            response.getWriter().flush();

//            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (IOException e) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new RuntimeException(e);
        }
    }
}
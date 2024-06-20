package servlets;

import hospital.integration.database.ConnectionManager;
import hospital.integration.database.DepartmentRepositoryImpl;
import hospital.service.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RemoveDepartment extends HttpServlet {
    ConnectionManager manager =new ConnectionManager();
    DepartmentService service = new DepartmentService(new DepartmentRepositoryImpl(manager.getConnection()));

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            service.removeDepartment(request);
            response.getWriter().println("Отделение успешно удалено.");
        }catch ( IOException e) {
            throw new RuntimeException(e);
        }

    }
}













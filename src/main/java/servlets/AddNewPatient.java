package servlets;

import hospital.integration.database.ConnectionManager;
import hospital.integration.database.DepartmentRepositoryImpl;
import hospital.service.DepartmentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddNewPatient extends HttpServlet {
    ConnectionManager manager =new ConnectionManager();
    DepartmentService service = new DepartmentService(new DepartmentRepositoryImpl(manager.getConnection()));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String patientName = request.getParameter("patientName");
        int patientAge = Integer.parseInt(request.getParameter("patientAge"));
        String patientGender = request.getParameter("patientGender");

        service.addPatients(title,patientName,patientAge,patientGender);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}













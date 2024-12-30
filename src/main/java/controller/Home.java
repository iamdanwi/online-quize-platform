package controller;

import java.io.IOException;

import com.user.dao.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
private UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAO();
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
    	String action = request.getServletPath();

       
            switch (action) {
                case "/register":
                	requestDispatcher = request.getRequestDispatcher("registration.jsp");
        			requestDispatcher.forward(request, response);
                    break;
                case "/login":
                	requestDispatcher = request.getRequestDispatcher("login.jsp");
        			requestDispatcher.forward(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

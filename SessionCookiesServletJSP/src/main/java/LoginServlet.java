

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 try{
			 con= DBConnection.connectdb();
	            String sql = "SELECT * FROM myuser WHERE username = ? AND password = ?";
	            try (PreparedStatement statement = con.prepareStatement(sql)) {
	                statement.setString(1, username);
	                statement.setString(2, password);

	                try (ResultSet resultSet = statement.executeQuery()) {
	                    if (resultSet.next()) {
	                        HttpSession session = request.getSession();
	                        session.setAttribute("username", username);

	                        Cookie userCookie = new Cookie("username", username);
	                        userCookie.setMaxAge(60 * 60); // 1 hour
	                        response.addCookie(userCookie);

	                        response.sendRedirect("welcome.jsp");
	                    } else {
	                        response.sendRedirect("index.jsp?error=Invalid credentials");
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("index.jsp?error=Server error");
	        }

	}

}

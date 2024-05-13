package API;

import DAO.DAO;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/AccountAPI")
public class AccountAPI extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    DAO dao = new DAO();
	    String jsonAccounts = dao.getAccountsAsJson();
	    resp.getWriter().write(jsonAccounts);
	}
}
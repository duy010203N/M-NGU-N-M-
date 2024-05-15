package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.DAO;
import Entity.Product;

@WebServlet("/cart")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartControl() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
		String id = request.getParameter("pid");
		if (id != null) {
			Product product = dao.getProductByID(id);
			if (product != null) {
				DAO.addCart(product);
			}
		}
		double price = dao.getprice();
		request.setAttribute("cart", DAO.productAndAmount);
		request.setAttribute("price", price);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
		int productId = Integer.parseInt(request.getParameter("productId"));
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		boolean success = dao.addProductToCart(accountId, productId, quantity);
		double price = dao.getprice();
		request.setAttribute("cart", DAO.productAndAmount);
		request.setAttribute("price", price);
		if (success) {
			response.getWriter().write("success");
		} else {
			response.getWriter().write("error");
		}
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}
}
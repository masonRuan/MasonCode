package Test.CRUD.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Test.Orders.model.OrdersService;
import Test.Orders.model.OrdersVO;
import Test.Products.model.ProductsService;
import Test.Products.model.ProductsVO;

public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		HashMap<String, String> msgOK = new HashMap<String, String>();
		HashMap<String, String> msgErr = new HashMap<String, String>();

		if ("Read_Orders".equals(action)) {
			System.out.println("Read_Orders In");
			// 讀所有訂單
			request.setAttribute("listOrdVO", read_Orders());
			String url = "/_00_Read/Read_Orders.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

		} // End:Read_Orders

		if ("Read_Products".equals(action)) {
			System.out.println("Read_Products In");
			// 讀所有商品
			request.setAttribute("listProdVO", read_Products());
			String url = "/_00_Read/Read_Products.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

		} // End:Read_Products

		if ("Create_Orders_Show".equals(action)) {
			System.out.println("Create_Orders_Show In");
			// 讀商品資訊
			request.setAttribute("listProdVO", read_Products());
			String url = "/_01_Create/CreateOrders.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

		} // End:Create_Orders

		if ("Create_Orders".equals(action)) {
			System.out.println("Create_Orders In");
			// 新增商品資訊
			Integer ord_Total = null;
			Integer ord_Count = null;
			Integer prod_ID = null;
			Timestamp ord_Time = null;
			try {
				ord_Total = Integer.parseInt(request.getParameter("ord_Total"));
				ord_Count = Integer.parseInt(request.getParameter("ord_Count"));
				prod_ID = Integer.parseInt(request.getParameter("prod_ID"));
				ord_Time = new Timestamp(System.currentTimeMillis());
			} catch (Exception e) {
				System.out.println("接值失敗");
				e.printStackTrace();
			}

			OrdersService tableServ = new OrdersService();
			tableServ.create_Orders(ord_Total, ord_Count, prod_ID, ord_Time);
			msgOK.put("CreateOK", "<Font color='red'>訂單新增成功</Font>");
			request.setAttribute("msgOK", msgOK);
			request.setAttribute("listProdVO", read_Products());
			String url = "/_01_Create/CreateOrders.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

		} // End:Create_Orders

		if ("Create_Products".equals(action)) {
			System.out.println("Create_Products In");
			// 新增商品資訊
			String prod_Name = "";
			Integer prod_Price = null;
			try {
				prod_Name = request.getParameter("prod_Name");
				prod_Price = Integer.parseInt(request
						.getParameter("prod_Price"));
			} catch (NumberFormatException e) {
				msgErr.put("prod_PriceErr", "<Font color='red'>價格應為整數</Font>");
			} catch (Exception e) {
				System.out.println("接值失敗");
				e.printStackTrace();
			}

			if (prod_Name.trim().length() == 0) {
				msgErr.put("prod_NameErr", "<Font color='red'>名稱不能為空</Font>");
			}

			if (msgErr.isEmpty()) {
				ProductsService prodServ = new ProductsService();
				prodServ.create_Products(prod_Name, prod_Price);
				msgOK.put("CreateOK", "<Font color='red'>商品新增成功</Font>");
				request.setAttribute("msgOK", msgOK);
			} else {
				request.setAttribute("msgErr", msgErr);
			}

			String url = "/_01_Create/CreateProducts.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);
		} // End:Create_Products

		if ("Update_Products_Show".equals(action)) {
			System.out.println("Update_Products_Show In");
			// 顯示商品資訊
			request.setAttribute("listProdVO", read_Products());
			String url = "/_02_Update/UpdateProducts.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);
		} // End:Update_Products_Show

		if ("Update_Products".equals(action)) {
			System.out.println("Update_Products In");
			// 顯示商品資訊
			String prod_Name = "";
			Integer prod_ID = null;
			Integer prod_Price = null;
			Integer prod_Status = 1;
			try {
				prod_ID = Integer.parseInt(request.getParameter("prod_ID"));
				prod_Name = request.getParameter("prod_Name");
				prod_Price = Integer.parseInt(request
						.getParameter("prod_Price"));
			} catch (NumberFormatException e) {
				msgErr.put("prod_PriceErr", "<Font color='red'>價格應為整數</Font>");
			} catch (Exception e) {
				System.out.println("接值失敗");
				e.printStackTrace();
			}
			if (prod_Name.trim().length() == 0) {
				msgErr.put("prod_NameErr", "<Font color='red'>名稱不能為空</Font>");
			}

			if (msgErr.isEmpty()) {
				ProductsService prodServ = new ProductsService();
				prodServ.update_Products(prod_ID, prod_Name, prod_Price, prod_Status);
				msgOK.put("CreateOK", "<Font color='red'>商品修改成功</Font>");
				request.setAttribute("msgOK", msgOK);
			} else {
				request.setAttribute("msgErr", msgErr);
			}
			request.setAttribute("listProdVO", read_Products());
			String url = "/_02_Update/UpdateProducts.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);
		} // End:Update_Products

		if ("Delete_Orders".equals(action)) {
			System.out.println("Delete_Orders In");
			// 顯示商品資訊
			Integer ord_ID = Integer.parseInt(request.getParameter("ord_ID"));

			OrdersService tableServ = new OrdersService();
			tableServ.delete_Orders(ord_ID);
			request.setAttribute("listOrdVO", read_Orders());
			String url = "/_00_Read/Read_Orders.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);
		} // End:Delete_Orders

		if ("Delete_Products".equals(action)) {
			System.out.println("Delete_Products In");
			// 顯示商品資訊
			Integer prod_ID = Integer.parseInt(request.getParameter("prod_ID"));
			String  prod_Name = request.getParameter("prod_Name");
			Integer prod_Price = Integer.parseInt(request.getParameter("prod_Price"));
			Integer prod_Status = 0; // 0代表已刪除，1代表未刪除
			ProductsService prodServ = new ProductsService();
			prodServ.delete_Products(prod_ID, prod_Name,prod_Price,prod_Status);
			request.setAttribute("listProdVO", read_Products());
			String url = "/_00_Read/Read_Products.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);
		} // End:Delete_Products

	} // End:doPost

	List<ProductsVO> read_Products() {
		// 讀所有商品
		ProductsService prodServ = new ProductsService();
		return prodServ.read_Products();
	}

	List<OrdersVO> read_Orders() {
		// 讀所有商品
		OrdersService ordServ = new OrdersService();
		return ordServ.read_Orders();
	}

}

package Test.Orders.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import jdk.nashorn.internal.objects.annotations.Constructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Test.Orders.model.OrdersController_interface;
import Test.Orders.model.OrdersService;


@Controller
public class readOrdController {
	private String viewPage;
//	 , method = RequestMethod.POST
	@RequestMapping(value = "/readOrders")
	public ModelAndView readOrders(HttpServletRequest request,
			HttpServletResponse response) throws Exception

	{
		OrdersService ordServ = new OrdersService();
		return new ModelAndView(viewPage, "listOrdVO", ordServ.read_Orders());
	}
	 public void setViewPage(String viewPage) {
	        this.viewPage = viewPage;
	    }
}

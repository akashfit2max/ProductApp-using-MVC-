package productcurdapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcurdapp.model.Product;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/add-product")
	public String aadProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	@RequestMapping(value = "handel-product", method = RequestMethod.POST)
	public RedirectView handelProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
}

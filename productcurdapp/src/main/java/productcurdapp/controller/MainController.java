package productcurdapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcurdapp.dao.ProductDao;
import productcurdapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model model) {
		List<Product> products = productDao.getProducts();
		model.addAttribute("products", products);
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
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.productDao.deleteProdcut(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("/update/{prodId}")
	public String updateForm(@PathVariable("prodId") int prodId, Model model) {
		Product product = this.productDao.getProduct(prodId);
		model.addAttribute("product", product);
		return "update_form";
	}
}

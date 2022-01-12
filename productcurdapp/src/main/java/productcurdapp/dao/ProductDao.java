package productcurdapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcurdapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

//	create
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}

//	load all products
	public List<Product> getProducts() {
		List<Product> prodcts = this.hibernateTemplate.loadAll(Product.class);
		return prodcts;
	}

//	load single product
	public Product getProduct(int pid) {
		Product product = this.hibernateTemplate.get(Product.class, pid);
		return product;
	}

//	delete a signle product
	@Transactional
	public void deleteProdcut(int pid) {
		Product product = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(product);
	}

}

package th.ac.ku.salesman.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.salesman.model.Product;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getProduct(){
        String url = "http://localhost:8092/api/product";
        ResponseEntity<Product[]> response = restTemplate.getForEntity(url, Product[].class);
        Product[] products = response.getBody();
        return Arrays.asList(products);
    }

    public Product getOneProduct(int id){
        String url = "http://localhost:8092/api/product/" + id;
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
        return response.getBody();
    }

    public void createProduct(Product product){
        String url = "http://localhost:8092/api/product";
        restTemplate.postForObject(url, product, Product.class);
    }
    public void editProduct(Product product) {
        String url = "http://localhost:8092/api/product/" +
                product.getProductId();
        restTemplate.put(url, product);
    }

    public void deleteProduct(Product product){
        String url = "http://localhost:8092/api/product/" + product.getProductId();
        restTemplate.delete(url, product);
    }
}

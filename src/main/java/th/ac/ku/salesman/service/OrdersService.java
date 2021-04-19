package th.ac.ku.salesman.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.salesman.model.Order;

import java.util.Arrays;
import java.util.List;

@Service
public class OrdersService {
    private RestTemplate restTemplate;

    public OrdersService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Order> getOrders(){
        String url = "http://localhost:8093/api/orders";
        ResponseEntity<Order[]> response = restTemplate.getForEntity(url, Order[].class);
        Order[] orders = response.getBody();
        return Arrays.asList(orders);
    }

    public Order getOneOrder(int id){
        String url = "http://localhost:8093/api/orders/" + id;
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
        return response.getBody();
    }

    public void createOrder(Order order){
        String url = "http://localhost:8093/api/orders";
        restTemplate.postForObject(url, order, Order.class);
    }

    public void deleteOrder(Order order){
        String url = "http://localhost:8093/api/orders/" + order.getProductId();
        restTemplate.delete(url, order);
    }
}

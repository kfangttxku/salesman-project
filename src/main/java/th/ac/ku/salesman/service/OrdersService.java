package th.ac.ku.salesman.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.salesman.model.Orders;

import java.util.Arrays;
import java.util.List;

@Service
public class OrdersService {
    private RestTemplate restTemplate;

    public OrdersService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Orders> getOrders(){
        String url = "http://localhost:8093/api/orders";
        ResponseEntity<Orders[]> response = restTemplate.getForEntity(url, Orders[].class);
        Orders[] orders = response.getBody();
        return Arrays.asList(orders);
    }

    public Orders getOneOrder(int orderId){
        String url = "http://localhost:8093/api/orders/" + orderId;
        ResponseEntity<Orders> response = restTemplate.getForEntity(url, Orders.class);
        return response.getBody();
    }

    public void createOrder(Orders orders){
        String url = "http://localhost:8093/api/orders";
        restTemplate.postForObject(url, orders, Orders.class);
    }

    public void deleteOrder(Orders orders){
        String url = "http://localhost:8093/api/orders/" + orders.getOrderId();
        restTemplate.delete(url, orders);
    }
}

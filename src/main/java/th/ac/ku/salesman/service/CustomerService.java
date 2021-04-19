package th.ac.ku.salesman.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.salesman.model.Customer;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    private RestTemplate restTemplate;
    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Customer> getCustomer(){
        String url = "http://localhost:8091/api/customer";
        ResponseEntity<Customer[]> response = restTemplate.getForEntity(url, Customer[].class);
        Customer[] accounts = response.getBody();
        return Arrays.asList(accounts);
    }

    public Customer getOneCustomer(int id) {
        String url = "http://localhost:8091/api/customer/" + id;
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        return response.getBody();
    }

    public void createCustomer(Customer customer){
        String url = "http://localhost:8091/api/customer";
        restTemplate.postForObject(url, customer, Customer.class);
    }

    public void deleteCustomer(Customer customer){
        String url = "http://localhost:8091/api/customer/" + customer.getCustomerId();
        restTemplate.delete(url, customer);
    }

}


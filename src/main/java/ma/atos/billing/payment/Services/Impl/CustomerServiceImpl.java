package ma.atos.billing.payment.Services.Impl;

import lombok.RequiredArgsConstructor;
import ma.atos.billing.payment.Repositories.CustomerRepository;
import ma.atos.billing.payment.Services.CustomerService;
import ma.atos.billing.payment.models.Customer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existing.setPrenom(customer.getPrenom());
        existing.setNom(customer.getNom());
        existing.setAdresse(customer.getAdresse());
        existing.setPaymentType(customer.getPaymentType());

        return customerRepository.save(existing);
    }

    @Override
    public void deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customerRepository.delete(customer);
    }
}

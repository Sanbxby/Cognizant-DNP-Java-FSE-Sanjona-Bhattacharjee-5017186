
interface CustomerRepository {
    String findCustomerById(String id);
}


class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        
        return "Customer with ID: " + id + " found.";
    }
}


class CustomerService {
    private CustomerRepository repository;

    
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomerDetails(String id) {
        return repository.findCustomerById(id);
    }
}


public class DependencyInjectionExample {
    public static void main(String[] args) {
        
        CustomerRepository repository = new CustomerRepositoryImpl();


        CustomerService service = new CustomerService(repository);

        
        String customerDetails = service.getCustomerDetails("B777");
        System.out.println(customerDetails);
    }
}

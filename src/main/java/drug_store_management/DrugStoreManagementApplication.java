package drug_store_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import drug_store_management.repository.MedicineRepository;

@SpringBootApplication

public class DrugStoreManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugStoreManagementApplication.class, args);
    }

}
package payroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
       return args -> {
            log.info("Preloading: " + repository.save(
                    new Employee("Alice", "manager")));
            log.info("Preloading: " + repository.save(
                    new Employee("Bob", "designer")));
        };
    }
}

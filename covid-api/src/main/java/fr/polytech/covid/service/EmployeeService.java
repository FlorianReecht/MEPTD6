package fr.polytech.covid.service;

import fr.polytech.covid.entity.Employee;
import fr.polytech.covid.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements UserDetailsService {
    private static Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void createUserDefault() {
        if (employeeRepository.findByUsername("user").isEmpty()) {
            log.info("Création de l'employé par defaut");
            Employee employee = new Employee();
            employee.setUsername("user");
            employee.setPassword(passwordEncoder.encode("password"));
            this.employeeRepository.save(employee);
        }
    }


    @Override
    public UserDetails loadUserByUsername(final String username)
        throws UsernameNotFoundException{
        log.info("récupération de {}", username);

        Optional<Employee> optionalEmployee = employeeRepository.findByUsername(username);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            return new User(employee.getUsername(), employee.getPassword(), List.of());
        } else {
            throw new UsernameNotFoundException("L'utilisateur" + username +"n'existe pas");
        }
    }


}

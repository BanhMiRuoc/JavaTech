package lab08_02.ex02.service;


import lab08_02.ex02.model.Employee;
import lab08_02.ex02.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        try {
            return employeeRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee getEmployee(long id) {
        try {
            return employeeRepository.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee save(Employee employee) {
        try {
            return employeeRepository.save(employee);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            employeeRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


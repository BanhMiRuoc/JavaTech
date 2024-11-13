package lab08_02.ex02.service;
import lab08_02.ex02.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(long id);
    Employee save(Employee employee);
    void removeById(Long id);
}

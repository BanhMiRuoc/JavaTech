package lab08_02.ex02.controller;

import jakarta.servlet.http.HttpServletRequest;

import lab08_02.ex02.model.Employee;
import lab08_02.ex02.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
//        System.out.println(employees.size());
        model.addAttribute("employees", employees);
        return "index";
    }
    @GetMapping(value="/employees/add")
    public String addEmployee() {
        return "add";
    }

    @PostMapping("/employees/add")
    public RedirectView add(HttpServletRequest request) {
        Employee employee = new Employee(request.getParameter("name"),
                request.getParameter("email"),
                request.getParameter("address"),
                request.getParameter("phone"));
        employeeService.save(employee);
        return new RedirectView("/employees");
    }

    @GetMapping(value="/employees/edit/{id}")
    public String editEmployee(HttpServletRequest request, Model model, @PathVariable(value="id") Long id) throws Exception {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping(value="/employees/edit/{id}")
    public RedirectView updateEmployee(HttpServletRequest request, @PathVariable(value="id") Long id) throws Exception {
        Employee employee = employeeService.getEmployee(id);
        employee.setAddress(request.getParameter("address"));
        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setPhone(request.getParameter("phone"));
        employeeService.save(employee);
        return new RedirectView("/employees");
    }

    @PostMapping(value="/employees/delete/{id}")
    public RedirectView deleteEmployee(@PathVariable(value="id") Long id) throws Exception {
        employeeService.removeById(id);
        return new RedirectView("/employees");
    }
}

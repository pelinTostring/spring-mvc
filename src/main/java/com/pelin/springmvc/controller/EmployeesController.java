package com.pelin.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pelin.springmvc.model.Employee;
import com.pelin.springmvc.service.EmployeeService;


@Controller
public class EmployeesController {

	private final EmployeeService employeeService;

	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value = "/employee")
    public ModelAndView showForm() {
        return new ModelAndView("addEmployee", "employee", new Employee());
    }
	
    @RequestMapping(value = "/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
    	employeeService.add(employee);
   	 	model.addAttribute("employee", employee);
		return "employeeView";
    }
    
    @RequestMapping(value="/getEmployeeById/{id}")
	public ModelAndView deneme(@PathVariable int id,ModelAndView model){
	    model.addObject("employee", employeeService.getById(id).get());
	    model.setViewName("employeeView");	 
	    return model;
	}
	
    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
	    public String AllEmployees(Model model) {
	        List<Employee> employees = employeeService.getAll();
	        model.addAttribute("employeeList", employees);
	        return "allEmployees"; 
	 }
    
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(employeeId);
        return new ModelAndView("redirect:/allEmployees");
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getById(employeeId).get();
        ModelAndView model = new ModelAndView("addEmployee");
        model.addObject("employee", employee);
        return model;
    }
}

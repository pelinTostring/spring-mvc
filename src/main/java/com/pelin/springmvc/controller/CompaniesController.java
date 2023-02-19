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

import com.pelin.springmvc.model.Company;
import com.pelin.springmvc.service.CompanyService;

@Controller
public class CompaniesController {

	private final CompanyService companyService;

	public CompaniesController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@RequestMapping(value = "/companies/company")
    public ModelAndView showForm() {
        return new ModelAndView("addCompany", "company", new Company());
    }
	
	@RequestMapping(value = "/companies/addCompany")
    public String submit(@ModelAttribute("company") Company company, ModelMap model) {
		companyService.add(company);
   	 	model.addAttribute("company", company);
		return "companyView";
    }
    
	@RequestMapping(value = "/companies/getCompanyById/{id}")
	public ModelAndView getCompanyById(@PathVariable int id,ModelAndView model){
	    model.addObject("company", companyService.getById(id));
	    model.setViewName("companyView");	 
	    return model;
	}
	
	@RequestMapping(value = "/companies/allCompanies", method = RequestMethod.GET)
	    public String allCompanies(Model model) {
	        List<Company> company = companyService.getAll();
	        model.addAttribute("companyList", company);
	        return "allCompanies"; 
	 }
    
	@RequestMapping(value = "/companies/deleteCompany", method = RequestMethod.GET)
    public ModelAndView deleteCompany(HttpServletRequest request) {
        int companyId = Integer.parseInt(request.getParameter("id"));
        companyService.delete(companyId);
        return new ModelAndView("redirect:/companies/allCompanies");
    }

	@RequestMapping(value = "/companies/editCompany", method = RequestMethod.GET)
    public ModelAndView editCompany(HttpServletRequest request) {
        int companyId = Integer.parseInt(request.getParameter("id"));
        Company company = companyService.getById(companyId);
        ModelAndView model = new ModelAndView("addCompany");
        model.addObject("company", company);
        return model;
    }
}

/*
 * 
 */
package com.asa.CRP.controller;

import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Customer;
import com.asa.CRP.service.CustomerService;


/**
 * The Class CustomerController.
 */
@Controller
public class CustomerController {
	
	/** The logger. */
	private Logger logger = Logger.getLogger(CustomerController.class);
	
	/** The customer service. */
	@Autowired
	private CustomerService customerService;
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();

	
		
	/**
	 * List C rs.
	 *
	 * @param customerID the customer ID
	 * @param httpSession the http session
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/customer/{customerID}", method = RequestMethod.GET)
	public String listCRs(@PathVariable int customerID, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			logger.info("I am writing here");
			Customer customer = customerService.getCustomerById(customerID);
			model.addAttribute("customer", customer);
			model.remove("NoUserFoundInREQUEST");
			return "customer";
		} else {
			return "unauthorized";
		}
	}

}

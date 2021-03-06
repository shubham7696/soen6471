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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asa.CRP.commons.CRRoles;
import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.service.CustomerRepresentativeService;

/**
 * The Class BackToMainController.
 * @author Shivani Panwar
 * @version 1.0
 */
@Controller
public class BackToMainController {

/** The logger. */
private Logger logger = Logger.getLogger(BackToMainController.class);
	
	/** The customer representative service. */
	@Autowired
	private CustomerRepresentativeService customerRepresentativeService;
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();
	
	/**
	 * To main.
	 *
	 * @param httpSession the http session
	 * @param model the model
	 * @return the model and view
	 */
	@RequestMapping(value = "/backtomain", method = RequestMethod.GET)
	public ModelAndView toMain(HttpSession httpSession, ModelMap model) {
		
		CustomerRepresentative cr = customerRepresentativeService.getCustomerRepresentativeById(Integer.valueOf(httpSession.getAttribute("crId").toString()));
		if(Utils.validateCRSession(httpSession)){
			
		if(cr.getCrRole().equals(CRRoles.CUSTOMER_REPRESENTATIVE.getDbName())) {
			return new ModelAndView("redirect:/crmain");
				}
		else if(cr.getCrRole().equals(CRRoles.TECHNICIAN.getDbName())) {	
			return new ModelAndView("redirect:/technicianmain");
	
		}else {
			return new ModelAndView("redirect:/adminmain");
			
		}
	}else {
		return new ModelAndView("redirect:/unauthorized");
		}
	}	
}

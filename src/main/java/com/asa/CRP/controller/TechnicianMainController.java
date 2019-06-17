package com.asa.CRP.controller;

import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;

@Controller
public class TechnicianMainController {
	private Logger logger = Logger.getLogger(TechnicianMainController.class);

	/**
	 * Properties file loader
	 */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/**
	 * Property	
	 */
	protected Properties property = propertiesLoader.getMiscProperties();

	@RequestMapping(value = "/technicianmain", method = RequestMethod.GET)
	public String login(HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)) {
			return "technicianmain";
		}
		else {
			return "login";
		}
	}

}

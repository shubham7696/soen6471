package com.asa.CRP.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Plan;
import com.asa.CRP.model.Ticket;
import com.asa.CRP.service.CustomerRepresentativeService;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.TicketService;


@Controller
public class TicketDetailsController {
	
	    @Autowired
     	private TicketService ticketService;
	    
	    @Autowired
	    private CustomerService customerService;
	    

	    @Autowired
	    private CustomerRepresentativeService customerRepresentativeService;
	
	    private static final Logger log = Logger.getLogger(CustomerRepresentativeController.class);	
		/**
		 * Properties file loader
		 */
		protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

		/**
		 * Property	
		 */
		
		@RequestMapping(value="/ticketdetails/{ticketId}", method=RequestMethod.GET)
		public String list(@PathVariable int ticketId, ModelMap model) {
			Ticket tkt=ticketService.getTicketById(ticketId);
			model.addAttribute("ticketId",tkt.getTicketId());
			model.addAttribute("raisedBy",customerRepresentativeService.getCustomerRepresentativeById(tkt.getRaisedBy()).getCrFirstName()+" "+customerRepresentativeService.getCustomerRepresentativeById(tkt.getRaisedBy()).getCrLastName());
			model.addAttribute("raisedFor",customerService.getCustomerById(tkt.getRaisedBy()).getCustFirstName()+" "+customerService.getCustomerById(tkt.getRaisedBy()).getCustLastName());
			model.addAttribute("issue",tkt.getIssue());
			model.addAttribute("comments",tkt.getComments());
			model.addAttribute("status",tkt.getStatus());
			return "ticketdetails";
			
		}
		
		@RequestMapping(value="/updateticketcomment/{ticketId}", method=RequestMethod.GET)
		public String editComment(@PathVariable int ticketId,@RequestParam Map<String,String> reqParam, ModelMap model) {
			Ticket tkt=ticketService.getTicketById(ticketId);
			tkt.setComments(reqParam.get("comments"));
			tkt.setStatus(reqParam.get("status"));
			ticketService.updateTicket(tkt);
			return "technicianmain";
			
		}
				
}

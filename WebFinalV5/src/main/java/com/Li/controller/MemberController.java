package com.Li.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Li.dao.BookDAO;
import com.Li.dao.EventDAO;
import com.Li.dao.InventoryDAO;
import com.Li.dao.MovieDAO;
import com.Li.dao.MusicDAO;
import com.Li.dao.UserDAO;
import com.Li.exception.BookException;
import com.Li.exception.EventException;
import com.Li.exception.InventoryException;
import com.Li.pojos.inventory.Event;
import com.Li.pojos.inventory.Inventory;
import com.Li.pojos.roles.LibraryMember;
import com.Li.pojos.roles.User;
import com.Li.validator.BookValidator;
import com.Li.validator.EventValidator;
import com.Li.validator.InventoryValidator;
import com.Li.validator.MovieValidator;
import com.Li.validator.MusicValidator;




//menu switch page
@Controller
//@RequestMapping("librarian")
public class MemberController {
	
	//menu switch
	
	@RequestMapping(value = "memberMenu.htm", method = RequestMethod.POST)
	public ModelAndView adminMenu( HttpServletRequest request, User user) throws InventoryException {

		String result = request.getParameter("isselect");
		ModelAndView mv = null;
		
		if (result.equals("Browse My Events")) {
			 User u =(User) request.getSession().getAttribute("signedUser");
			 int userID = u.getUserId();
			Configuration cfg = new Configuration();
	        SessionFactory sf = cfg.configure().buildSessionFactory();
	        Session hibernatesession = sf.openSession();
	       
	        Query query2=hibernatesession.createQuery("from LibraryMember where userId= :userId");
	        query2.setParameter("userId",userID);
	        System.out.println("userId"+userID);
	        LibraryMember member= (LibraryMember)query2.uniqueResult();
	        System.out.println("here"+member.getUserId());
	        hibernatesession.close();
	        Set<Event> events = member.getEventsRegistered();
			mv = new ModelAndView("browseEvent","events",events);
			}
		else if (result.equals("Browse My Book&Medias")){
			 User u =(User) request.getSession().getAttribute("signedUser");
			 int userID = u.getUserId();
			Configuration cfg = new Configuration();
	        SessionFactory sf = cfg.configure().buildSessionFactory();
	        Session hibernatesession = sf.openSession();
	        Query query2=hibernatesession.createQuery("from LibraryMember where userId= :userId");
	        query2.setParameter("userId",userID);
	        System.out.println("userId"+userID);
	        LibraryMember member= (LibraryMember)query2.uniqueResult();
	        System.out.println("here"+member.getUserId());
	        Set<Inventory> inventoryList = member.getBorrowedInventory();
	        System.out.println("here2"+inventoryList.isEmpty());
			mv = new ModelAndView("browseInventory","inventoryList",inventoryList);
			hibernatesession.close();
		}
		else if (result.equals("Browse All available Events")){
			try {
				
				Configuration cfg = new Configuration();
		        SessionFactory sf = cfg.configure().buildSessionFactory();
		        Session hibernatesession = sf.openSession();
		        Query query2=hibernatesession.createQuery("from Event where isExpried= :isExpried");
		        query2.setParameter("isExpried",false);
				List<Event> events = (List<Event>)query2.list();
				mv = new ModelAndView("browseEvent","events",events);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (result.equals("Browse All available Book&Medias")){

			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure().buildSessionFactory();
			Session hibernatesession = sf.openSession();
			Query query2=hibernatesession.createQuery("from Inventory where isAvailable = true");
			List<Inventory> inventoryList = (List<Inventory>)query2.list();
			System.out.println("inventoryList check"+inventoryList.get(0));
			mv = new ModelAndView("browseInventory","inventoryList",inventoryList);

		}
		

		return mv;
	}
	/*-----------------Inventory related------------------------*/

	


}


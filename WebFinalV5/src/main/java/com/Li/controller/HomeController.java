package com.Li.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Li.pojos.roles.LibraryMember;
import com.Li.pojos.roles.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//Main Page
	@RequestMapping(value ={"/","/index"}, method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
	        return "home";
	       }
	
	
	@RequestMapping(value = "/goHome", method = RequestMethod.POST)
	public String home(HttpServletRequest request) {
	
		  return "home";
    }
	
	//switch to menu page according to user-role
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView loginToMenu(HttpServletRequest request){
		ModelAndView mv = null;
		String userName = request.getParameter("j_username");
		String userPassword = request.getParameter("j_password");
		Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().buildSessionFactory();
        Session hibernatesession = sf.openSession();
        
        
        //HttpSession session = request.getSession(true);
        System.out.println("In Check login");
      
        //String SQL_QUERY =" from User as o where o.userName=? and o.userPassword=?";
        String SQL_QUERY = " FROM User WHERE userName= :userName AND userPassword= :userPassword";
		Query query = hibernatesession.createQuery(SQL_QUERY);
		query.setParameter("userName",userName);
		query.setParameter("userPassword",userPassword);
		User result = (User)query.uniqueResult();
		HttpSession sessionH = request.getSession();
		User signedUser = new User();
		
		
		
		if (result == null) {
			hibernatesession.close();
			mv = new ModelAndView("login-error");
			return mv;
		}
		else if(result != null){
			if(result.getUserRole().equals("Admin")){
				hibernatesession.close();
				signedUser = result;
				sessionH.setAttribute("signedUser", result);
				return mv = new ModelAndView("admin/adminMenu","user",result);
			}
			else if(result.getUserRole().equals("Librarian")){
				hibernatesession.close();
				signedUser = result;
				return mv = new ModelAndView("librarian/librarianMenu", "user",result);
			}
			else if(result.getUserRole().equals("LibraryMember") ){
				
				int userId = result.getUserId();
				 SQL_QUERY = " FROM LibraryMember WHERE userId= :userId";
				 query = hibernatesession.createQuery(SQL_QUERY);
				query.setParameter("userId",userId);
				LibraryMember member =  (LibraryMember)query.uniqueResult();
				hibernatesession.close();
				signedUser = result;
				sessionH.setAttribute("signedUser", result);
				return mv = new ModelAndView("member/memberMenu","user",result);
			}
			
			
		}
		
		return mv;

		
	}
	
	

	   	
	/*public ModelAndView home(HttpServletRequest request, BindingResult result, Map model) {
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().buildSessionFactory();
        Session hibernatesession = sf.openSession();
        HttpSession session = request.getSession(true);
        	ModelAndView mv = null;
    		if (result.hasErrors()) {
    			mv = new ModelAndView("loginform");
    			return mv;
    		}
    		
    		String userName = request.getParameter("j_username");
    		String userPassword = request.getParameter("j_password");
    		
    		boolean userExists = loginService.checkLogin(userName,userPassword);
    		if(userExists){
    			User findUser = loginService.getUser(userExists, userName, userPassword);
    			if(findUser.getUserRole()== "admin"){
    				
    				return mv = new ModelAndView("adminMenu","user",findUser);
    			}
    			else if(findUser.getUserRole() == "Librarian"){
    				return mv = new ModelAndView("librarianMenu");
    			}
    			else if(findUser.getUserRole() == "LibraryMember"){
    				return mv = new ModelAndView("memberMenu");
    			}
    			
    			
    		}else{
    			result.rejectValue("userName","invaliduser");
    			mv = new ModelAndView("login-error");
    			return mv;
    		}
    		return mv;
    
  	}*/
        
        
   
}

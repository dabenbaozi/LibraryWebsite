package com.Li.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Li.pojos.roles.Admin;
import com.Li.pojos.roles.Librarian;
import com.Li.pojos.roles.LibraryMember;
import com.Li.pojos.roles.UEmail;
import com.Li.pojos.roles.User;

//all Admin-Related Controllers
@Controller
@RequestMapping("admin/")
public class AdminController {

	/*-----------------Page Switch starts------------------------*/
	/*@Autowired
	@Qualifier("userDao")
	
	UserDAO userDao;

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	ServletContext servletContext;*/

	@RequestMapping(value = "/adminMenu", method = RequestMethod.POST)
	public ModelAndView adminMenu( HttpServletRequest request) {
		String result = request.getParameter("isselect");
		String destination= null;
		ModelAndView mv = null;
		if (result.equals("BrowseUser")) {
			destination= "admin/browseUser";
			Configuration cfg = new Configuration();
	        SessionFactory sf = cfg.configure().buildSessionFactory();
	        Session hibernatesession = sf.openSession();
	        //HttpSession session = request.getSession(true);
	        System.out.println("In User Browse");
	        //String SQL_QUERY =" from User as o where o.userName=? and o.userPassword=?";
	        String SQL_QUERY = " FROM User";
			Query query = hibernatesession.createQuery(SQL_QUERY);
			@SuppressWarnings("unchecked")
			List<User> userList = query.list();
			hibernatesession.close();
			mv = new ModelAndView(destination,"userList",userList);
			}
		else if (result.equals("AddAUser")){
			destination= "admin/addUser";
			mv = new ModelAndView(destination);
			}
		else if (result.equals("DeleteUser")){
			destination= "admin/deleteUser";
			mv = new ModelAndView(destination);
			}
		return mv;
	}

/*
	@RequestMapping(value = "/admin/adminMenu.htm", method = RequestMethod.GET)
	public String backAdminMenu(HttpServletRequest request) {
	
		  return "admin/adminMenu";
    }*/
	
	@RequestMapping(value = "/admin/adminMenu.htm", method = RequestMethod.GET)
	public String ajaxSearch(HttpServletRequest request) {
	
		  return "test";
    }
	

	@RequestMapping(value = "/admin/addUser.htm", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request) {
		Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().buildSessionFactory();
        Session hibernatesession = sf.openSession();
        //HttpSession session = request.getSession(true);
        System.out.println("In User Browse");
        //String SQL_QUERY =" from User as o where o.userName=? and o.userPassword=?";
        
        UEmail newEmail = new UEmail();
        String role = request.getParameter("roleSelected");
        String  userPassword= request.getParameter("userPassword");
        String userName = request.getParameter("userName");
       /* if(role.equals("Admin") ){
        	
        }*/
        if(role.equals("Librarian") ){
        	Librarian newUser = new Librarian(userName,userPassword,role);
        	newEmail.setEmailAddress(request.getParameter("email"));
            newUser.setEmail(newEmail);
            newUser.setFirstName(request.getParameter("firstName"));
            newUser.setLastName(request.getParameter("lastName"));
            newUser.setUserPassword(request.getParameter("userPassword"));
            newUser.setUserName(request.getParameter("userName"));
            newUser.setUserRole(request.getParameter("roleSelected"));
            hibernatesession.save(newUser);
            hibernatesession.save(newEmail);	
        	
        }
        else if(role.equals("LibraryMember") ) {
        	LibraryMember newUser = new LibraryMember(userName,userPassword,role);
        	newEmail.setEmailAddress(request.getParameter("email"));
            newUser.setEmail(newEmail);
            newUser.setFirstName(request.getParameter("firstName"));
            newUser.setLastName(request.getParameter("lastName"));
            newUser.setUserPassword(request.getParameter("userPassword"));
            newUser.setUserName(request.getParameter("userName"));
            newUser.setUserRole(request.getParameter("roleSelected"));
            hibernatesession.save(newUser);
            hibernatesession.save(newEmail);

        }
        
        
      /*  newEmail.setEmailAddress(request.getParameter("email"));
        newUser.setEmail(newEmail);
        newUser.setFirstName(request.getParameter("firstName"));
        newUser.setLastName(request.getParameter("lastName"));
        newUser.setUserPassword(request.getParameter("userPassword"));
        newUser.setUserName(request.getParameter("userName"));
        newUser.setUserRole(request.getParameter("roleSelected"));
        hibernatesession.save(newUser);
        hibernatesession.save(newEmail);*/
		hibernatesession.close();
		
			return "admin/addSuccessfully";
	}

	


/*	@RequestMapping(value = "/search.htm", method = RequestMethod.POST)
	public ModelAndView seacrhUser(HttpServletRequest request) {
		String key = request.getParameter("inputtext");
		String searchKey = request.getParameter("searchkey");
		List<User> userList = null;
		try {
			userList = userDao.get(key, searchKey);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("search-result", "userList", userList);
	}*/

	@RequestMapping(value ="deleteUser.htm",method = RequestMethod.POST)
	public ModelAndView deleteInventory(HttpServletRequest request){
		ModelAndView mv =null;
		int inventoryID = Integer.valueOf(request.getParameter("userID"));
		String warning = "NO such Item with this ID";
		Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().buildSessionFactory();
        Session hibernatesession = sf.openSession();
       // User targetUser = new User();
       /* targetUser.setEmail(email);
        targetUser.setFirstName(firstName);
        targetUser.setLastName(lastName);*/
       /* targetUser.setUserId(inventoryID);
        
        hibernatesession.delete(targetUser);
        hibernatesession.flush();
        hibernatesession.close();*/
        
        Query q = hibernatesession.createQuery("delete User where id = :inventoryID");
        
        q.setParameter("inventoryID", inventoryID);
        q.executeUpdate();
		
		if(request.getParameter("userID").isEmpty()){
			mv = new ModelAndView("deleteUser", "warning",warning);
		}
		else{
			mv = new ModelAndView("admin/adminMenu", "warning",warning);
			
		}
			
		
		return mv;
	}

}

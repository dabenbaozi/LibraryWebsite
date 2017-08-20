package com.Li.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Li.dao.EventDAO;
import com.Li.exception.EventException;
import com.Li.pojos.inventory.Event;
import com.Li.validator.EventValidator;


@Controller

public class EventController {


	@Autowired
	@Qualifier("eventDao")
	EventDAO eventDao;

	@Autowired
	@Qualifier("eventValidator")
	EventValidator eventvalidator;

	@InitBinder
	private void initeventBinder(WebDataBinder eventbinder) {
		eventbinder.setValidator(eventvalidator);
	}
	
	@Autowired
	ServletContext servletContext;
////////////////////////////////////add event///////////////////////////////////////////
@RequestMapping(value = "librarian/addEvent.htm", method = RequestMethod.GET)
public String createModel(ModelMap model){
	
	Event event = new Event();
	System.out.println("iiiiiin get method"+event.getEventID());
	model.addAttribute("event",event);
return ("addEvent");
}

@RequestMapping(value = "librarian/addEvent.htm", method = RequestMethod.POST)
public ModelAndView handleUpload(@ModelAttribute("event") Event event,HttpServletRequest request) {
System.out.println("in add event controller");
//event = new Event();
System.out.println("iiiiiin get method"+event.getDescription());
ModelAndView mv;
//eventvalidator.validate(event, result);
try {
	event.setDescription(request.getParameter("description"));

if (event.getFilename().trim() != "" || event.getFilename() != null) {
File directory;
String check = File.separator; // Checking if system is linux
			// based or windows based by
			// checking seprator used.
String path = null;
if (check.equalsIgnoreCase("\\")) {
path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as Lab9/build/web/
											  // so we need to replace build in the path
													}

if (check.equalsIgnoreCase("/")) {
path = servletContext.getRealPath("").replace("build/", "");
path += "/"; // Adding trailing slash for Mac systems.
}
directory = new File(path + "\\" + event.getFilename());
boolean temp = directory.exists();
if (!temp) {
temp = directory.mkdir();
}
if (temp) {
// We need to transfer to a file
CommonsMultipartFile photoInMemory = event.getPoster();

String fileName = photoInMemory.getOriginalFilename();
// could generate file names as well

File localFile = new File(directory.getPath(), fileName);

// move the file from memory to the file

photoInMemory.transferTo(localFile);
event.setDescription(localFile.getPath());
System.out.println("File is stored at" + localFile.getPath());
System.out.print("registerNewUser");
Event u = eventDao.create(event);

} else {
System.out.println("Failed to create directory!");
}
}

} catch (IllegalStateException e) {
System.out.println("*** IllegalStateException: " + e.getMessage());
} catch (IOException e) {
// TODO Auto-generated catch block
System.out.println("*** IOException: " + e.getMessage());
} catch (EventException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

return  mv = new ModelAndView("addSuccessfully");
}



}

package com.Li.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Li.dao.BookDAO;
import com.Li.dao.EventDAO;
import com.Li.exception.BookException;
import com.Li.exception.EventException;
import com.Li.exception.MusicException;
import com.Li.pojos.inventory.Book;
import com.Li.pojos.inventory.Event;


@Component
public class EventValidator implements Validator {

	@Autowired
	@Qualifier("eventDao")
	EventDAO eventDao;
	
	public boolean supports(Class aClass) {
		return Event.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		Event newEvent = (Event) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.event", "description Required");
	//	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "error.invalid.event", "startDate Required");
	//	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "error.invalid.event", "endDate Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.event", "location Required");
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
        
	
		try {
			
			Event c = eventDao.get(newEvent.getDescription());
			if(c !=null)
				errors.rejectValue("title", "error.invalid.event", "Event already Exists");
			
		} catch (EventException e) {
			System.err.println("Exception in Event Validator");
		}
		
		
		
	
	}
}

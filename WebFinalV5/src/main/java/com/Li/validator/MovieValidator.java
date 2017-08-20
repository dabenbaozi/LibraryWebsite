package com.Li.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.Li.dao.MovieDAO;
import com.Li.exception.EventException;
import com.Li.exception.MovieException;
import com.Li.pojos.inventory.Movie;


@Component
public class MovieValidator implements Validator {

	@Autowired
	@Qualifier("movieDao")
	MovieDAO movieDao;
	
	public boolean supports(Class aClass) {
		return Movie.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		Movie newMovie = (Movie) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.movie", "title Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "error.invalid.movie", "actor Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "error.invalid.movie", "actress Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "error.invalid.movie", "genre Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "error.invalid.movie", "year Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.movie", "description Required");
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
        
	
		try {
			Movie c = movieDao.get(newMovie.getTitle());
			if(c !=null)
				errors.rejectValue("title", "error.invalid.book", "Movie already Exists");
			
		} catch (MovieException e) {
			System.err.println("Exception in Movie Validator");
		}
		
		
		
	
	}
}

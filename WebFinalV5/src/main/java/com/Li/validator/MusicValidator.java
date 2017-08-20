package com.Li.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Li.dao.BookDAO;
import com.Li.dao.MusicDAO;
import com.Li.exception.BookException;
import com.Li.exception.MusicException;
import com.Li.pojos.inventory.Book;
import com.Li.pojos.inventory.Music;


@Component
public class MusicValidator implements Validator {

	@Autowired
	@Qualifier("musicDao")
	MusicDAO musicDao;
	
	public boolean supports(Class aClass) {
		return Music.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		Music newMusic = (Music) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.music", "title Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "error.invalid.music", "author Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "error.invalid.music", "genre Required");
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
        
	
		try {
			Music c = musicDao.get(newMusic.getTitle());
			if(c !=null)
				errors.rejectValue("title", "error.invalid.music", "Music already Exists");
			
		} catch (MusicException e) {
			System.err.println("Exception in Music Validator");
		}
		
		
		
	
	}
}

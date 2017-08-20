package com.Li.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Li.dao.BookDAO;
import com.Li.exception.BookException;
import com.Li.exception.MusicException;
import com.Li.pojos.inventory.Book;


@Component
public class BookValidator implements Validator {

	@Autowired
	@Qualifier("bookDao")
	BookDAO bookDao;
	
	public boolean supports(Class aClass) {
		return Book.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		Book newBook = (Book) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.book", "Book title Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "error.invalid.book", "Book isbn Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "error.invalid.book", "Book author Required");
		
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
        
	
		try {
			Book c = bookDao.get(newBook.getTitle());
			if(c !=null)
				errors.rejectValue("title", "error.invalid.book", "Book already Exists");
			
		} catch (BookException e) {
			System.err.println("Exception in Book Validator");
		}
		
		
		
	
	}
}

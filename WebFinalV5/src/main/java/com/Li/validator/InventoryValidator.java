package com.Li.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Li.dao.BookDAO;
import com.Li.dao.InventoryDAO;
import com.Li.exception.BookException;
import com.Li.exception.InventoryException;
import com.Li.exception.MusicException;
import com.Li.pojos.inventory.Book;
import com.Li.pojos.inventory.Inventory;


@Component
public class InventoryValidator implements Validator {

	@Autowired
	@Qualifier("inventoryDao")
	InventoryDAO inventoryDao;
	
	public boolean supports(Class aClass) {
		return Inventory.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		Inventory newInventory = (Inventory) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inventoryID", "error.invalid.inventory", "Inventory ID Required");
		
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
        
	
		try {
			Inventory c = inventoryDao.get(newInventory.getInventoryID());
			if(c !=null)
				errors.rejectValue("InventoryID", "error.invalid.inventory", "Inventiory already Exists");
			
		} catch (InventoryException e) {
			System.err.println("Exception in Inventory Validator");
		}
		
		
		
	
	}
}

package com.Li.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.Li.exception.BookException;
import com.Li.exception.UserException;
import com.Li.pojos.inventory.Book;
import com.Li.pojos.inventory.Event;
import com.Li.pojos.roles.User;



public class UserDAO extends DAO {
	
	public UserDAO() {
	}
	
	 public List<Event> listUserEvents(User u) throws UserException {
	        try {
	            begin();
	            Session session = getSession();
	            Criteria crit = session.createCriteria(Event.class);
	            crit.add(Restrictions.eq("userName", u.getUserName()));
	            List<Event> events = crit.list();
	            
	            commit();
	            return events;
	        } catch (HibernateException e) {
	            rollback();
	            throw new UserException("Could not list the user's event", e);
	        }
	    }
	
	/*
	public Book addBook(Book u)
			throws BookException {
		try {
			begin();
			System.out.println("inside DAO");			
			getSession().save(u);
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new BookException("Exception while creating book: " + e.getMessage());
		}
	}
    public Book searchByTitle(String title) throws BookException {
        try {
            begin();
            Query q=getSession().createQuery("from Book where title= :title");
            q.setString("title",title);
            Book book=(Book)q.uniqueResult();
            commit();
            return book;
        } catch (HibernateException e) {
            rollback();
            throw new BookException("Could not obtain the named book " + title + " " + e.getMessage());
        }
    }

    public List<Book> list() throws BookException {
        try {
            begin();
            Query q = getSession().createQuery("from Book");
            List<Book> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new BookException("Could not list the book", e);
        }
    }
    
    public List<Book> listAvailable() throws BookException {
        try {
            begin();
            Session session = getSession();
            Filter filter  = session.enableFilter("availableFilter");
            filter.setParameter("isAvailable", true);
            Query q = session.createQuery("from Book");
            List<Book> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new BookException("Could not list the book", e);
        }
    }


    public void update(Book book) throws BookException {
        try {
            begin();
            getSession().update(book);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new BookException("Could not save the book", e);
        }
    }

    public void delete(Book book) throws BookException {
        try {
            begin();
            getSession().delete(book);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new BookException("Could not delete the book", e);
        }
    }
    
    
    public Book get(String title) throws BookException {
        try {
            begin();
            Query q=getSession().createQuery("from Book where title= :title");
            q.setString("title",title);
            Book category=(Book)q.uniqueResult();
            commit();
            return category;
        } catch (HibernateException e) {
            rollback();
            throw new BookException("Could not obtain the named Book " + title + " " + e.getMessage());
        }
    }
    
    */
    
}
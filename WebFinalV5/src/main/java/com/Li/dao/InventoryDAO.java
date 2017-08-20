package com.Li.dao;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.Li.exception.BookException;
import com.Li.exception.EventException;
import com.Li.exception.InventoryException;
import com.Li.pojos.inventory.Book;
import com.Li.pojos.inventory.Event;
import com.Li.pojos.inventory.Inventory;



public class InventoryDAO extends DAO {
	
	public InventoryDAO() {
	}
	
	
	/*public Book addBook(Book u)
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
	}*/
    public Inventory get(int inventoryID) throws InventoryException {
       try{
            begin();
            Query q=getSession().createQuery("from Inventory where inventoryID= :inventoryID");
            q.setInteger("inventoryID",inventoryID);
            Inventory inventory=(Inventory)q.uniqueResult();
            commit();
            return inventory;
        } catch (HibernateException e) {
            rollback();
				throw new InventoryException("Could not find inventory with ID:"+ inventoryID );
        }
       
    }
    
    public void delete(Inventory inventory) throws InventoryException {
        try {
            begin();
            getSession().delete(inventory);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new InventoryException("Could not delete the inventory", e);
        }
    }

    public List<Inventory> list() throws InventoryException {
        try {
            begin();
            Query q = getSession().createQuery("from Inventory");
            List<Inventory> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new InventoryException("Could not list the Inventory", e);
        }
    }
    
  public List<Inventory> listAvailable() throws BookException {
        try {
            begin();
            Session session = getSession();
            Filter filter  = session.enableFilter("availableFilter");
            filter.setParameter("isAvailable", true);
            Query q = session.createQuery("from Inventory");
            List<Inventory> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new BookException("Could not list inventory", e);
        }
    }
  
  public void update(Inventory inventory) throws InventoryException {
	
      try {
          begin();
          //getSession().update(inventory);
          getSession().saveOrUpdate(inventory);
          commit();
      } catch (HibernateException e) {
          rollback();
          throw new InventoryException("Could not update the inventory", e);
      }
  }

/*
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
    }*/
    
    
    
}
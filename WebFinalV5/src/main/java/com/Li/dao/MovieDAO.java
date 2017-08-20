package com.Li.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.Li.exception.MovieException;
import com.Li.pojos.inventory.Movie;


public class MovieDAO extends DAO {

    public Movie create(Movie movie)
            throws MovieException {
        try {
            begin();            
            getSession().save(movie);     
            commit();
            return movie;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create movie", e);
            throw new MovieException("Exception while creating movie: " + e.getMessage());
        }
    }

    public void delete(Movie movie)
            throws MovieException {
        try {
            begin();
            getSession().delete(movie);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new MovieException("Could not delete movie", e);
        }
    }
    
    public List<Movie> list() throws MovieException{
    	
    	try {
            begin();
            Query q = getSession().createQuery("from Movie");
            List<Movie> movies = q.list();
            commit();
            return movies;
        } catch (HibernateException e) {
            rollback();
            throw new MovieException("Could not delete movie", e);
        }
    	
    }

	public Movie get(String title) throws MovieException {
		try {
            begin();
            Query q=getSession().createQuery("from Movie where title= :title");
            q.setString("title",title);
            Movie movie=(Movie)q.uniqueResult();
            commit();
            return movie;
        } catch (HibernateException e) {
            rollback();
            throw new MovieException("Could not obtain the named movie " + title + " " + e.getMessage());
        }
	}
}
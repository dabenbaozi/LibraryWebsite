package com.Li.dao;


import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.Li.exception.EventException;
import com.Li.pojos.inventory.Event;



public class EventDAO extends DAO {

    public Event get(String description) throws EventException {
        try {
            begin();
            Query q=getSession().createQuery("from Event where description= :description");
            q.setString("description",description);
            Event event=(Event)q.uniqueResult();
            commit();
            return event;
        } catch (HibernateException e) {
            rollback();
            throw new EventException("Could not obtain the named event " + description + " " + e.getMessage());
        }
    }
    
    public Event getEvent(int eventID) throws EventException {
        try {
            begin();
            Query q=getSession().createQuery("from Event where eventID= :eventID");
            q.setInteger("eventID",eventID);
            Event event=(Event)q.uniqueResult();
            commit();
            return event;
        } catch (HibernateException e) {
            rollback();
            throw new EventException("Could not obtain the named event " + eventID + " " + e.getMessage());
        }
    }

    public List<Event> list() throws EventException {
        try {
            begin();
            Query q = getSession().createQuery("from Event");
            List<Event> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new EventException("Could not list the event", e);
        }
    }

    public Event create(Event ev) throws EventException {
        try {
            begin();
            
            /*Event event = new Event();
            event.setDescription(ev.getDescription());
            
            event.setLocation(ev.getLocation());*/
            /*event.setStartDate(ev.getStartDate());
            event.setEndDate(ev.getEndDate());*/
            getSession().save(ev);
            commit();
            return ev;
        } catch (HibernateException e) {
            rollback();
            throw new EventException("Could not create the event", e);
           // throw new EventException("Exception while creating event: " + e.getMessage());
        }
    }

    public void update(Event event) throws EventException {
        try {
            begin();
            getSession().update(event);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EventException("Could not save the event", e);
        }
    }

    public void delete(Event event) throws EventException {
        try {
            begin();
            getSession().delete(event);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EventException("Could not delete the event", e);
        }
    }
    
    
    public List<Event> listAvailable() throws EventException {
        try {
            begin();
            Session session = getSession();
            Filter filter  = session.enableFilter("notExpriedFilter");
            filter.setParameter("isExpried", false);
            Query q = session.createQuery("from Event");
            List<Event> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new EventException("Could not list event");
        }
    }
    
    

    
}
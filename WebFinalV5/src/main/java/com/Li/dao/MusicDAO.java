package com.Li.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.Li.exception.MusicException;
import com.Li.pojos.inventory.Music;

public class MusicDAO extends DAO {

    public Music create(Music music)
            throws MusicException {
        try {
            begin();            
            getSession().save(music);     
            commit();
            return music;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new MusicException("Exception while creating music: " + e.getMessage());
        }
    }

    public void delete(Music music)
            throws MusicException {
        try {
            begin();
            getSession().delete(music);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new MusicException("Could not delete music", e);
        }
    }
    
    public List<Music> list() throws MusicException{
    	
    	try {
            begin();
            Query q = getSession().createQuery("from Music");
            List<Music> musics = q.list();
            commit();
            return musics;
        } catch (HibernateException e) {
            rollback();
            throw new MusicException("Could not delete music", e);
        }
    	
    }

	public Music get(String title) throws MusicException {
		try {
            begin();
            Query q=getSession().createQuery("from Music where title= :title");
            q.setString("title",title);
            Music music=(Music)q.uniqueResult();
            commit();
            return music;
        } catch (HibernateException e) {
            rollback();
            throw new MusicException("Could not obtain the named movie " + title + " " + e.getMessage());
        }
	}
}
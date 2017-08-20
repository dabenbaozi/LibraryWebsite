package com.Li.pojos.inventory;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="movie_table")
@PrimaryKeyJoinColumn(name = "inventoryID")
public class Movie  extends Inventory{
	
	@Column(name = "movieId")
	int movieId;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "actor")
    String actor;
	
	@Column(name = "actress")
    String actress;
	
	@Column(name = "genre")
    String genre;
	
	@Column(name = "year")
    Integer year;
	
	@Column(name = "description")
    String description;
	
   
    
    
	public Movie(){
		
		
	}
	
	
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }
    
  

    public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


}

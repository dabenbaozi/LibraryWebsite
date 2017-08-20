package com.Li.pojos.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="music_table")
@PrimaryKeyJoinColumn(name = "inventoryID")
public class Music  extends Inventory{
	
	@Column(name = "musicID")
	private int musicID;

	
	@Column(name = "title")
	private String	title;
	
	@Column(name = "author")
	private String	author;
	
	@Column(name = "genre")
	private String	genre;
	
	public Music(){
		
		
	}
	
	public int getMusicID() {
		return musicID;
	}
	public void setMusicID(int musicID) {
		this.musicID = musicID;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}

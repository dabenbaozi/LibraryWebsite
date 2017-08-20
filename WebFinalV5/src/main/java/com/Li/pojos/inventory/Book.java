package com.Li.pojos.inventory;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="book_table")
@PrimaryKeyJoinColumn(name = "inventoryID")
public class Book extends Inventory{
	
		@Column(name = "bookId")
		private int bookId;
		
		@Column(name = "isbn")
	 	private String isbn;
		
		@Column(name = "title")
	    private String title;
		
		@Column(name = "author")
	    private String author;
		
	
	    
	    public Book(){}

	    public int getbookId() {
	        return bookId;
	    }
	    
	 
	    public String getIsbn() {
	        return isbn;
	    }

	    public void setIsbn(String isbn) {
	        this.isbn = isbn;
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


		public void setbookId(int id) {
			this.bookId = id;
		}

	
}

package com.padmini.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="bookInfo")

public class BookInfo {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)	
    @Column(name = "book_id")	
	private int book_id;
	
	@Column(name = "book_name")
	private String book_name;
	
	//@Column(name = "author")
	private String author;
	
	//@Column(name = "price")
	private int price;
	private String status;
	private String comment;
	
	/*@ManyToOne
	@JoinColumn(name= "uname")*/
	@Column(name = "name")
	private String username;

	public BookInfo() {
		super();
	}

	public BookInfo(String book_name, String author, int price, String status) {
		super();
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.status = status;
	}

	
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String user) {
		this.username = user;
	}

    
	
	
}

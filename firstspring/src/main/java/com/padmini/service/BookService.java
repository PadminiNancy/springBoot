package com.padmini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padmini.dao.BookDao;
import com.padmini.model.BookInfo;
import com.padmini.model.UserInfo;

@Service
public class BookService {
	
	@Autowired
	BookDao bookDao;
	
	public List allBooks(String name)
	{
		System.out.println("In Service ");
		return bookDao.getAllBooks(name);		
	}
	
	public BookInfo addBook(BookInfo book) 
	{
		System.out.println("In Service ");
		return bookDao.addBook(book);		
	}
	
	public BookInfo updateBook(BookInfo book) 
	{
		System.out.println("In Service ");
		return bookDao.updateBook(book);		
	}
	
	public Boolean deleteBook(int book_id) 
	{
		System.out.println("In Service ");
		return bookDao.deleteBook(book_id);		
	}
	
}

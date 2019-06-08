package com.example.firstspring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import com.padmini.dao.BookDao;
import com.padmini.model.BookInfo;
import com.padmini.service.BookService;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class FirstspringApplicationTests {

	@InjectMocks
	BookService bookService;
	
	@Mock
	BookDao bookDao;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public void testGetBooks() {
		
		List<BookInfo> bl = new ArrayList<BookInfo>();
		
		BookInfo b1 = new BookInfo("Padmini","Android Test1","Android Author1",101,"Own");
		BookInfo b2 = new BookInfo("Padmini","Android Test2","Android Author2",102,"Own");
		BookInfo b3 = new BookInfo("Padmini","Android Test3","Android Author3",103,"Own");
		BookInfo b4 = new BookInfo("Padmini","Android Test4","Android Author4",104,"Own");
		
		bl.add(b1);
		bl.add(b2);
		bl.add(b3);
		bl.add(b4);
		
		when (bookDao.getAllBooks("Padmini")).thenReturn(bl);
		
		List<BookInfo> bookList = bookService.allBooks("Padmini");
	     assertEquals(4,bookList.size());
	}
	
}

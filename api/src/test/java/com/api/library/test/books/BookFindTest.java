package com.api.library.test.books;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.library.models.Book;
import com.api.library.resources.BookRepository;
import com.api.library.test.configurations.RetrieveUtil;



@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class BookFindTest {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookRepository bookRepository;

	Book book = new Book();

	@Before
	public void createBook() {

		this.book.setTitle("Test Book Title");
		this.book.setDescription("This is a test description. This is a test description. This is a test description.");
		this.book.setIsbn("123456789");

		this.book = this.bookRepository.save(this.book);
		LOGGER.info("Book created with id " + this.book.getId());
	}

	@Test
	public void test() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:9000/books/" + this.book.getId());
		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		Book resource = RetrieveUtil.retrieveResourceFromResponse(response, Book.class);
		assertThat(this.book.getTitle(), Matchers.is(resource.getTitle()));
	}

	@After
	public void after() {
		this.bookRepository.delete(this.book);
		LOGGER.info("Book deleted");
	}

}

// ********RoostGPT********
/*
Test generated by RoostGPT for test java-customannotation-test using AI Type Azure Open AI and AI Model roostgpt-4-32k
ROOST_METHOD_HASH=getNewBooksWithAppliedDiscount_3b7d0e9aa8
ROOST_METHOD_SIG_HASH=getNewBooksWithAppliedDiscount_c27afe90dc
"""
Scenario 1: Test when discountRate is 0
Details:
  TestName: testWhenDiscountRateIsZero
  Description: This test checks if the method works correctly when the discountRate is 0, the prices of the books should remain the same.
Execution:
  Arrange: Mock the bookRepository.findNewBooks method to return a list of Books. Set the prices of these Books.
  Act: Call the getNewBooksWithAppliedDiscount method with discountRate = 0 and days = any valid value.
  Assert: Check if the returned Book list has the same prices.
Validation:
  The price of all books should remain the same when the discount rate is 0. This test validates that no discount is applied when the discountRate is 0.
Scenario 2: Test when discountRate is 100
Details:
  TestName: testWhenDiscountRateIsHundred
  Description: This test checks if the method works correctly when the discountRate is 100, the prices of all the Books should be 0.
Execution:
  Arrange: Mock bookRepository.findNewBooks method to return a list of Books. Set the prices of these Books.
  Act: Call the getNewBooksWithAppliedDiscount method with discountRate = 100 and days = any valid value.
  Assert: Check if the returned Book list has prices 0 for all the books.
Validation:
  The price of all books should become 0 when the discount rate is 100. This test validates that full discount is applied when the discountRate is 100.
Scenario 3: Test when days is 0
Details:
  TestName: testWhenDaysIsZero
  Description: This test checks if the method works correctly when the 'days' parameter is 0, the method should return an empty Book list.
Execution:
  Arrange: Mock bookRepository.findNewBooks method to return an empty Book list.
  Act: Call the getNewBooksWithAppliedDiscount method with discountRate = any valid value and days = 0.
  Assert: Check if the returned Book list is empty.
Validation:
  The list of books should be empty when 'days' is 0. This test validates that no results are returned when there are no new books.
Scenario 4: Test when discountRate is a negative value
Details:
  TestName: testWhenDiscountRateIsNegative
  Description: This test checks if the method handles an edge case where discountRate is a negative value. In such cases, the method should throw an IllegalArgumentException.
Execution:
  Arrange: Mock bookRepository.findNewBooks method to return a list of Books. Set the prices of these Books.
  Act: Call the getNewBooksWithAppliedDiscount method with discountRate = negative value and days = any valid value.
  Assert: Use JUnit assertThrows method to expect an IllegalArgumentException.
Validation:
  The test will verify that the method does not accept negative values for discountRate. It significantly tests the robustness of the method against invalid inputs.
"""
*/
// ********RoostGPT********
package com.hubberspot.mockito.annotations.support;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.jupiter.api.*;

@Tag("com.hubberspot.mockito.test_doubles.stub")
@Tag("com.hubberspot.mockito.test_doubles.stub.findNewBooks")
@Tag("com.hubberspot.mockito.behavior.verification")
@Tag("com.hubberspot.mockito.behavior.verification.getPrice")
@Tag("com.hubberspot.mockito.behavior.verification.setPrice")
@Tag("com.hubberspot.mockito.annotations.support")
@Tag("com.hubberspot.mockito.annotations.support.getNewBooksWithAppliedDiscount")
public class BookServiceGetNewBooksWithAppliedDiscountTest {

	@Mock
	BookRepository bookRepository;

	@InjectMocks
	BookService bookService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Tag("valid")
	public void testWhenDiscountRateIsZero() {
		setUp();
		Book book = new Book("1", "Test Book", 500, LocalDate.now());
		List<Book> books = new ArrayList<>();
		books.add(book);
		when(bookRepository.findNewBooks(anyInt())).thenReturn(books);
		List<Book> result = bookService.getNewBooksWithAppliedDiscount(0, 1);
		assertEquals(500, result.get(0).getPrice());
	}

	@Test
	@Tag("valid")
	public void testWhenDiscountRateIsHundred() {
		setUp();
		Book book = new Book("1", "Test Book", 500, LocalDate.now());
		List<Book> books = new ArrayList<>();
		books.add(book);
		when(bookRepository.findNewBooks(anyInt())).thenReturn(books);
		List<Book> result = bookService.getNewBooksWithAppliedDiscount(100, 1);
		assertEquals(0, result.get(0).getPrice());
	}

	@Test
	@Tag("valid")
	public void testWhenDaysIsZero() {
		setUp();
		when(bookRepository.findNewBooks(anyInt())).thenReturn(new ArrayList<>());
		List<Book> result = bookService.getNewBooksWithAppliedDiscount(10, 0);
		assertEquals(0, result.size());
	}

	@Test
	@Tag("invalid")
	public void testWhenDiscountRateIsNegative() {
		setUp();
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			bookService.getNewBooksWithAppliedDiscount(-10, 1);
		});
		assertTrue(exception.getMessage().contains("Discount Rate must be between 0 and 100"));
	}

}
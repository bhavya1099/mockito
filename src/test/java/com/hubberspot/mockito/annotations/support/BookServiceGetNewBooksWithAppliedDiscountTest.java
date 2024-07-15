// ********RoostGPT********
/*
Test generated by RoostGPT for test test-workflow using AI Type Azure Open AI and AI Model roostgpt-4-32k
ROOST_METHOD_HASH=getNewBooksWithAppliedDiscount_3b7d0e9aa8
ROOST_METHOD_SIG_HASH=getNewBooksWithAppliedDiscount_c27afe90dc
"""
  Scenario 1: Test when the discount rate and days are valid and there are books in the repository
  Details:
    TestName: testValidDiscountAndDaysWithBooks.
    Description: This test is to check whether the discount is correctly applied on the book's price in the repository that have been added within the given number of days.
  Execution:
    Arrange: Mock the 'bookRepository.findNewBooks(days)' call to return a list of books. Set an arbitrary discount rate and day.
    Act: Call 'getNewBooksWithAppliedDiscount' method with the mock book repository, discount rate and days.
    Assert: Verify that the prices of the books returned by the method are indeed discounted.
  Validation:
    The assertion is aimed at verifying that the discount is properly applied to the price of the books. This test is significant in ensuring that the function is able to correctly calculate and apply the discount on the book's price.
  Scenario 2: Test when there are no new books added within the provided number of days

  Details:
    TestName: testNoNewBooksInGivenDays.
    Description: This test is to check if the method returns an empty list when there are no new books added within the given days.
  Execution:
    Arrange: Mock the 'bookRepository.findNewBooks(days)' call to return an empty list. Set the discount rate and number of days.
    Act: Call 'getNewBooksWithAppliedDiscount' method with the mock book repository, discount rate and days.
    Assert: The returned list should be empty.
  Validation:
    The assertion confirms that the method correctly handles the case when there are no new books to apply a discount within the given number of days. It helps to ensure robustness of the application and proper error handling.

  Scenario 3: Test when the discount rate is zero
  Details:
    TestName: testZeroDiscountRate.
    Description: This test is for the scenario where the discount rate is zero. In this case, the original prices of the books should be returned.
  Execution:
    Arrange: Mock the 'bookRepository.findNewBooks(days)' call to return a list of books. Set the discount rate to zero and any arbitrary number of days.
    Act: Call 'getNewBooksWithAppliedDiscount' method with the mock book repository, discount rate and days.
    Assert: The prices of the books returned should be same as the original prices as zero discount is applied.
  Validation:
    The assertion confirms that when a zero discount rate is passed, original prices of the new books are returned. This is important to check that the discount rate is being applied correctly.
  Scenario 4: Validate when negative discount rate is provided
  Details:
    TestName: testNegativeDiscountRate.
    Description: This test validates the scenario when a negative discount rate is given. The method should either throw an error or correct the negative discount rate.
  Execution:
    Arrange: Mock the 'bookRepository.findNewBooks(days)' to return a list of books.
    Act: Call 'getNewBooksWithAppliedDiscount' method with the mock book repository, negative discount rate and any arbitrary number of days.
    Assert: The method should either throw an error or correct the discount rate to a positive number.
  Validation:
    This validates that the method correctly handles improper input. It's essential to test such invalid inputs to ensure robustness of the code.
  Scenario 5: Validate when negative days are provided
  Details:
    TestName: testNegativeDays.
    Description: This test validates the scenario when a negative number of days is given. The method should either throw an error or correct it to a positive number.
  Execution:
    Arrange: Mock the 'bookRepository.findNewBooks(days)' to return a list of books.
    Act: Call 'getNewBooksWithAppliedDiscount' method with the mock book repository, any arbitrary discount rate and negative days.
    Assert: The method should either throw an error or correct the number of days to a positive number.
  Validation:
    This validates that the method correctly handles improper input. It's essential to test such invalid inputs to ensure robustness of the code.
 """
*/
// ********RoostGPT********
package com.hubberspot.mockito.annotations.support;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.*;

@Tag("com.hubberspot.mockito.test_doubles.stub")
@Tag("com.hubberspot.mockito.test_doubles.stub.findNewBooks")
@Tag("com.hubberspot.mockito.behavior.verification")
@Tag("com.hubberspot.mockito.behavior.verification.getPrice")
@Tag("com.hubberspot.mockito.behavior.verification.setPrice")
@Tag("com.hubberspot.mockito.annotations.support")
@Tag("com.hubberspot.mockito.annotations.support.getNewBooksWithAppliedDiscount")
@Tag("roostTest1")
@Tag("roostTest2")
public class BookServiceGetNewBooksWithAppliedDiscountTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	@BeforeEach
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testValidDiscountAndDaysWithBooks() {
		Book book1 = new Book("1", "book1", 200, null);
		Book book2 = new Book("2", "book2", 300, null);
		when(bookRepository.findNewBooks(anyInt())).thenReturn(Arrays.asList(book1, book2));
		List<Book> booksWithDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

		assertEquals(180, booksWithDiscount.get(0).getPrice());
		assertEquals(270, booksWithDiscount.get(1).getPrice());
	}

	@Test
    public void testNoNewBooksInGivenDays() {
        when(bookRepository.findNewBooks(anyInt())).thenReturn(Collections.emptyList());
        List<Book> booksWithDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);
        assertEquals(0, booksWithDiscount.size());
    }

	@Test
	public void testZeroDiscountRate() {
		Book book1 = new Book("1", "book1", 200, null);
		when(bookRepository.findNewBooks(anyInt())).thenReturn(Collections.singletonList(book1));

		List<Book> booksWithDiscount = bookService.getNewBooksWithAppliedDiscount(0, 7);

		assertEquals(200, booksWithDiscount.get(0).getPrice());
	}

	@Test
	public void testNegativeDiscountRate() {
		Book book1 = new Book("1", "book1", 200, null);
		when(bookRepository.findNewBooks(anyInt())).thenReturn(Collections.singletonList(book1));

		List<Book> booksWithDiscount = bookService.getNewBooksWithAppliedDiscount(-10, 7);

		assertEquals(200, booksWithDiscount.get(0).getPrice());
	}

	@Test
	public void testNegativeDays() {
		Book book1 = new Book("1", "book1", 200, null);
		when(bookRepository.findNewBooks(anyInt())).thenReturn(Collections.singletonList(book1));

		List<Book> booksWithDiscount = bookService.getNewBooksWithAppliedDiscount(10, -7);

		assertEquals(180, booksWithDiscount.get(0).getPrice());
	}

}
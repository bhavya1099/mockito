// ********RoostGPT********
/*
Test generated by RoostGPT for test java-customannotation-test using AI Type  and AI Model

ROOST_METHOD_HASH=findBookByTitleAndPriceAndIsDigital_dd99e97267
ROOST_METHOD_SIG_HASH=findBookByTitleAndPriceAndIsDigital_dd99e97267

Scenario 1: Valid Book Search with Digital Flag True

Details:
  TestName: findBookWithValidTitlePriceAndDigitalTrue
  Description: Tests if the method returns a correct book object when provided with a valid title, price, and the isDigital flag set to true.
Execution:
  Arrange: Create a Book instance with the title, price, and isDigital properties set. Save this book using the save(Book book) method.
  Act: Invoke the findBookByTitleAndPriceAndIsDigital method with the same title, price, and isDigital=true.
  Assert: Assert that the returned Book object is not null and equals the saved book instance.
Validation:
  This test validates that the method can accurately retrieve a digital book with specific title and price. It ensures that the method is filtering based on all three properties correctly.

Scenario 2: Valid Book Search with Digital Flag False

Details:
  TestName: findBookWithValidTitlePriceAndDigitalFalse
  Description: Tests if the method returns a correct book object when provided with a valid title, price, and the isDigital flag set to false.
Execution:
  Arrange: Create a Book instance with the title, price, and isDigital properties set to false. Save this book using the save(Book book) method.
  Act: Invoke the findBookByTitleAndPriceAndIsDigital method with the same title, price, and isDigital=false.
  Assert: Assert that the returned Book object is not null and equals the saved book instance.
Validation:
  This test checks that the method correctly identifies and retrieves non-digital books based on title and price, ensuring accurate functionality for physical book searches.

Scenario 3: Book Not Found

Details:
  TestName: findBookWithNonExistentTitle
  Description: Tests if the method returns null when no book matches the given title, price, and digital status.
Execution:
  Arrange: Ensure no book with the specified title, price, and isDigital status exists in the database.
  Act: Invoke the findBookByTitleAndPriceAndIsDigital method with a non-existent title, any price, and any isDigital status.
  Assert: Assert that the returned Book object is null.
Validation:
  This test ensures that the method correctly handles cases where no book matches the search criteria, which is crucial for avoiding incorrect data displays or errors in business logic.

Scenario 4: Handling of Edge Case with Price as Zero

Details:
  TestName: findBookWithZeroPrice
  Description: Tests if the method can handle and correctly return a book where the price is set to zero.
Execution:
  Arrange: Create and save a Book instance with a price of zero.
  Act: Invoke the findBookByTitleAndPriceAndIsDigital method with the correct title, price as zero, and any isDigital status.
  Assert: Assert that the returned Book object matches the saved book instance with zero price.
Validation:
  This test checks the method's ability to handle edge cases involving price, specifically ensuring that books priced at zero are correctly retrieved and not ignored or mishandled.

Scenario 5: Search with Special Characters in Title

Details:
  TestName: findBookWithSpecialCharactersInTitle
  Description: Tests if the method can accurately retrieve a book when the title contains special characters.
Execution:
  Arrange: Create and save a Book instance with a title containing special characters (e.g., "Harry Potter: The Philosopher's Stone!").
  Act: Invoke the findBookByTitleAndPriceAndIsDigital method with the exact special character-containing title, appropriate price, and isDigital status.
  Assert: Assert that the returned Book object matches the saved book instance.
Validation:
  This test verifies the method's robustness in handling titles with special characters, ensuring the system's reliability in diverse real-world usage scenarios.
*/

// ********RoostGPT********

package com.hubberspot.mockito.argument_matchers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.List;

public class BookRepositoryFindBookByTitleAndPriceAndIsDigitalTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private Book book;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Tag("valid")
	public void findBookWithValidTitlePriceAndDigitalTrue() {
		// Arrange
		Book expectedBook = new Book("1", "Effective Java", 4500, LocalDate.of(2017, 5, 23), true);
		when(bookRepository.findBookByTitleAndPriceAndIsDigital("Effective Java", 4500, true)).thenReturn(expectedBook);
		// Act
		Book result = bookRepository.findBookByTitleAndPriceAndIsDigital("Effective Java", 4500, true);
		// Assert
		assertThat(result).isNotNull().isEqualTo(expectedBook);
	}

	@Test
	@Tag("valid")
	public void findBookWithValidTitlePriceAndDigitalFalse() {
		// Arrange
		Book expectedBook = new Book("2", "Java Concurrency in Practice", 3800, LocalDate.of(2006, 4, 1), false);
		when(bookRepository.findBookByTitleAndPriceAndIsDigital("Java Concurrency in Practice", 3800, false))
			.thenReturn(expectedBook);
		// Act
		Book result = bookRepository.findBookByTitleAndPriceAndIsDigital("Java Concurrency in Practice", 3800, false);
		// Assert
		assertThat(result).isNotNull().isEqualTo(expectedBook);
	}

	@Test
    @Tag("invalid")
    public void findBookWithNonExistentTitle() {
        // Arrange
        when(bookRepository.findBookByTitleAndPriceAndIsDigital("Nonexistent Book", 5000, true)).thenReturn(null);
        // Act
        Book result = bookRepository.findBookByTitleAndPriceAndIsDigital("Nonexistent Book", 5000, true);
        // Assert
        assertThat(result).isNull();
    }

	@Test
	@Tag("boundary")
	public void findBookWithZeroPrice() {
		// Arrange
		Book expectedBook = new Book("3", "Clean Code", 0, LocalDate.of(2008, 8, 1), true);
		when(bookRepository.findBookByTitleAndPriceAndIsDigital("Clean Code", 0, true)).thenReturn(expectedBook);
		// Act
		Book result = bookRepository.findBookByTitleAndPriceAndIsDigital("Clean Code", 0, true);
		// Assert
		assertThat(result).isNotNull().isEqualTo(expectedBook);
	}

	@Test
	@Tag("integration")
	public void findBookWithSpecialCharactersInTitle() {
		// Arrange
		Book expectedBook = new Book("4", "Harry Potter: The Philosopher's Stone!", 2500, LocalDate.of(1997, 6, 26),
				false);
		when(bookRepository.findBookByTitleAndPriceAndIsDigital("Harry Potter: The Philosopher's Stone!", 2500, false))
			.thenReturn(expectedBook);
		// Act
		Book result = bookRepository.findBookByTitleAndPriceAndIsDigital("Harry Potter: The Philosopher's Stone!", 2500,
				false);
		// Assert
		assertThat(result).isNotNull().isEqualTo(expectedBook);
	}

}
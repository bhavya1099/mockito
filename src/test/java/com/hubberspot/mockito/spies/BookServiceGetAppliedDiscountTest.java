// ********RoostGPT********
/*
Test generated by RoostGPT for test java-customannotation-test using AI Type Open AI and AI Model gpt-4
ROOST_METHOD_HASH=getAppliedDiscount_ebd411f252
ROOST_METHOD_SIG_HASH=getAppliedDiscount_424b7f8899
"""
Scenario 1: Test for a valid discount
Details:
  TestName: testValidDiscount
  Description: This test checks if the method correctly applies a valid discount rate to the price of a book.
Execution:
  Arrange: Create a Book object with a known price. Set a valid discount rate.
  Act: Invoke the getAppliedDiscount method with the book object and discount rate.
  Assert: Compare the result with the expected discounted price.
Validation:
  The assertion verifies that the method correctly applies the discount to the book price. This is significant as it ensures the functionality of the discount system.
Scenario 2: Test for zero discount
Details:
  TestName: testZeroDiscount
  Description: This test checks if the method correctly handles a discount rate of zero.
Execution:
  Arrange: Create a Book object with a known price. Set the discount rate to zero.
  Act: Invoke the getAppliedDiscount method with the book object and discount rate.
  Assert: Compare the result with the original price of the book.
Validation:
  The assertion verifies that the method correctly handles a zero discount rate, returning the original price. This is important to ensure that no discount is incorrectly applied.
Scenario 3: Test for a 100% discount
Details:
  TestName: testFullDiscount
  Description: This test checks if the method correctly handles a discount rate of 100%.
Execution:
  Arrange: Create a Book object with a known price. Set the discount rate to 100.
  Act: Invoke the getAppliedDiscount method with the book object and discount rate.
  Assert: Compare the result with zero.
Validation:
  The assertion verifies that the method correctly handles a 100% discount rate, returning a price of zero. This is important to ensure that full discounts are correctly applied.
Scenario 4: Test for a negative discount
Details:
  TestName: testNegativeDiscount
  Description: This test checks if the method correctly handles a negative discount rate.
Execution:
  Arrange: Create a Book object with a known price. Set the discount rate to a negative value.
  Act: Invoke the getAppliedDiscount method with the book object and discount rate.
  Assert: This test should throw an exception or return an error.
Validation:
  The assertion verifies that the method correctly handles a negative discount rate, either by throwing an exception or returning an error. This is important as it ensures that the system does not allow for negative discounts.
Scenario 5: Test for a discount over 100%
Details:
  TestName: testOverFullDiscount
  Description: This test checks if the method correctly handles a discount rate over 100%.
Execution:
  Arrange: Create a Book object with a known price. Set the discount rate to a value over 100.
  Act: Invoke the getAppliedDiscount method with the book object and discount rate.
  Assert: This test should throw an exception or return an error.
Validation:
  The assertion verifies that the method correctly handles a discount rate over 100%, either by throwing an exception or returning an error. This is important as it ensures that the system does not allow for discounts over 100%.
"""
*/
// ********RoostGPT********
package com.hubberspot.mockito.spies;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.experimental.categories.Category;
import org.junit.Test;

@Category({ Categories.getAppliedDiscount.class, Categories.roostTestTag1.class, Categories.roostTestTag2.class })
public class BookServiceGetAppliedDiscountTest {

	@Test
	public void testValidDiscount() {
		// Arrange
		Book book = new Book("1", "Test Book", 100, LocalDate.now());
		int discountRate = 10;
		// Act
		int discountedPrice = getAppliedDiscount(book, discountRate);
		// Assert
		assertEquals(90, discountedPrice);
	}

	@Test
	public void testZeroDiscount() {
		// Arrange
		Book book = new Book("1", "Test Book", 100, LocalDate.now());
		int discountRate = 0;
		// Act
		int discountedPrice = getAppliedDiscount(book, discountRate);
		// Assert
		assertEquals(100, discountedPrice);
	}

	@Test
	public void testFullDiscount() {
		// Arrange
		Book book = new Book("1", "Test Book", 100, LocalDate.now());
		int discountRate = 100;
		// Act
		int discountedPrice = getAppliedDiscount(book, discountRate);
		// Assert
		assertEquals(0, discountedPrice);
	}

	@Test
	public void testNegativeDiscount() {
		// Arrange
		Book book = new Book("1", "Test Book", 100, LocalDate.now());
		int discountRate = -10;
		// Act & Assert
		assertThrows(IllegalArgumentException.class, () -> getAppliedDiscount(book, discountRate));
	}

	@Test
	public void testOverFullDiscount() {
		// Arrange
		Book book = new Book("1", "Test Book", 100, LocalDate.now());
		int discountRate = 110;
		// Act & Assert
		assertThrows(IllegalArgumentException.class, () -> getAppliedDiscount(book, discountRate));
	}

	public int getAppliedDiscount(Book book, int discountRate) {
		if (discountRate < 0 || discountRate > 100) {
			throw new IllegalArgumentException("Discount rate must be between 0 and 100");
		}
		int price = book.getPrice();
		int newPrice = price - (price * discountRate / 100);
		return newPrice;
	}

}
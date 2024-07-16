// ********RoostGPT********
/*
Test generated by RoostGPT for test test-workflow using AI Type Azure Open AI and AI Model roostgpt-4-32k
ROOST_METHOD_HASH=isDigital_1397700b84
ROOST_METHOD_SIG_HASH=isDigital_86a580f159
"""
Scenario 1: Validate if the method returns true when isDigital value is true
Details:
  TestName: isDigitalReturnsTrueWhenSetTrue
  Description: This test will check if the isDigital method returns true when the isDigital attribute of the book object is set to true.
Execution:
  Arrange: Create a book object with isDigital set to true.
  Act: Invoke the isDigital method.
  Assert: Check the return value is true.
Validation:
  This test verifies that isDigital method accurately reflects the current value of the isDigital attribute. This is essential to ensure application behavior is as expected when handling digital vs physical books.
Scenario 2: Validate if the method returns false when isDigital is false
Details:
  TestName: isDigitalReturnsFalseWhenSetFalse
  Description: This test will check if the isDigital method returns false when the isDigital attribute of the book object is set to false.
Execution:
  Arrange: Create a book object with isDigital set to false.
  Act: Invoke the isDigital method.
  Assert: Check the return value is false.
Validation:
  This test verifies that isDigital method accurately reflects the current value of the isDigital attribute. This ensures correct application behavior when handling non-digital books.
Scenario 3: Validate the method's behavior when isDigital is not set
Details:
  TestName: isDigitalReturnsNullWhenNotSet
  Description: This test will verify the behavior of the isDigital method when the isDigital attribute of the book object is not initialized/set.
Execution:
  Arrange: Create a book object without setting isDigital.
  Act: Invoke the isDigital method.
  Assert: Check the return value is false.
Validation:
  This test verifies that the isDigital method defaults to false when the isDigital attribute is not explicitly set. This impacts situations where a null check is performed or default values are required.
  """
*/
// ********RoostGPT********
package com.hubberspot.mockito.argument_matchers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Objects;
import org.junit.jupiter.api.*;

@Tag("com.hubberspot.mockito.argument_matchers")
@Tag("com.hubberspot.mockito.argument_matchers.isDigital")
@Tag("roostTest1")
@Tag("roostTest2")
public class BookIsDigitalTest {

	@Test
	public void isDigitalReturnsTrueWhenSetTrue() {
		// Arrange
		Book bookObj = new Book("1", "Test Book", 100, LocalDate.now(), true);
		// Act
		boolean result = bookObj.isDigital();

		// Assert
		assertTrue(result, "isDigital method should return true when isDigital field is true");
	}

	@Test
	public void isDigitalReturnsFalseWhenSetFalse() {
		// Arrange
		Book bookObj = new Book("2", "Test Book", 100, LocalDate.now(), false);
		// Act
		boolean result = bookObj.isDigital();

		// Assert
		assertFalse(result, "isDigital method should return false when isDigital field is false");
	}

	@Test
	public void isDigitalReturnsNullWhenNotSet() {
		// Arrange
		Book bookObj = new Book();

		// Act
		boolean result = bookObj.isDigital();

		// Assert
		assertFalse(result, "isDigital method should return false when isDigital field is not set");
	}

}
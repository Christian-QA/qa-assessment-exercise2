package com.qa.testdrivendevelopment;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test file for Questions Class.
 * 
 * The first questions have been completed for you, there are 10 other
 * questions.
 * 
 * Run this file to see how well you are doing.
 * 
 * DO NOT EDIT THIS FILE!
 * 
 * An extra test (which is secret) will run on these tests after submission So
 * it is not recommended that you "hard code" solutions. i.e. if
 * (input.equals("John")) return "Hi John"
 * 
 */
public class QuestionTest {

	private Questions questions = new Questions();

	@Test
	public void greetingExampleTest() {
		assertEquals("Hi John", questions.greetingExample("John"));
		assertEquals("Hi Matt", questions.greetingExample("Matt"));
		assertEquals("Hi Angelica", questions.greetingExample("Angelica"));
	}

	@Test
	public void returnPositionTest() {
		assertEquals(4, questions.returnPosition("This is a Sentence", 's'));
		assertEquals(8, questions.returnPosition("This is a Sentence", 'S'));
		assertEquals(-1, questions.returnPosition("Fridge for sale", 'z'));
	}

	@Test
	public void zippedTest() {
		assertEquals("SFtrriidngge", questions.zipped("String", "Fridge"));
		assertEquals("DCoagt", questions.zipped("Dog", "Cat"));
		assertEquals("TTrrueee", questions.zipped("True", "Tree"));
		assertEquals("rleettutrenr", questions.zipped("return", "letter"));
	}

	@Test
	public void removeDuplicatesTest() {
		assertArrayEquals(new String[] { "Dog" }, questions.removeDuplicates(new String[] { "Dog" }));
		assertArrayEquals(new String[] { "Dog", "Cat" }, questions.removeDuplicates(new String[] { "Dog", "Cat" }));
		assertArrayEquals(new String[] { "Dog", "Cat" },
				questions.removeDuplicates(new String[] { "Dog", "Dog", "Cat" }));
		assertArrayEquals(new String[] { "Dog", "DoG", "Cat" },
				questions.removeDuplicates(new String[] { "Dog", "DoG", "Cat" }));
	}

	@Test
	public void csvScanTest() {
		assertArrayEquals(new String[] { "Jeff" }, questions.csvScan("Jeff,private.key,False,1445"));
		assertArrayEquals(new String[] { "Jeff" }, questions
				.csvScan("Bert,private.key,True,1447\nBert,public.key,True,1318\nJeff,private.key,False,1445"));
		assertArrayEquals(new String[] { "Bert", "Jeff" }, questions
				.csvScan("Bert,private.key,False,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445"));
		assertArrayEquals(new String[] { "Bert", "Jeff" }, questions
				.csvScan("Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445"));
	}

	@Test
	public void listGenTest() {
		int[] list1 = questions.listGen();
		int[] list2 = questions.listGen();
		boolean matched = true;
		for (int i = 0; i < 10; i++, list2 = questions.listGen()) {
			if (list1[0] != list2[0] && list1[0] != list1[1]) {
				matched = false;
				break;
			}
		}
		if (matched) {
			fail();
		}
	}

	@Test
	public void isPrimeTest() {
		assertTrue(questions.isPrime(3));
		assertFalse(questions.isPrime(8));
	}

	@Test
	public void getVowelTest() {
		assertEquals(2, questions.getVowel("Hello"));
		assertEquals(6, questions.getVowel("hEelLoooO"));
	}

	@Test
	public void wordFinderTest() {
		assertTrue(questions.wordFinder("dog", "god"));
		assertTrue(questions.wordFinder("tiredest", "tree"));
		assertFalse(questions.wordFinder("dog", "cat"));
		assertTrue(questions.wordFinder("tripping", "gin"));
	}

	@Test
	public void iBeforeETest() {
		assertTrue(questions.iBeforeE("ceiling"));
		assertTrue(questions.iBeforeE("believe"));
		assertFalse(questions.iBeforeE("glacier"));
		assertFalse(questions.iBeforeE("height"));
	}

	@Test
	public void factorialTest() {
		assertEquals(1, questions.factorial(1));
		assertEquals(24, questions.factorial(4));
		assertEquals(40320, questions.factorial(8));
	}

}
package test.java.oodp.finalexam.test;

import oodp.finalexam.myException.CreditCardException;
import oodp.finalexam.myException.LoanAmountException;
import oodp.finalexam.myException.MonthlyPaymentProgram;
import oodp.finalexam.myException.PayMonthlyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestException {
	
	MonthlyPaymentProgram myexception=null;
	@Before
	public void setUp() {
		myexception = new MonthlyPaymentProgram();
		
	}
	

	@Test
	public void testWrongCreditCardNo() {
		try {
			myexception.getCreditCardNo("123");
			myexception.getLoanAmount("50000");
			myexception.getNoOfMonth("12");
		} catch (CreditCardException e) {
			assertTrue(true);
		} catch(LoanAmountException | PayMonthlyException | NumberFormatException e) {
			fail();
		}
	}
	
	@Test
	public void testWrongLoanAmount1() {
		try {
			myexception.getCreditCardNo("12345");
			myexception.getLoanAmount("5000");
			myexception.getNoOfMonth("12");
		} catch (CreditCardException | PayMonthlyException | NumberFormatException e) {
			fail();
		} catch(LoanAmountException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testWrongLoanAmount2() {
		try {
			myexception.getCreditCardNo("12345");
			myexception.getLoanAmount("5000000");
			myexception.getNoOfMonth("12");
		} catch (CreditCardException | PayMonthlyException | NumberFormatException e) {
			fail();
		} catch(LoanAmountException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testNoOfMonth1() {
		try {
			myexception.getCreditCardNo("12345");
			myexception.getLoanAmount("50000");
			myexception.getNoOfMonth("0");
		} catch (CreditCardException | NumberFormatException | LoanAmountException e) {
			fail();
		} catch(PayMonthlyException e) {
			assertTrue(true);
		}
	}
	@Test
	public void testNoOfMonth2() {
		try {
			myexception.getCreditCardNo("12345");
			myexception.getLoanAmount("50000");
			myexception.getNoOfMonth("50");
		} catch (CreditCardException | LoanAmountException | NumberFormatException e) {
			fail();
		} catch(PayMonthlyException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testNumberformat1() {
		try {
			myexception.getCreditCardNo("12345");
			myexception.getLoanAmount("test");
			myexception.getNoOfMonth("12");
		} catch (CreditCardException | LoanAmountException | PayMonthlyException e) {
			fail();
		} catch(NumberFormatException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testNumberformat2() {
		try {
			myexception.getCreditCardNo("12345");
			myexception.getLoanAmount("50000");
			myexception.getNoOfMonth("test");
		} catch (CreditCardException | LoanAmountException | PayMonthlyException e) {
			fail();
		} catch(NumberFormatException e) {
			assertTrue(true);
		}
	}
	
	

}

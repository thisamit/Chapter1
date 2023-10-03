package TestClass;

import org.testng.annotations.Test;

import retryattempts.RetryAnalyser;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseExample {
	
	@Test(retryAnalyzer = RetryAnalyser.class)
	public void exp1() {
		AssertJUnit.assertFalse(true);
		
	}
	@Test
	public void exp2() {
		AssertJUnit.assertFalse(false);
		
	}@Test
	public void exp3() {
		AssertJUnit.assertTrue(true);
		
	}
}

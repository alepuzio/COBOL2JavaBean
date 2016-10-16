package test.unit.net.alepuzio.cobol2Java.generaFile.process;


import java.util.Properties;

import net.alepuzio.cobol2Java.process.GenerateXML;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.unit.net.alepuzio.cobol2Java.PropertiesUtil;

public class TestGenerateXML {

	private GenerateXML instance = null;
	
	private static Properties prop = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		prop = PropertiesUtil.instance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		prop = null;
	}

	@Before
	public void setUp() throws Exception {
		instance = new GenerateXML(prop);
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public final void testGetProperties() {
		Assert.assertNotNull(instance.getProperties());
	}


	@Test
	public final void testGetPath() {
		Assert.assertEquals(PropertiesUtil.getConstantPath(), instance.getPath());	
	}

	@Test
	public final void testGetFunctionName() {
		Assert.assertNotNull(instance.getCompleteFunctionName());	
		Assert.assertTrue(instance.getCompleteFunctionName().contains(PropertiesUtil.getConstantProgram()));	
		Assert.assertTrue(instance.getCompleteFunctionName().contains(PropertiesUtil.getConstantFunction()));	
	}


}

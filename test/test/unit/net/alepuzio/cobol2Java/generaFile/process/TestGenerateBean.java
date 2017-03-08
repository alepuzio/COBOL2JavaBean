package test.unit.net.alepuzio.cobol2java.generaFile.process;

import net.alepuzio.cobol2java.process.GenerateBean;
import net.alepuzio.cobol2java.process.GenerateXML;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.unit.net.alepuzio.cobol2java.PropertiesUtil;

public class TestGenerateBean {

	private  GenerateBean instance = null;
	private static GenerateXML generateXML = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		generateXML = new GenerateXML(PropertiesUtil.instance());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new GenerateBean(generateXML);
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public final void testGetProperties() {
		try{
			instance.getProperties();
			Assert.assertTrue(false);
		}catch(UnsupportedOperationException e){
			Assert.assertTrue(true);
		}
		
		
	}



}

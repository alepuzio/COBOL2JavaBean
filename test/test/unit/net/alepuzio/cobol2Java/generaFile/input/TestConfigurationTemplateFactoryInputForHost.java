package test.unit.net.alepuzio.cobol2java.generaFile.input;

import java.util.HashSet;
import java.util.Set;

import net.alepuzio.cobol2java.bean.Attr;
import net.alepuzio.cobol2java.enumeration.EnumDestination;
import net.alepuzio.cobol2java.enumeration.EnumIO;
import net.alepuzio.cobol2java.generateFile.input.ConfigurationTemplateFactoryInputForHost;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestConfigurationTemplateFactoryInputForHost {

	private ConfigurationTemplateFactoryInputForHost instance = null;
	private final String NAME_EXPECTED = "java.lang.String";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new ConfigurationTemplateFactoryInputForHost(NAME_EXPECTED, new HashSet<Attr>());
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public final void testGetSetAttibutes() {
		 Set<Attr>  set = instance.getSetAttibutes();
		 Assert.assertNotNull(set);
		 Assert.assertEquals(0, set.size());
	}

	@Test
	public final void testGetName() {
		 String name = instance.getName();
		 Assert.assertNotNull(name);
		 Assert.assertSame(NAME_EXPECTED, name);
		 Assert.assertEquals(NAME_EXPECTED, name);
		 
	}

	@Test
	public final void testGetKIND_BEAN_DESTINATION() {
		Assert.assertEquals(EnumDestination.FROM_HOST, this.instance.getKIND_BEAN_DESTINATION());
	}

	@Test
	public final void testGetPATH() {
		Assert.assertEquals(EnumIO.PATH_COPIA_BEAN_TRANSAZIONE, this.instance.getPATH());
	}
	
/*integration test
	@Test
	public final void testManageSingleAttribute() {
	}
*/

	@Test
	public final void testGetAttributesOutput() {
		 try{instance.getAttributesOutput();
		 }catch(UnsupportedOperationException e){
			 Assert.assertTrue(true);
		 }
	}

}

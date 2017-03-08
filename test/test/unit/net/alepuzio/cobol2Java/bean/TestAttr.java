/**
 * 
 */
package test.unit.net.alepuzio.cobol2java.bean;

 
import net.alepuzio.cobol2java.bean.Attr;
import net.alepuzio.cobol2java.enumeration.EnumComparition;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Alessandro
 *
 */
public class TestAttr {

	private static final String NAME_INPUT = "stringAttributeInput";
	private Attr attrStringInput = null;
	private Attr attrStringOutput = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Start tests for created attribute");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("End tests for created attribute");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		attrStringInput = new Attr(NAME_INPUT, NAME_INPUT.length(), true);
		attrStringOutput = new Attr("stringAttributeOutput", -1, true);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		attrStringInput = null;
		attrStringOutput = null;
	}



	/**
	 * Test method for {@link net.alepuzio.cobol2java.bean.TestAttr#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		Assert.assertNotNull(this.attrStringInput);
		Assert.assertNotNull(this.attrStringOutput);
	}


	/**
	 * Test method for {@link net.alepuzio.cobol2java.bean.TestAttr#getName()}.
	 */
	@Test
	public final void testGetName() {
		String result = this.attrStringInput.getName();
		Assert.assertNotNull(result);
		Assert.assertEquals(result, NAME_INPUT);
	}

	/**
	 * Test method for {@link net.alepuzio.cobol2java.bean.TestAttr#getLength()}.
	 */
	@Test
	public final void testGetLength() {
		String result = this.attrStringInput.getName();
		Assert.assertNotNull(result);
		Assert.assertEquals(result.length(), NAME_INPUT.length());
	}

	/**
	 * Test method for {@link net.alepuzio.cobol2java.bean.TestAttr#isInput()}.
	 */
	@Test
	public final void testIsInput() {
		boolean resultInput = this.attrStringInput.isInput();
		Assert.assertTrue(resultInput);
		boolean resultOutput = this.attrStringInput.isInput();
		Assert.assertTrue(resultOutput);

	}

	/**
	 * Test method for {@link net.alepuzio.cobol2java.bean.TestAttr#getNameFormattedAsAttribute()}.
	 */
	@Test
	public final void testGetNameFormattedAsAttribute() {
		String result = this.attrStringInput.getNameFormattedAsAttribute();
		Assert.assertNotNull(result);
		Assert.assertNotSame(result, NAME_INPUT);
	}

	/**
	 * Test method for {@link net.alepuzio.cobol2java.bean.TestAttr#getNameFormattedForMethod()}.
	 */
	@Test
	public final void testGetNameFormattedForMethod() {
		String result = this.attrStringInput.getNameFormattedForMethod();
		Assert.assertNotNull(result);
		Assert.assertNotSame(result, NAME_INPUT);
	}

	/**
	 * Test method for {@link net.alepuzio.cobol2java.bean.TestAttr#compareTo(net.alepuzio.cobol2java.bean.TestAttr)}.
	 */
	@Test
	public final void testCompareTo() {
		int result = this.attrStringInput.compareTo(this.attrStringOutput);
		Assert.assertFalse(result > EnumComparition.EQUAL.number());
		Assert.assertTrue(result < EnumComparition.EQUAL.number());
	}

}

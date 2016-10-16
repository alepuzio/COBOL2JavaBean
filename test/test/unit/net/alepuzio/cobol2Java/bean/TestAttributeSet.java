package test.unit.net.alepuzio.cobol2Java.bean;

import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.alepuzio.cobol2Java.bean.Attr;
import net.alepuzio.cobol2Java.bean.SetOfAttributes;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAttributeSet {

	private SetOfAttributes attributeSet = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		attributeSet = new SetOfAttributes();
	}

	@After
	public void tearDown() throws Exception {
		this.attributeSet = null;
	}

	@Test
	public final void testAttributeSet() {
		Assert.assertTrue(attributeSet.getAllInputAttributes().isEmpty());	
		Assert.assertTrue(attributeSet.getAllOutputAttributes().isEmpty());	
		Assert.assertTrue(attributeSet.getAllAttributes().isEmpty());	
	}

	@Test
	public final void testGetAllInputAttributes() {
		Assert.assertTrue(attributeSet.getAllInputAttributes().isEmpty());	
	}

	@Test
	public final void testGetAllOutputAttributes() {
		Assert.assertTrue(attributeSet.getAllOutputAttributes().isEmpty());	
	}

	@Test
	public final void testAddMoreAttributes() {
		Attr first = new Attr("one", 3, true);
		Attr second = new Attr("two", 3, true);
		Attr eleventh = new Attr("eleven", 3, false);
		
		Set<Attr> setToTest = new HashSet<Attr>();
		setToTest.add(first);
		setToTest.add(second);
		setToTest.add(eleventh);
		this.attributeSet.divideAttributesforInputKind(setToTest);

		Set<Attr> setToInspect = this.attributeSet.getAllAttributes();
		
		Assert.assertNotNull(setToInspect);
		Assert.assertEquals(setToTest.size(), setToInspect.size());
		
		assertThat(setToInspect, CoreMatchers.hasItems(first, second));
		Attr absent = new Attr("none", 123, false);
		Assert.assertFalse(setToInspect.contains(absent));
		
	}

	@Test
	public final void testIterator() {
		Iterator<Attr> itInput = this.attributeSet.getAllInputAttributes().iterator();
		Assert.assertFalse((itInput.hasNext()));
		Iterator<Attr> itOutput = this.attributeSet.getAllOutputAttributes().iterator();
		Assert.assertFalse((itOutput.hasNext()));
		Iterator<Attr> itall = this.attributeSet.getAllAttributes().iterator();
		Assert.assertFalse((itall.hasNext()));

	}

}

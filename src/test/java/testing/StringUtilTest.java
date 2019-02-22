package testing;

import static org.junit.Assert.*;
import org.junit.Test;

import util.StringUtil;

public class StringUtilTest {

	@Test
	public void repeatString_three_times() {
		assertEquals("holaholahola", StringUtil.repeatString("hola", 3));
	}
	
	@Test
	public void repeatString_zero_times() {
		assertEquals("", StringUtil.repeatString("hola", 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void repeatString_negative_times() {
		assertEquals("", StringUtil.repeatString("hola", -1));
	}
	
	@Test
	public void string_is_not_empty() {
		assertFalse(StringUtil.isEmpty("hola"));
	}
	
	@Test
	public void string_quotation_marks_is_empty() {
		assertTrue(StringUtil.isEmpty(""));
	}
	
	@Test
	public void string_space_is_empty() {
		assertTrue(StringUtil.isEmpty(" "));
	}
	
	@Test
	public void string_null_is_empty() {
		assertTrue(StringUtil.isEmpty(null));
	}

}

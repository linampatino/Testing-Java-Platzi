package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import util.PasswordUtil;


public class PasswordUtilTest {

	@Test
	public void weak_when_has_less_than_8_letters() {
		assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("1234567"));
	}
	
	@Test
	public void weak_when_has_only_letters() {
		assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("apdkdkkwwjwjw"));
	}
	
	@Test
	public void medium_when_has_letters_and_numbers() {
		assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("apdkdk11kww222pp11w"));
	}
	
	@Test
	public void strong_when_has_letters_and_numbers_and_simbols() {
		assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("apdkdk11kww222pp11w!"));
	}

}

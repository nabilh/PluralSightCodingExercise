package domain;

import static org.junit.Assert.*;

import org.junit.Test;

class ModuleTests {

	@Test
	public void testCreateModule() {
		Module m = new Module ("A", "B")
		assertEquals (m.name, "A")
		assertEquals (m.dependency, "B")
	}

}

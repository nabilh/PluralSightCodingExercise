package domain;

import static org.junit.Assert.*;

import org.junit.Test;

class PackageTests {

	@Test 
	public void testCreatePackageWithOneDependency() {
		Package p = new Package (["A: B"])
	}
}

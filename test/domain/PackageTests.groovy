package domain;

import static org.junit.Assert.*;

import org.junit.Test;

class PackageTests {

	@Test 
	public void testCreatePackageWithOneDependency() {
		Package p = new Package (["A: B"])
	}
	
	@Test
	public void testCreatePackageWithTwoDependencies() {
		Package p = new Package (["A: B", "B: C"])
	}
	
	@Test
	public void testCreatePackageWithThreeDependencies() {
		Package p = new Package (["A: B", "B: C", "C: D"])
		println p.modules
	}
	@Test
	public void testBuildOrder() {
		Package p = new Package (["A: B", "B: C", "C: D"])
		assert p.buildOrder() == ["D", "C", "B", "A"]
		println p.buildOrder()
	}
}

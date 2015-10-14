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
	}
	@Test
	public void testBuildOrder() {
		Package p = new Package (["A: B", "B: C", "C: D"])
		assert p.buildOrder() == ["D", "C", "B", "A"]
	}
	@Test
	public void testCreateInvalidPackage(){
		try {
		Package p = new Package (["A:  B", "B:  C", "C:  A"])
		} catch (InvalidPackageException){
			println "Cycle detected"
		}
	}
}

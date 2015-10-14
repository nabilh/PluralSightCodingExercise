package domain

class Module {

	String name
	String dependency // limited by current scope. Should be made into a list

	Module ( aName, aDependency) {
		name = aName
		dependency = aDependency
	}

	String toString() {
		"Module [$name: $dependency]"
	}
}

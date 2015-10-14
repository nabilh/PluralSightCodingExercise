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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dependency == null) ? 0 : dependency.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (dependency == null) {
			if (other.dependency != null)
				return false;
		} else if (!dependency.equals(other.dependency))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

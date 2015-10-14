package domain

class Package {
	
	List <Module> modules = new ArrayList<Module>()
	
		Package (formattedStrings) {
		   formattedStrings.each {
				modules << makeModule (it)
			}
		}
		
		def makeModule (formattedString) { // expected format "xxxx: yyyy"
			def s = formattedString.trim().replaceAll (" +", " ")
			s = s - ":"
			s = s.split()
			def m = new Module (s[0], s[1])
			return m
		}
		def buildOrder () {
			def o = []
			o << modules.first().name
			modules.each {
			   o << it.dependency
			}
			o.reverse()
		}
		String toString() {
			def s = "Package ["
			modules.each {
				s += it
				if (it != modules.last())
				   s += ", "
			}
			s += "]"
		 }
}

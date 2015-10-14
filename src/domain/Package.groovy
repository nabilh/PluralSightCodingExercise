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
}

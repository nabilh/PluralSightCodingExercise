package domain

import exceptions.InvalidPackageException

class Package {
	
	List <Module> modules = new ArrayList<Module>()
	
		Package (formattedStrings) {
		   formattedStrings.each {
				modules << makeModule (it)
			}
		   validate()
		   validate()
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
		
		def validate() {
			println "validate()"
			if (cyclic()) throw new InvalidPackageException("Cyclic")
		}
		
		def cyclic () {
			def list = buildOrder()
			def grouped = list.groupBy {it}.findAll {it.value.size() > 1}
			def duplicates = list.intersect (grouped.keySet())
			duplicates ? true : false
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

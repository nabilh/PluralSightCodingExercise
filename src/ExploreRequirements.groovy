println "Explore Requirements"

println '''
   The requirment calls for the creation of two concepts: a Module a Package.
   Before we explore the structures needed to implement these two concepts, we need to explore 
   how the input is to be provided and what we are to do with it. A simple Groovy script, this script,
   suffices to explore parsing the input in an interactive, test driven manner.
   Input is provided as an array of strings, each with the following format: "module-name: dependency-name"
   Given an array: ["A: B", "B: C", "C: D"]
      we need to  produce a package containting three modules: Module ("A", "B"), Moudle ("B", "C") and Module ("C", "D")
      representing an installation package with the following dependency graph:
            A -> B -> C
'''

println "Explore parsing input to load data structure"

moduleSpec = "   A:   B"
moduleSpec = moduleSpec.trim().replaceAll(" +", " ")
moduleSpec = moduleSpec - ":"
assert moduleSpec == "A B"  // Module specification after cleanup and parsing

println "To create a module we will need to provide a constructor that takes two strings"

moduleSpec = moduleSpec.split()
constructorParams = "(${moduleSpec[0]}, ${moduleSpec[1]})"
assert constructorParams == "(A, B)"

println '''
   Now we can take a module spec string and use it to construct a module - need a test for that.
   We still need to explore parsing an array of module spec strings [<module>, <module>, ...]
'''

arrayOfModuleSpecs = ["A: B", "B: C"]
List <String> modules = new ArrayList <String>()
arrayOfModuleSpecs.each {
	modules << it
}
println modules
assert modules == ["A: B", "B: C"]




# Cobol2Java

This project reads one or more files with typical data of WORKING-STORAGE-SECTION of a Cobol source file and creates the  associated JavaBean classes.

## Getting Started
 * See the _Installing_ section.
 * In _confCobol2Java.properties_, put the correct names of Function and Program.
 * In directory _cobolSource_, put the files with data section as the exampel in download. 
 * Run program.
### Prerequisities
 * JDK 1.7+
 * Installed Ant
 * Defined the environment variabile _ANT_HOME_

### Installing

 * Download the source code of the project form Github in your workspace
 * In Eclipse, click rigth to directory _src_ and _test_ and choice _Build Path > Use a s a Source Folder_
 * Modify the references in the file _confCobol2Java.properties_ 
 * Put the COBOL source files into directory _cobolSource_ : the name of every files to parse must contains the string "input" 
 * Run the Ant file _build.xml_ with default target (_jar_): in this way Ant compiles the source code, runs the unit test.unit, creates the javadoc and makes the jar package, that you can use everywhere by command line.

## Running the tests

 * Run the Ant file _build.xml_ with target _test_

### Break down into end to end tests
 * TODO

### And coding style tests
 * TODO

## Deployment

 * Run the Ant file _build.xml_ with target _jar_

## Built With

 * [Eclipse](http://www.eclipse.org) - IDE
 * [JUnit](https://junit.org) - Unit test.unit
 * [ANT](http://ant.apache.org) - Automation of build process
 * [DILLINGER](http://dillinger.io ) - MarkDown editor online 

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us: it's a good guideline.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the repository.

## Authors

 * **Alessandro Puzielli** - *Initial work* - [alepuzio](https://github.com/alepuzio)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

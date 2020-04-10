# Cobol2Java

This project reads one or more COBOL source-code files with typical data of WORKING-STORAGE-SECTION and, then, it creates the  associated JavaBean classes.



## Status CI Integration
 
 I use [Travis](https://travis-ci.org/)
 [![Build Status](https://travis-ci.org/alepuzio/COBOL2JavaBean.svg?branch=master)](https://travis-ci.org/alepuzio/COBOL2JavaBean)

## Getting Started
 
 * See the _Installing_ section.
 * In _confCobol2Java.properties_, put the correct names of Function and Program.
 * In directory _cobolSource_, put the files with data section as the exampel in download. 
 * Run the program.

### Prerequisities
 
 * JDK 1.7+
 * Ant
 * Defined the environment variabile *ANT_HOME*

### Installing

 * CLone the repository with _git-clone_ (or download the source code of the project) from Github in your workspace
 * In Eclipse, click right to directory _src_ and _test_ and choice _Build Path > Use as a Source Folder_
 * Modify the references in the file _confCobol2Java.properties_ 
 * Put the COBOL source files into directory _cobolSource_ : the name of every files to parse must contain the string "input" 
 * Run the Ant file _build.xml_ with default target (_jar_): in this way Ant compiles the source code, runs the unit test.unit, creates the javadoc and makes the jar package, that you can use everywhere by command line.

## Running the tests

 * Run the Ant file _build.xml_ with target _test_;

### Break down into end to end tests
 * TODO

### And coding style tests
 * Please read the file [CONTRIBUTING.md](CONTRIBUTING.md)

## Deployment

 * Run the Ant file _build.xml_ with target _jar_;

## Built With

 * [Eclipse](http://www.eclipse.org) - IDE;
 * [JUnit](https://junit.org) - Unit testing framework;
 * [ANT](http://ant.apache.org) - Automation of build process;
 * [DILLINGER](http://dillinger.io ) - MarkDown editor online;

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us: it's a good guideline.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the repository.

## Authors

 * **Alessandro Puzielli** - *Initial work* - [alepuzio](https://github.com/alepuzio)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

* **PurpleBooth** - to publish an [excellent template](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2) of README that I used in this project;
* **Yegor256** - to write the post [Elegant READMEs](https://www.yegor256.com/2019/04/23/elegant-readme.html) about the README file and the [An Open Code Base Is Not Yet an Open Source Project](https://www.yegor256.com/2018/05/08/open-source-attributes.html) for the Open Source projects;

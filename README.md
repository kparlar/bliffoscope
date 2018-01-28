# Bliffoscope Test Project
This project is based on an application skeleton for a typical AngularJS web app and Spring Boot Project. This project is an example project for implementing the Bliffoscope Data Analysis Problem. For more information about the problem, please take a look to the Bliffoscope Data Analysis Problem Section:

Project has two parts, one front-end, one back-end. Front-end sends the files, target and test files, and expected threshold and also the targetType, (StarShip or Torpedo), and backend finds the targets in given test data and return the positions, and frontend display the targets in a modal dialog. 

Here are some screenshots from the projects
![Screen 1](img/screen_1.PNG?raw=true "Screen 1")
![Screen 2](img/screen_2.PNG?raw=true "Screen 2")
![Screen 3](img/screen_3.PNG?raw=true "Screen 3")

## How To Run
After git clone, you can directly run from your ide. Or you can follow these given below.

Firstly you have to start web application with this command  

```
npm start
```
under `/web/`  folder. This will start web application and you can hit directly  `http://localhost:8000/` 

To start springboot, inside the powerfiler folder run first mvn package this will build a jar called bliffoscope-0.0.1-SNAPSHOT.jar under target folder. Than you can run the application with java -jar powerfiler-0.0.1-SNAPSHOT.jar command.
when the service is on, it will host on port 8080. 
if you have any question, please send mail: <a href="mailto:korayparlar@hotmail.com">korayparlar@hotmail.com</a>


## Api End Points
For detailed api check Swagger please, swagger annotation is used in this project.
You can check it from this link, <a href="http://localhost:8080/swagger-ui.html#!/"> Swagger API </a>
Also here is the screenshot for swagger.

![Swagger](img/api.PNG?raw=true "Swagger")

## UnitTest

### Javascript Unit Test

16 js unit tests have been written, 


This project preconfigured with unit tests. These are written in [Jasmine][jasmine],
which we run with the [Karma][karma] test runner. There is a Karma configuration file to run them.

* The configuration is found at `karma.conf.js`.
* The unit tests are found next to the code they are testing and have an `*.spec.js` suffix (e.g.
  `view1.spec.js`).

The easiest way to run the unit tests is to use the supplied npm script:

```
npm test
```

This script will start the Karma test runner to execute the unit tests. Moreover, Karma will start
watching the source and test files for changes and then re-run the tests whenever any of them
changes.
This is the recommended strategy; if unit tests are being run every time when you save a file then
you receive instant feedback on any changes that break the expected code functionality.

You can also ask Karma to do a single run of the tests and then exit. This is useful if you want to
check that a particular version of the code is operating as expected. The project contains a
predefined script to do this:

```
npm run test-single-run
```
 
Also Karma-coverage and IstanbulJS is implemented to the project, but mainly karma-coverage has been run the output of the coverage results are under `coverage folder`

```
/web/app/coverage
```
Given Below screenshots of coverage results for JS unit-tests.

![JS Unit Test Console View](img/js_test_run.PNG?raw=true "JS Unit Test Console View")
![JS Unit Test Coverage](img/js_karrma_coverage_report.PNG?raw=true "JS Unit Test Coverage 1")
![JS Unit Test Coverage](img/js_karrma_coverage_report_1.PNG?raw=true "JS Unit Test Coverage 2")

### Java Unit Test

11 Unit Tests are written with %73 class coverage, %84 line coverage
this will show the intend, the coverage will be increased according to request.

here are the screenshots

![Unit Test Coverage](img/coverage_junit.PNG?raw=true "Unit Test Coverage")

Also resolved the sonarlint issues.

![Sonarlint](img/sonarlint.PNG?raw=true "Sonarlint")




## Postman Collections 
Postman Collections are in the postman folder. There is a screenshot below. But you have to comment the @CrossOrigin in TargetController as Postman requests are blocked if there is a cross origin is defined in the application.

![Postman Request Samples](img/postman_1.PNG?raw=true "Postman Request Samples")



## Bliffoscope Data Analysis problem
It's April 1, 2143. Your job is to save the world.
Well, a little world. Specifically the asteroid X8483-Z-32 that you and Alphonso Bliffageri are
stuck on. You've been stranded there ever since the evil Rejectos hit your spaceship with a
slime torpedo fired from one of their spaceships. Now you and Alphonso are trying to save
your little world from a concerted Rejectos attack.
The main problem you have is detecting the Rejectos spaceships and slime torpedos, because
they're protected with cloaking devices. Alphonso has invented an imaging anti-neutrino
system (which he has modestly named the “Bliffoscope”) that provides the only information
you have about their location, but it's not very good information. First, the Bliffoscope only
detects whether there are anti-neutrinos at any particular point on an image, not what their
intensity is. In other words, the data it provides is the equivalent of a black-and-white image.
Second, the data is very noisy – even if there are no targets in a particular area, some pixels
will be “on”, and if there is a target, some of its pixels will be “off”. For example, here's a 20 x
20 sample of raw data from the Bliffoscope (where each “+” is a pixel that is on):
![Problem Image 1](img/problem_image_1.PNG?raw=true "Problem Image 1")
Below is a sample image of a slime torpedo:
![Problem Image 2](img/problem_image_2.PNG?raw=true "Problem Image 2")
On the Bliffoscope data, we've highlighted the pixels that should be “on” for a slime torpedo.
You can see that more of the highlighted pixels are “on” in the highlighted area than in other
areas of the image. You must use this difference to locate the targets in the Bliffoscope data.
Along with this document you've received three files, all text files using “+” symbols to
represent “on” pixels and spaces to represent “off” pixels:
1. TestData.blf: a 100 x 100 swath of raw Bliffoscope data containing between four
and ten targets.
2. SlimeTorpedo.blf: a perfect image of a slime torpedo.
3. Starship.blf: a perfect image of a Rejectos starship.

Your task is to do the following:
1. Design and write a Java package that can analyze arbitrary-sized Bliffoscope images,
returning a list of targets found. Each target found should include the target type
found (starship or slime torpedo), the coordinates of the target on the Bliffoscope data,
and some indication of your confidence in the target detection.
2. Design and write test code that submits the test data to your package and prints the
results returned by your package.

[angularjs]: https://angularjs.org/
[bower]: http://bower.io/
[git]: https://git-scm.com/
[http-server]: https://github.com/indexzero/http-server
[jasmine]: https://jasmine.github.io/
[jdk]: https://wikipedia.org/wiki/Java_Development_Kit
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads
[karma]: https://karma-runner.github.io/
[local-app-url]: http://localhost:8000/index.html
[node]: https://nodejs.org/
[npm]: https://www.npmjs.org/
[protractor]: http://www.protractortest.org/
[selenium]: http://docs.seleniumhq.org/
[travis]: https://travis-ci.org/
[travis-docs]: https://docs.travis-ci.com/user/getting-started

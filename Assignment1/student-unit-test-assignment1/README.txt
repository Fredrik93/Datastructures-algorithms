This is the unit test for assignment 1.

To run the tests you need to do the following:

1. Extract the contents of the zip archive to a folder. They should include:
   * Array2Test.class
   * hamcrest-core-1.3.jar
   * junit-4.12.jar
   * unit-test.sh
   * This README file (funny bootstrap problem)

2. Place your implemented Array2.java in the same folder.

3. Run the test using the script (Mac and Linux users) in the terminal/cmd/power shell started in the same folder (without the `)
  `./unit-test.sh`
  If you are running a windows machine, compile with (without the `)
  `javac -cp . Array2.java`
  and execute with (without the ` but keep ')
  `java -cp '.;hamcrest-core-1.3.jar;junit-4.12.jar' org.junit.runner.JUnitCore Array2Test`


If you are having trouble executing the unit testing, consult the discussion forum on Canvas.


Windows users: 

Make sure that you can access the java binaries through the command prompt/powershell
https://javatutorial.net/set-java-home-windows-10

Installing jdk
https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-microsoft-windows-platforms.htm#JSJIG-GUID-2B9D2A17-176B-4BC8-AE2D-FD884161C958

To open the power shell in windows, hold shift and right click in the folder and pick 'Open power shell window here'



For more information on how you can integrate unit testing in IDE using MAVEN or Gradle
https://github.com/junit-team/junit4/wiki/Download-and-Install
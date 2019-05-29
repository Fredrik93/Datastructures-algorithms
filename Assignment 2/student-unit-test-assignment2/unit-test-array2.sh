#!/bin/sh

javac -cp . Array2.java 
java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore Array2Test

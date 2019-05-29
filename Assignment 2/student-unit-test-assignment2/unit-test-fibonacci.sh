#!/bin/sh

javac -cp . Fibonacci.java 
java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore FibonacciTest

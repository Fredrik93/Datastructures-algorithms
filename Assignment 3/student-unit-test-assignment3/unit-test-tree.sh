#!/bin/sh

javac -cp . Tree.java && \
java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore TreeTest

rm -f Tree.class Tree\$Node.class
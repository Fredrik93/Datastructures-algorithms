#!/bin/sh

javac -cp . SinglyLinkedList.java && \
java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore SinglyLinkedListTest

rm -f SinglyLinkedList.class SinglyLinkedList\$*.class
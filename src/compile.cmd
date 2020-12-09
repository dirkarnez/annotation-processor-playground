@echo off
SET PATH=%PATH%;C:\Softwares\BlueJ-windows-422\bluej\jdk\bin\
javac AnnotationProcessorExample.java
javac -processor AnnotationProcessorExample MyClassWithAnnotations.java Main.java
pause


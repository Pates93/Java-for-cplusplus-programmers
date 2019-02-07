@echo off

set BIN=%JAVA_HOME%\bin
set CP=./
set GUI=%1%

rem -------------------------------------------
"%BIN%\java" -classpath %CP% LookAndFeel %GUI%
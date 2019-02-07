@echo off

set BIN=%JAVA_HOME%\bin
set CP=./
set LANGUAGE=%1%
set COUNTRY=%2%

rem -------------------------------------------
@echo fr fr
@echo de de
@echo se se
java -classpath ./ I18NSample %LANGUAGE% %COUNTRY%
@echo off

echo starting

set JAVA_OPTS=%JAVA_OPTS% -server -Xms128m -Xmx128m -Xmn112m

"%JAVA_HOME%\bin\java" %JAVA_OPTS% -jar redis-cluster-info-monitor-1.0.jar --spring.profiles.active=dev

echo runnig...

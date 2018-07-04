@echo off

echo starting
set JAVA_OPTS=%JAVA_OPTS% -Xms128m -Xmx128m -Xmn112m

java %JAVA_OPTS% -jar redis-cluster-info-monitor-1.0.jar --spring.profiles.active=prod

echo runnig...
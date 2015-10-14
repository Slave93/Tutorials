javac -d bin -sourcepath src -cp lib/log4j-1.2.17.jar:properties src/kom/slavko/testJAR/App.java src/kom/slavko/testJAR/App2.java
java -cp lib/log4j-1.2.17.jar:properties:bin kom.slavko.testJAR.App

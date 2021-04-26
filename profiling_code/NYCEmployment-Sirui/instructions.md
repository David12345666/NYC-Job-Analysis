### Compile Java souce code

`java -version`

`yarn classpath`

``javac -classpath `yarn classpath` -d . CountRecsMapper.java``

``javac -classpath `yarn classpath` -d . CountRecsReducer.java``

``javac -classpath `yarn classpath`:. -d . CountRecs.java``

### Create Jar file

`jar -cvf maxTemp.jar *.class`

### Run the Jar file

`1`

### Put output into new csv file
`1`
### See the output
`1`

### remove file and directory (for later MapReduce output if needed)
`hdfs dfs -rm project/output/part-r-00000`
`hdfs dfs -rm -r -f project/output`

### Compile Java souce code

`java -version`

`yarn classpath`

``javac -classpath `yarn classpath` -d . CountRecsMapper.java``

``javac -classpath `yarn classpath` -d . CountRecsReducer.java``

``javac -classpath `yarn classpath`:. -d . CountRecs.java``

### Create Jar file

`jar -cvf countRecs.jar CountRecs*.class`

### Run the Jar file

`hadoop jar countRecs.jar CountRecs NYC_Jobs.csv /user/zw1718/project/output`

### See the output file
`hdfs dfs -cat project/output/part-m-00000`

### remove the output file (for later MapReduce output if needed)
`hdfs dfs -rm project/output/part-m-00000`

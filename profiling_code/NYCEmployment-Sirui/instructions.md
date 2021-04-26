### Compile Java souce code

`java -version`

`yarn classpath`

``javac -classpath `yarn classpath` -d . CountRecsMapper.java``

``javac -classpath `yarn classpath` -d . CountRecsReducer.java``

``javac -classpath `yarn classpath`:. -d . CountRecs.java``

### Create Jar file

`jar -cvf maxTemp.jar *.class`

### Run the Jar file

`hadoop jar maxTemp.jar CountRecs /user/sw4017/hw/input/Cleaned2.csv /user/sw4017/hw/output/`

### Put output into new csv file

`hdfs dfs -getmerge hw/output/ homework_ans.txt`

### See the output

`cat homework_ans.txt`


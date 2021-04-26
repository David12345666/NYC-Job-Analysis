## Data Profiling Job 1

### Compile Java souce code

`java -version`

`yarn classpath`

``javac -classpath `yarn classpath` -d . CountRecsMapper.java``

``javac -classpath `yarn classpath` -d . CountRecsReducer.java``

``javac -classpath `yarn classpath`:. -d . CountRecs.java``

### Create Jar file

`jar -cvf count.jar *.class`

### Run the Jar file

`hadoop jar count.jar CountRecs /user/sw4017/hw/input/Occupations.csv /user/sw4017/hw/output/`

### Put output into new csv file

`hdfs dfs -getmerge hw/output/ homework_ans.txt`

### See the output

`cat homework_ans.txt`

## Data Profiling Job 2

### Delete the output files and directory

`hdfs dfs -rm -r -f hw/output`

`rm homework_ans.txt`

### Run the Jar file

`hadoop jar count.jar CountRecs /user/sw4017/hw/input/Paid.csv /user/sw4017/hw/output/`

### Put output into new csv file

`hdfs dfs -getmerge hw/output/ homework_ans.txt`

### See the output

`cat homework_ans.txt`



## Data Cleaning Job 1

### Compile Java souce code

`java -version`

`yarn classpath`

``javac -classpath `yarn classpath` -d . CleanMapper.java``

``javac -classpath `yarn classpath` -d . CleanReducer.java``

``javac -classpath `yarn classpath`:. -d . Clean.java``

### Create Jar file

`jar -cvf clean1.jar *.class`


### Run the Jar file

`hadoop jar clean1.jar Clean /user/sw4017/hw/input/Occupations.csv /user/sw4017/hw/output/`

### Put output into new csv file

`hdfs dfs -getmerge hw/output/ Cleaned1.csv`

### Download file to local computer and convert the cleaned  data into csv format (type command in local computer terminal)

`scp sw4017@peel.hpc.nyu.edu:/home/sw4017/Cleaned1.csv C:\Users\sirui\Desktop` 

(Change file path)

### Upload the cleaned data to HDFS

`hdfs dfs -mkdir NYCEmployment`

`hdfs dfs -put Cleaned1.csv NYCEmployment`



## Data Cleaning Job 2

### Delete jar, class files and output from last data cleaning job

`rm *.class`

`rm *.jar`

`hdfs dfs -rm -r -f hw/output`

### Compile Java souce code

`java -version`

`yarn classpath`

``javac -classpath `yarn classpath` -d . Clean2Mapper.java``

``javac -classpath `yarn classpath` -d . CleanReducer.java``

``javac -classpath `yarn classpath`:. -d . Clean2.java``

### Create Jar file

`jar -cvf clean2.jar *.class`


### Run the Jar file

`hadoop jar clean2.jar Clean2 /user/sw4017/hw/input/Paid.csv /user/sw4017/hw/output/`

### Put output into new csv file

`hdfs dfs -getmerge hw/output/ Cleaned2.csv`

### Download file to local computer and convert the cleaned  data into csv format (type command in local computer terminal)

`scp sw4017@peel.hpc.nyu.edu:/home/sw4017/Cleaned2.csv C:\Users\sirui\Desktop` 

(Change file path)

### Upload the cleaned data to HDFS

`hdfs dfs -put Cleaned2.csv NYCEmployment`



## First Dataset Data Cleaning

### Make directory of input and output
`??`
### Put input file into the input directory
`??`

### Compile Java souce code
`java -version`

`yarn classpath`

``javac -classpath `yarn classpath` -d . CleanMapper.java``

``javac -classpath `yarn classpath` -d . CleanReducer.java``

``javac -classpath `yarn classpath`:. -d . Clean.java``

### Create Jar file

`jar -cvf maxTemp.jar *.class`


### Run the Jar file

`1`


### Put output into new csv file
`1`

### download file to local computer and convert the cleaned  data into csv format (type command in local computer terminal)
`scp  zw1718@peel.hpc.nyu.edu:/home/zw1718/part-m-00000  <~/Documents/>`(where ever you want to put it in your local computer)

### Upload the cleaned data to HDFS
`hdfs dfs -put Cleaned_data.csv project/input`



## Second Dataset Data Cleaning

### Remove class, jar, input and output directory from last Data Cleaning Job
`??`

### Make directory of input and output
`??`

### Put input file into the input directory
`??`

### Compile Java souce code
`java -version`

`yarn classpath`

``javac -classpath `yarn classpath` -d . Clean2Mapper.java``

``javac -classpath `yarn classpath` -d . CleanReducer.java``

``javac -classpath `yarn classpath`:. -d . Clean2.java``

### Create Jar file

`jar -cvf maxTemp.jar *.class`


### Run the Jar file

`1`


### Put output into new csv file
`1`

### download file to local computer and convert the cleaned  data into csv format (type command in local computer terminal)

`scp  zw1718@peel.hpc.nyu.edu:/home/zw1718/part-m-00000  <~/Documents/>`(where ever you want to put it in your local computer)

### Upload the cleaned data to HDFS
`hdfs dfs -put Cleaned_data.csv project/input`



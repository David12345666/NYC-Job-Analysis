### Compile Java souce code

`javac -classpath `yarn classpath` -d . CleanMapper.java`

`javac -classpath `yarn classpath` -d . CleanReducer.java`

`javac -classpath `yarn classpath`:. -d . Clean.java`


### Create Jar file

`jar -cvf clean.jar Clean*.class`


### Run the Jar file

`hadoop jar clean.jar Clean /user/zw1718/project/input/NYC_Jobs.csv /user/zw1718/project/output`


### See the output file
`hdfs dfs -cat project/output/part-m-00000`


### Copy the file to the home directory of Peel cluster

`hdfs dfs -copyToLocal project/output/part-m-00000 /home/zw1718`


### download file to local computer and convert the cleaned  data into csv format (type command in local computer terminal)

`scp  zw1718@peel.hpc.nyu.edu:/home/zw1718/part-m-00000  <~/Documents/>`(where ever you want to put it in your local computer)

rename `part-m-00000` as `cleaned_data.csv`


### Upload the cleaned data to HDFS
`hdfs dfs -put Cleaned_data.csv project/input`




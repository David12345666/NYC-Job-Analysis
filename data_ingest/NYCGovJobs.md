## -Before profiling and cleaning
### Delete existing input files and directory

`hdfs dfs -rm -r -f project`

### Create input directory

`hdfs dfs -mkdir project`

`hdfs dfs -mkdir project/input`

### put raw data into HDFS
`hdfs dfs -put NYC_Jobs.csv project/input`




## -After profiling and cleaning

### Delete existing input files and directory

`hdfs dfs -rm -r -f project`

### put cleaned data into HDFS 
`hdfs dfs -put cleaned_data.csv data`
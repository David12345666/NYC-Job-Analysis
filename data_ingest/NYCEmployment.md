## Data Cleaning Job 1

### Delete existing input files and directory

`hdfs dfs -rm -r -f hw`

### Create input directory

`hdfs dfs -mkdir hw`

`hdfs dfs -mkdir hw/input`

### Put csv files into input directory in HDFS

`hdfs dfs -put Occupations.csv hw/input`

## Data Cleaning Job 2

### Delete existing input files and directory

`hdfs dfs -rm -r -f hw`

### Create input directory

`hdfs dfs -mkdir hw`

`hdfs dfs -mkdir hw/input`

### Put csv files into input directory in HDFS

`hdfs dfs -put Paid.csv hw/input`
## Log into Spark Shell Client Mode and set up untilities
`spark-shell --deploy-mode client`

`import org.apache.spark.sql.types._`

`import org.apache.spark.sql._`

`import spark.implicits._`

## Load data as a dataframe

`val jobSchema = new StructType().add("jobID", IntegerType, nullable = true).add("agency", StringType, nullable = true).add("numOfPositions", IntegerType, nullable = true).add("civiServiceTitle", StringType, nullable = true).add("titleCodeNum", StringType, nullable = true).add("jobCategory", StringType, nullable = true).add("salaryFrom", DoubleType, nullable = true).add("salaryTo", DoubleType, nullable = true).add("month", StringType, nullable = true).add("year",StringType,nullable = true)`

`val job = spark.read.format("csv") .option("header", "true").schema(jobSchema). load("data/cleaned_data.csv")`


## Analysis
### Number of positions provided based on category:


`val positionsPerCategory = job.groupBy("jobCategory").sum("numOfPositions").as("sum_positions").sort("jobCategory").show(500,false)`




### Min & Max salary based on category:

`val minAndMaxPerCategory = job.filter(job("SalaryFrom") !==0) .groupBy("jobCategory").agg(min("salaryFrom").as("min_salary"),max("salaryTo").as("max_salary")).sort("jobCategory").show(500,false)`




### Number of positions based on agency:

`val positionsPerAgency = job.groupBy("agency").sum("numOfPositions").as("sum_positions").sort("agency").show(500,false)`



### Number of positions based on year:
`val positionsPerYear = job.groupBy("year").sum("numOfPositions").sort("year").show(500,false)`



### Highest (Job) Paid Each Year:
`val maxPerYear=job.groupBy("year").max("salaryTo").as("max_salary").sort("year").show(20,false)`

`job.where((col("year")==="2011")&& (col("salaryTo")===65485.0)).show(false)`
 matches( ".*2011.*")
val JoinedDS=job.join(maxPerYear,"jobCategory")






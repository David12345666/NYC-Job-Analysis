## Log into Spark Shell Client Mode

```sh
spark-shell --deploy-mode client
```

## Analysis

### Store data as RDD

```sh
val OccupationRDD1 = sc.textFile("Cleaned1.csv")
val SalaryRDD1 = sc.textFile("Cleaned2.csv")
```

### Number of workforce in each group and changes of every year:

```sh
var TempWorkforceSum = 0;
for (i <- 0 to 4) {
   val GroupRDD = OccupationRDD1.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(0).toInt == i)

   for(j <- 2013 to 2018) {

       val GroupYearRDD = GroupRDD.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(6).slice(1, 5).toInt == j)
       val WorkforceList = GroupYearRDD.map{x => x.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")}.map{x => (x(7).toInt)}
       val WorkforceSum = WorkforceList.collect().sum
       println("Group " + GroupRDD.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(1) + " Year " + j + " Workforce: " + WorkforceSum)
       if(TempWorkforceSum != 0) {
           println("Group " + i + " Year " + (j-1) + " to " + j + "            Workforce change: " + (WorkforceSum - TempWorkforceSum))
       }
       TempWorkforceSum = WorkforceSum
   }
}
```


### Number of workforce in each subgroup and changes of every year:

```sh
var TempWorkforceSum = 0
for (i <- 0 to 8) {
   val SubgroupRDD = OccupationRDD1.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(2).toInt == i)
   for(j <- 2013 to 2018) {
       val SubgroupYearRDD = SubgroupRDD.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(6).slice(1, 5).toInt == j)
       val WorkforceList = SubgroupYearRDD.map{x => x.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")}.map{x => (x(7).toInt)}
       val WorkforceSum = WorkforceList.collect().sum
       println("Subgroup " + i + " Year " + j + " Workforce: " + WorkforceSum)
       if(TempWorkforceSum != 0) {
           println("Subgroup " + SubgroupRDD.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(3) + " Year " + (j-1) + " to " + j + " Workforce change: " + (WorkforceSum - TempWorkforceSum))
       }
   TempWorkforceSum = WorkforceSum
   }
}
```

### Changes of number of workforce in each category every year:

```sh
var TempWorkforceSum = 0
for (i <- 0 to 24) {
   val OccupationRDD = OccupationRDD1.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(4).toInt == i)
   for(j <- 2013 to 2018) {
	    val OccupationYearRDD = OccupationRDD.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(6).slice(1, 5).toInt == j)
	    val WorkforceList = OccupationYearRDD.map{x => x.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")}.map{x => (x(7).toInt)}
       val WorkforceSum = WorkforceList.collect().sum
       if(TempWorkforceSum != 0) {
		    println("Occupation " + OccupationRDD.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(5) + " Year " + (j-1) + " to " + j + " Workforce change: " + (WorkforceSum - TempWorkforceSum))
       }
   TempWorkforceSum = WorkforceSum
   }
}
```


### Change of median salary of each occupation in each year 

```sh
var TempSalarySum = 0
for (i <- 0 to 35) {
   val SalaryRDD = SalaryRDD1.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(0).toInt == i)
   for(j <- 2013 to 2018) {
	    val SalaryYearRDD = SalaryRDD.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(2).slice(1, 5).toInt == j)
	    val SalaryList = SalaryYearRDD.map{x => x.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")}.map{x => (x(3).toInt)}
       val SalarySum = SalaryList.collect().sum
       if(TempSalarySum != 0) {
		    println("Occupation " + SalaryRDD.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(2) + " Year " + (j-1) + " to " + j + " Salary change: " + (SalarySum - TempSalarySum))
       }
   TempSalarySum = SalarySum
   }
}
```

### Highest Paid Job Each Year:
for(j <- 2013 to 2018) {
    val SalaryYearRDD = SalaryRDD1.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(2).slice(1, 5).toInt == j)
    val SalaryList = SalaryYearRDD.map{x => x.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")}.map{x => (x(3).toInt)}
    val SalarySum = SalaryList.collect().sum
    if(TempSalarySum != 0) {
        println("Occupation " + SalaryRDD.filter(line=>line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")(2) + " Year " + (j-1) + " to " + j + " Salary change: " + (SalarySum - TempSalarySum))
    }
}






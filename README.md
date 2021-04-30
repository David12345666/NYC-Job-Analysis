# NYC-Job-Analysis

## Team Members
Sirui Wang, Ziyi Wang




## Project Description
This project will analyze both the NYC occupations and NYC government job offerings to find the relative statistics such as job categories, number of positions offered and salary information. Moreover, by analyzing and comparing the two datasets, we can get some insights of the trends and patterns of the New York job market in recent years and how people should be prepared for entering the job market.


## Directories
`data_ingest`  : commands for data ingestion

`profiling_code` : data profiling code using MapReduce]

`etl_code` : data cleaning code using MapReduce

`ana_code` : the source code for the analytics

`screenshots`  : screenshots of running analytics

`data_src` : the data source and the cleaned data files

## implementation 
`data_ingest` --> `profiling_code` --> `etl_code` --> `ana_code`

each directory has separate instructions for implementing NYC Government Job analysis and NYC Employment analysis

the source data can be found inside data_src directory:

-NYC Government Job: `NYC_Jobs.csv`

-NYC Employment: `Occupations.csv` & `Paid.csv`
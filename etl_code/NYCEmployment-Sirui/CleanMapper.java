import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper extends 
Mapper<LongWritable,Text,Text,Text> {

    @Override
    public void map(LongWritable key, Text value, Context context)
    throws IOException, InterruptedException {
        
        String row = value.toString();
        String[] info = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        if (key.get() == 0){
            String fieldNames="jobID,agency,numOfPositions,civilServiceTitle,titleCodeNum,jobCategory,salaryFrom,salaryTo,month,year";
            context.write(new Text(fieldNames) ,new Text(""));
        }
        else if(info.length!=30){
            return;
        }
        else{
            String jobID=info[0];
            String agency=info[1];
            String numOfPositions=info[3];
            String civilServiceTitle=info[5];
            String titleCodeNum=info[7];
            String jobCategory=info[9];
            double salaryFrom=Double.parseDouble(info[12]);
            double salaryTo=Double.parseDouble(info[13]);
            String salaryFrequency=info[14];
            String[] timeFields=info[26].split("/");
            int month=Integer.parseInt(timeFields[0]);
            int year=Integer.parseInt(timeFields[2]);
            if(salaryFrequency.equals("Hourly")){
                salaryFrom=salaryFrom*8.8*21*12;
                salaryTo=salaryTo*8.8*21*12;
            }
            else if(salaryFrequency.equals("Daily")){
                salaryFrom=salaryFrom*21*12;
                salaryTo=salaryTo*21*12;
            }
            else if(salaryFrequency.equals("Monthly")){
                salaryFrom=salaryFrom*12;
                salaryTo=salaryTo*12;
            }
            String data=jobID+","+agency+","+numOfPositions+","+civilServiceTitle+","+
            titleCodeNum+","+jobCategory+","+salaryFrom+","+salaryTo+","+
            month+","+year;
            context.write(new Text(data),new Text(""));

        }
        
    }
}
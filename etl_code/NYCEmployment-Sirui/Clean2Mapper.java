
import java.io.IOException;

import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.NullWritable;

public class Clean2Mapper extends Mapper<LongWritable, Text, Text, NullWritable> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		if(line.startsWith("ID Occupation")) {
			return;
		}
		String[] data = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
		String newData = "";
		int[] list = new int[] {2, 6, 7, 8};
		int countList = 0;
		for(int i = 0; i < data.length; i++) {
			if(countList < list.length && i == list[countList]) {
				countList++;
				continue;
			}
			if(i == 5) {
				newData += data[i];
			}
			else {
				newData += data[i] + ",";
			}
			
		}
		Text outputKey = new Text(newData);
	    context.write(outputKey, NullWritable.get());
	}
}


import java.io.IOException;

import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.NullWritable;

public class CleanMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		if(line.startsWith("ID Group")) {
			return;
		}
		String[] data = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
		String newData = "";
		int[] list = new int[] {6, 8, 9, 12, 13, 14};
		int countList = 0;
		for(int i = 0; i < data.length; i++) {
			if(countList < list.length && i == list[countList]) {
				countList++;
				continue;
			}
			if(i == 11) {
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

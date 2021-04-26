
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.NullWritable;

public class Clean2 {
	public static void main(String[] args) throws Exception { 
		if (args.length != 2) {
			System.err.println("Usage: Clean cinput path> coutput path>");
			System.exit(-1);
		}
		Job job = new Job();
		job.setJarByClass(Clean2.class); 
		job.setJobName("Clean2");
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1])) ;
		job.setMapperClass(Clean2Mapper.class) ; 
		job.setReducerClass(CleanReducer.class);
		job.setOutputKeyClass(Text.class) ;
		job.setOutputValueClass(NullWritable.class);
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}

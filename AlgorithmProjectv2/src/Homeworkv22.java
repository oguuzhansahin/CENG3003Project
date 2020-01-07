import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

public class Homeworkv22 {
	
	static List<String> keys_for_firstFile = new LinkedList<>();
	static List<Integer>values_for_firstFile = new LinkedList<>();
	static Map<String,Integer> dict_for_firstFile = new HashMap<String,Integer>();
	
	
	static List<String> keys_for_secondFile = new LinkedList<>();
	static List<Integer> values_for_secondFile = new LinkedList<>();
	static Map<String,Integer> dict_for_secondFile = new HashMap<String,Integer>();
	
	static List<Integer> output = new LinkedList<>();
	
	
	
	public static void main(String args[]) throws FileNotFoundException, IOException {
		
		
		getHashFromFirstFile(new File("inputFile1.txt"));
		getHashFromSecondFile(new File("inputFile2.txt"));
		findMissingLineNumbers();
		writeOutputFile();
		
		
	
	
	}
	
	private static Map<String, Integer> getHashFromFirstFile(File firstFile) throws FileNotFoundException, IOException {
		//File firstFile   = new File(file);
        BufferedReader reader_for_firstFile  = null;
        
		BufferedReader bufferedReader = reader_for_firstFile  = new BufferedReader(new FileReader(firstFile));
        String line_for_firstFile  = reader_for_firstFile.readLine();
            
        while (line_for_firstFile!=null) {
            	
            	keys_for_firstFile.add(line_for_firstFile);
                line_for_firstFile = reader_for_firstFile.readLine();             
            }
            
            for(int i=0;i<keys_for_firstFile.size();i++) {
            	
            	values_for_firstFile.add(i);	            	      	
            }    
         
            for(int j =0;j<values_for_firstFile.size();j++) {
    	   
            	dict_for_firstFile.put(keys_for_firstFile.get(j), values_for_firstFile.get(j));
    	    	   
            }
            System.out.println(dict_for_firstFile);
            return dict_for_firstFile;
	}
	
	private static  Map<String, Integer> getHashFromSecondFile(File secondFile) throws FileNotFoundException, IOException {
		
		BufferedReader reader_for_secondFile = null;              
		reader_for_secondFile = new BufferedReader(new FileReader(secondFile));        
        String line_for_secondFile = reader_for_secondFile.readLine();
        
              
            
            while (line_for_secondFile!=null) {
             	
             	keys_for_secondFile.add(line_for_secondFile);
             	line_for_secondFile = reader_for_secondFile.readLine();             
             }
             
             for(int i=0;i<keys_for_secondFile.size();i++) {
             	
            	 values_for_secondFile.add(i);	            	      	
             }    



             for(int j =0;j<values_for_secondFile.size();j++) {
        	   
             	dict_for_secondFile.put(keys_for_secondFile.get(j), values_for_secondFile.get(j));
        	    	   
             }
             
             System.out.println(dict_for_secondFile);
             
             return dict_for_secondFile;
	}
	
	public static  List<Integer> findMissingLineNumbers() {
		
		MapDifference<String, Integer> mapDifference = Maps.difference(dict_for_firstFile, dict_for_secondFile);
		Map<String,Integer> left = mapDifference.entriesOnlyOnLeft();
		
		output.addAll(left.values());
		
		System.out.println("Missing string lines : " + output);
		
		
		
		
			
		 return output;
				
	}
	
	private static void writeOutputFile() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		FileOutputStream fos = new FileOutputStream("output.txt");
		 
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		
		String output_toString = output.toString();
		String output_substring = output_toString.substring(1, output_toString.length()-1);
		
		
	
		 
		osw.write(output_substring);
		
		
		
		osw.close();
	}
}



import java.io.BufferedReader;
import java.io.FileReader;


public class CsvReader {
	
	private String csvUrl;
	private BufferedReader reader;
	private final String CSV_SPLIT=",";
	
	public CsvReader(String csvUrl){
		this.csvUrl = csvUrl;
	}
	
	public void read(){
		String line = "";
		int numLinesLimit = 2;
		try{
			reader = new BufferedReader(new FileReader(csvUrl));
			for(int j=0; j<numLinesLimit; j++){
				if ((line = reader.readLine()) != null) {
					String values[] = line.split(CSV_SPLIT);
					for(int i=0; i<values.length; i++){
						//System.out.print(values[i] + " | ");
						System.out.printf("%-43s%3s", values[i], " | " );
					}
				}
				System.out.println();
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;


public class CsvReader {
	
	private final int NUM_CLASSES=3;
	private final int FIRST_CLASS_VALUE=1;
	private final int SECOND_CLASS_VALUE=2;
	private final int THIRD_CLASS_VALUE=3;
	private String csvUrl;
	private BufferedReader reader;
	private final String CSV_SPLIT=",";
	private ArrayList<Row> set;
	
	public CsvReader(String csvUrl){
		this.csvUrl = csvUrl;
		this.set = new ArrayList<Row>();
	}
	
	public void readFile(){
		String line = "";
		try{
			reader = new BufferedReader(new FileReader(csvUrl));
			line = reader.readLine();
			while((line = reader.readLine()) != null){
				String values[] = line.split(CSV_SPLIT);
				int accidentSeverity =Integer.parseInt(values[Row.getAccidentSeverityIndex()]);
				int lightingConditions = Integer.parseInt(values[Row.getLightingConditionsIndex()]);
				Row row = new Row(accidentSeverity, lightingConditions);
				set.add(row);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private ArrayList<Integer> getNumClassesInstances(){
		int numFirstClassInstances =0;
		int numSecondClassInstances =0;
		int numThirdClassInstances =0;
		for(Row row: set){
			if(row.getAccidentSeverity() == FIRST_CLASS_VALUE){
				numFirstClassInstances++;
			}
			else if(row.getAccidentSeverity() == SECOND_CLASS_VALUE){
				numSecondClassInstances++;
			}
			else if(row.getAccidentSeverity() == THIRD_CLASS_VALUE){
				numThirdClassInstances++;
			}
		}
		ArrayList<Integer> classInstances = new ArrayList<Integer>();
		classInstances.add(numFirstClassInstances);
		classInstances.add(numSecondClassInstances);
		classInstances.add(numThirdClassInstances);
		return classInstances;
	}

	public double eStart(){
		ArrayList<Integer> array = getNumClassesInstances();
		return entropy(set.size(), array);
	}

	private double entropy( int numInstances, ArrayList<Integer> array){
		double e = 0.0;
		for(int elementInstance: array){
			e = e -elementOfE(numInstances, elementInstance);
		}
		return e;
	}

	private double elementOfE(int numInstances, int numClassInstances){
			double p = (double) numClassInstances/numInstances;
			return p * logOfBase(2, p);
	}

	private double logOfBase(int base, double num) {
		return Math.log(num) / Math.log(base);
	}
}

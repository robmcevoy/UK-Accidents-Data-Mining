import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;


<<<<<<< HEAD:src/DataMiner.java
public class DataMiner {
	/*
=======
public class CsvReader {
	
	private final int NUM_CLASSES=3;
	private final int FIRST_CLASS_VALUE=1;
	private final int SECOND_CLASS_VALUE=2;
	private final int THIRD_CLASS_VALUE=3;
>>>>>>> parent of 4feed63... Info gain for Lighting Conditions:src/CsvReader.java
	private String csvUrl;
	private BufferedReader reader;
	private final String CSV_SPLIT=",";
	private TreeBuilder builder;
	
	public DataMiner(String csvUrl){
		this.csvUrl = csvUrl;
		this.builder = new TreeBuilder();
	}
	
	//read csv file and create an arraylist of rows
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
<<<<<<< HEAD:src/DataMiner.java
		
	// find the number of class instances in a set
	private ArrayList<Integer> getNumClassesInstances(ArrayList<Row> set){
		int numFirstClassInstances = 0;
		int numSecondClassInstances = 0;
		int numThirdClassInstances = 0;
		Attribute attribute;
=======
	
	private ArrayList<Integer> getNumClassesInstances(){
		int numFirstClassInstances =0;
		int numSecondClassInstances =0;
		int numThirdClassInstances =0;
>>>>>>> parent of 4feed63... Info gain for Lighting Conditions:src/CsvReader.java
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
<<<<<<< HEAD:src/DataMiner.java
	
	// calculate eNew of splitting on attribute
	public double eNew(){
	
		ArrayList<ArrayList<Row>> subsets = getSubsets(this.set, this.set.get(0).getSplitAttribute());
		int count = 0;
		double enew = 0.0;
		double entropy;
		for(ArrayList<Row> subset : subsets){
			count++;
			System.out.println("subset" + count + " size: " + subset.size());
			entropy = entropy(subset.size(), getNumClassesInstances(subset));
			System.out.println(entropy);
			enew = enew + (((double)subset.size() /set.size()) * entropy);
		}
		return enew;
	}
	
	
	public double informationGain(){
		return eStart() - eNew();
	}
	
	// calculate eStart of current set
=======

>>>>>>> parent of 4feed63... Info gain for Lighting Conditions:src/CsvReader.java
	public double eStart(){
		ArrayList<Integer> array = getNumClassesInstances();
		return entropy(set.size(), array);
	}
<<<<<<< HEAD:src/DataMiner.java
	
	// takes in a set of rows
	// returns an array of subsets split on attribute values
	public ArrayList<ArrayList<Row>> getSubsets(ArrayList<Row> set, Attribute attribute){	
		ArrayList<ArrayList<Row>> subsets = new ArrayList<ArrayList<Row>>();
		//create subsets
		for(int i=0; i<attribute.getNumPossibleValues(); i++){
			ArrayList<Row> subset = new ArrayList<Row>();
			subsets.add(subset);
		}
		for(Row row: set){
			int index =row.getSplitAttribute().getValueIndex(row.getSplitAttribute().getValue());
			for(ArrayList<Row> subset: subsets){
				if(subsets.indexOf(subset) == index){
					subset.add(row);
				}
			}
		}
		return subsets;
	}
	*/
}
=======

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
>>>>>>> parent of 4feed63... Info gain for Lighting Conditions:src/CsvReader.java

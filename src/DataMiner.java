import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class DataMiner {
	/*
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
				Row row = new Row();
				String values[] = line.split(CSV_SPLIT);
				for(int i=0; i<values.length; i++){
					try{
						row.updateRow(i, Integer.parseInt(values[i]));
					}
					catch(java.lang.NumberFormatException e){}
				}
				set.add(row);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		
	// find the number of class instances in a set
	private ArrayList<Integer> getNumClassesInstances(ArrayList<Row> set){
		int numFirstClassInstances = 0;
		int numSecondClassInstances = 0;
		int numThirdClassInstances = 0;
		Attribute attribute;
		for(Row row: set){
			attribute = row.getClassAttribute();
			int index = attribute.getCurrentValueIndex();
			if(index != -1){
				if(index == 0){
					numFirstClassInstances++;
				}
				else if(index == 1){
					numSecondClassInstances++;
				}
				else if(index == 2){
					numThirdClassInstances++;
				}
			}
		}
		ArrayList<Integer> classInstances = new ArrayList<Integer>();
		classInstances.add(numFirstClassInstances);
		classInstances.add(numSecondClassInstances);
		classInstances.add(numThirdClassInstances);
		return classInstances;
	}
	
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
	public double eStart(){
		ArrayList<Integer> array = getNumClassesInstances(this.set);
		return entropy(set.size(), array);
	}
	
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class TreeBuilder {
	
	private int nonClassAttributesCount;
	// not treated like other attributes because it's the class attribute
	private Attribute accidentSeverity;
	private Attribute lightingConditions;
	private ArrayList<Attribute> allAttributes;
	private ArrayList<Attribute> nonClassAttributes;
	private ArrayList<Row> set;
	private final String CSV_SPLIT=",";
		
	private final int AC_NUM_POSSIBLE_VALUES=3;
	private final int ACCIDENT_SEVERITY_INDEX = 6;
	private final int[] AC__POSSIBLE_VALUES = {1, 2, 3};
	private final int LIGHTING_CONDITIONS_INDEX = 24;
	private final int LC_NUM_POSSIBLE_VALUES=3;
	private final int[] LC__POSSIBLE_VALUES = {1, 4, 7};
	
	public TreeBuilder(){
		nonClassAttributesCount = 0;
		set = new ArrayList<Row>();
		allAttributes = new ArrayList<Attribute>();
		nonClassAttributes = new ArrayList<Attribute>();
		accidentSeverity = new Attribute(ACCIDENT_SEVERITY_INDEX, AC_NUM_POSSIBLE_VALUES, AC__POSSIBLE_VALUES);
		lightingConditions = new Attribute(LIGHTING_CONDITIONS_INDEX, LC_NUM_POSSIBLE_VALUES, LC__POSSIBLE_VALUES);
		allAttributes.add(accidentSeverity);
		allAttributes.add(lightingConditions);
		nonClassAttributes.add(lightingConditions);
	}
	
	public Attribute getSplitAttribute(){
		if( nonClassAttributesCount < nonClassAttributes.size()){
			Attribute a = nonClassAttributes.get(nonClassAttributesCount);
			return a;
		}
		return null;
	}
	
	public void nextAttribute(){
		nonClassAttributesCount++;
	}
	
	/************** Function with bug *************/
	public void readTraningSetCsv(String csvUrl){
		String line = "";
		try{
			BufferedReader reader = new BufferedReader(new FileReader(csvUrl));
			line = reader.readLine();
			while((line = reader.readLine()) != null){
				Row row = new Row(this.allAttributes);
				String values[] = line.split(CSV_SPLIT);
				for(int i=0; i<values.length; i++){
					try{
						row.updateAttributeValues(i, Integer.parseInt(values[i]));
					}
					catch(java.lang.NumberFormatException e){}
				}
				System.out.println("before add");
				for(Row tmp: set){
					System.out.println(tmp.getAttributeWithValue(accidentSeverity).getValue());
				}
				System.out.println();
				set.add(row);
				System.out.println("after add");
				for(Row tmp: set){
					System.out.println(tmp.getAttributeWithValue(accidentSeverity).getValue());
				}
				System.out.println();
			}
			reader.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private ArrayList<Integer> getNumClassesInstances(ArrayList<Row> set){
		int numFirstClassInstances = 0;
		int numSecondClassInstances = 0;
		int numThirdClassInstances = 0;
		Attribute attribute;
		for(Row row: set){
			attribute = row.getAttributeWithValue(accidentSeverity);
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
	
	// calculate eStart of current set
	public double eStart(){
		ArrayList<Integer> array = getNumClassesInstances(set);
		return entropy(set.size(), array);
	}
	
	private double entropy(int numInstances, ArrayList<Integer> arrayClassOccurances){
		double e = 0.0;
		for(int elementInstance: arrayClassOccurances){
			if(elementInstance > 0){
				e = e -elementOfE(numInstances, elementInstance);
			}
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

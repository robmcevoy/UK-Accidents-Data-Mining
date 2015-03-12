<<<<<<< HEAD
import java.util.ArrayList;

// A row is made up of attributes
public class Row {

	private ArrayList<Attribute> attributes;
	
	public Row(ArrayList<Attribute> attributes){
		this.attributes = new ArrayList<Attribute>(attributes);
	}
	
	public void updateAttributeValues(int index, int value){
		for(Attribute attribute: attributes){
			if(index == attribute.getIndex()){
				attribute.setValue(value);
			}
		}
	}

	public Attribute getAttributeWithValue(Attribute attribute){
		for(Attribute tmp: attributes){
			if(tmp.getIndex() == attribute.getIndex()){
				return tmp;
			}
		}
		return null;
	}

=======

public class Row {
	
	private int accidentSeverity;
	private int lightConditions;
	private static final int ACCIDENT_SEVERITY_INDEX = 6;
	private static final int LIGHTING_CONDITIONS_INDEX = 24;
	
	Row(int accidentSeverity, int lightConditions){
		this.accidentSeverity = accidentSeverity;
		this.lightConditions = lightConditions;
	}
	
	public int getAccidentSeverity(){
		return accidentSeverity;
	}
	
	public int getLightConditions(){
		return lightConditions;
	}
	
	public static int getAccidentSeverityIndex(){
		return ACCIDENT_SEVERITY_INDEX;
	}
	
	public static int getLightingConditionsIndex(){
		return LIGHTING_CONDITIONS_INDEX;
	}
	
>>>>>>> parent of 4feed63... Info gain for Lighting Conditions
}

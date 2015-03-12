import java.util.ArrayList;


public class Row {

	private Attribute accidentSeverity;
	private Attribute lightingConditions;
	private ArrayList<Attribute> attributes;
	
	private final int AC_NUM_POSSIBLE_VALUES=3;
	private final int ACCIDENT_SEVERITY_INDEX = 6;
	private final int[] AC__POSSIBLE_VALUES = {1, 2, 3};
	private final int LIGHTING_CONDITIONS_INDEX = 24;
	private final int LC_NUM_POSSIBLE_VALUES=3;
	private final int[] LC__POSSIBLE_VALUES = {1, 4, 7};
	
	public Row(){
		attributes = new ArrayList<Attribute>();
		accidentSeverity = new Attribute(ACCIDENT_SEVERITY_INDEX, AC_NUM_POSSIBLE_VALUES, AC__POSSIBLE_VALUES);
		lightingConditions = new Attribute(LIGHTING_CONDITIONS_INDEX, LC_NUM_POSSIBLE_VALUES, LC__POSSIBLE_VALUES);
		attributes.add(accidentSeverity);
		attributes.add(lightingConditions);
	}
	
	public void updateRow(int index, int value){
		for(Attribute attribute: attributes){
			if(index == attribute.getIndex()){
				attribute.setValue(value);
			}
		}
	}
	
	public Attribute getClassAttribute(){
		return accidentSeverity;
	}
	
	public Attribute getSplitAttribute(){
		return lightingConditions;
	}
}
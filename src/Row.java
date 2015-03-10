
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
	
}

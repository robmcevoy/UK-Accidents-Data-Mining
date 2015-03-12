public class Attribute {
	
	private int index;
	private int numPossibleValues;
	private int[] possibleValues;
	private int value;
	
	public Attribute(int index, int numPossibleValues, int[] possibleValues){
		this.index = index;
		this.numPossibleValues = numPossibleValues;
		this.possibleValues = possibleValues;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}

	public int getIndex(){
		return index;
	}

	public int getCurrentValueIndex() {
		for(int i=0; i<numPossibleValues; i++){
			if(value == possibleValues[i]){
				return i;
			}
		}
		return -1;
	}
	
	public int getValueIndex(int testValue) {
		for(int i=0; i<numPossibleValues; i++){
			if(testValue == possibleValues[i]){
				return i;
			}
		}
		return -1;
	}
	
	public int getNumPossibleValues(){
		return numPossibleValues;
	}
}
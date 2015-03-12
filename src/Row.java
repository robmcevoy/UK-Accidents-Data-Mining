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

}

public class Test{
	public static void main(String [] args){
		
		/*
		DataMiner reader = new DataMiner("data/small.csv");
		reader.readFile();
		System.out.println("Info Gain: " + reader.informationGain());
		*/
		
		TreeBuilder builder = new TreeBuilder();
		builder.readTraningSetCsv("data/small.csv");
		System.out.println(builder.eStart());
	}
}

public class Test{
	public static void main(String [] args){
		
<<<<<<< HEAD
		/*
		DataMiner reader = new DataMiner("data/small.csv");
		reader.readFile();
		System.out.println("Info Gain: " + reader.informationGain());
		*/
		
		TreeBuilder builder = new TreeBuilder();
		builder.readTraningSetCsv("data/small.csv");
		//System.out.println(builder.eStart());
=======
		CsvReader reader = new CsvReader("data/DfTRoadSafety_Accidents_2005.csv");
		reader.readFile();
		System.out.println("Estart: " +reader.eStart());
>>>>>>> parent of 4feed63... Info gain for Lighting Conditions
	}
}

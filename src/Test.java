public class Test{
	public static void main(String [] args){
		
		CsvReader reader = new CsvReader("data/DfTRoadSafety_Accidents_2005.csv");
		reader.readFile();
		System.out.println("Estart: " +reader.eStart());
	}
}

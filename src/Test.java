public class Test{
	public static void main(String [] args){
		
		CsvReader reader = new CsvReader("data/small.csv");
		reader.readFile();
		
		System.out.println("Estart: " +reader.eStart());
		System.out.println("Enew: " + reader.eNew());
		System.out.println("Info Gain: " + reader.informationGain());
	}
}
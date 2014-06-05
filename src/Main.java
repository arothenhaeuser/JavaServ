
public class Main {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		Bundestag bundestag = new Bundestag();
		
		while (bundestag.hasNext()) {
			System.out.println(bundestag.getNext());
			System.out.println();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start + " Milliseconds");
	}
}

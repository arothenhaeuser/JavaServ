
public class Abgeordneter {
	   String name;
	   String partei;
	   String titel;
	   String herkunft;
	   String bundesland;
	   String ausbildung;
	   String bild;
	   public Abgeordneter() {
		   this.name = null;
		   this.partei = null;
		   this.titel = null;
		   this.herkunft = null;
		   this.bundesland = null;
		   this.ausbildung = null;
		   this.bild = null;
	   }
	   public String toString() {
		   String s = "Name: " + name + "\n" +
						   "Partei: " + partei + "\n" +
						   "Titel: " + titel + "\n" +
						   "Herkunft: " + herkunft + "\n" +
						   "Bundesland: " + bundesland + "\n" +
						   "Ausbildung: " + ausbildung + "\n" +
						   "Bild: " + bild;
		   return s;
	   }
	public void setName(String name) {
		this.name = name;
	}
	public void setPartei(String partei) {
		this.partei = partei;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public void setHerkunft(String herkunft) {
		this.herkunft = herkunft;
	}
	public void setBundesland(String bundesland) {
		this.bundesland = bundesland;
	}
	public void setAusbildung(String ausbildung) {
		this.ausbildung = ausbildung;
	}
	public void setBild(String bild) {
		this.bild = bild;
	}
}
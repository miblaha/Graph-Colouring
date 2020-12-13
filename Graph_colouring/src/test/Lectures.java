package test;

import java.util.LinkedList;

// Objekt Lecturec, s parametry a pomocn�mi funkcemi.
public class Lectures implements Comparable<Lectures> {

	public int ID;
	public String Name;
	public LinkedList<Integer> Clashes = new LinkedList<Integer>();

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public LinkedList<Integer> getClashes() {
		return Clashes;
	}

	public void setClashes(LinkedList<Integer> clashes) {
		Clashes = clashes;
	}

	// Funkce pro porovn�n� po�tu hran jednotliv�ch vrchol�.
	@Override
	public int compareTo(Lectures arg0) {
		Integer tmp = arg0.Clashes.size();
		Integer tmp2 = this.Clashes.size();

		return tmp2.compareTo(tmp);
	}

}

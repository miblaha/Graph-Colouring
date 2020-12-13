package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BarveniGrafu {

	public static void main(String args[]) {
		List<Lectures> lectures = new ArrayList<Lectures>();

		Lectures l1 = new Lectures();
		l1.ID = 0;
		l1.Name = "Theoretical informatics";
		l1.Clashes.add(1);
		l1.Clashes.add(2);
		l1.Clashes.add(3);
		lectures.add(l1);

		Lectures l2 = new Lectures();
		l2.ID = 1;
		l2.Name = "ICT Security";
		l2.Clashes.add(0);
		l2.Clashes.add(3);
		l2.Clashes.add(4);
		lectures.add(l2);

		Lectures l3 = new Lectures();
		l3.ID = 2;
		l3.Name = "Digital Signal Processing";
		l3.Clashes.add(0);
		l3.Clashes.add(3);
		l3.Clashes.add(5);
		l3.Clashes.add(6);
		lectures.add(l3);

		Lectures l4 = new Lectures();
		l4.ID = 3;
		l4.Name = "Analog Technology";
		l4.Clashes.add(0);
		l4.Clashes.add(1);
		l4.Clashes.add(2);
		l4.Clashes.add(4);
		l4.Clashes.add(5);
		l4.Clashes.add(6);
		l4.Clashes.add(8);
		lectures.add(l4);

		Lectures l5 = new Lectures();
		l5.ID = 4;
		l5.Name = "CISCO Academy";
		l5.Clashes.add(1);
		l5.Clashes.add(3);
		l5.Clashes.add(6);
		l5.Clashes.add(7);
		l5.Clashes.add(8);
		lectures.add(l5);

		Lectures l6 = new Lectures();
		l6.ID = 5;
		l6.Name = "Communication technology";
		l6.Clashes.add(2);
		l6.Clashes.add(3);
		l6.Clashes.add(8);
		lectures.add(l6);

		Lectures l7 = new Lectures();
		l7.ID = 6;
		l7.Name = "Modern Communication Technique";
		l7.Clashes.add(2);
		l7.Clashes.add(3);
		l7.Clashes.add(4);
		l7.Clashes.add(5);
		lectures.add(l7);

		Lectures l8 = new Lectures();
		l8.ID = 7;
		l8.Name = "Signals and Systems Analysis";
		l8.Clashes.add(4);
		lectures.add(l8);

		Lectures l9 = new Lectures();
		l9.ID = 8;
		l9.Name = "Speech Processing";
		l9.Clashes.add(3);
		l9.Clashes.add(4);
		lectures.add(l9);

		int numOfLectures = lectures.size();
		Graph g = new Graph(numOfLectures);
		Collections.sort(lectures, Collections.reverseOrder());

		for (Lectures x : lectures) {
			 System.out.println(x.getID());
			for (int y : x.getClashes()) {
				g.addEdge(x.getID(), y);
				// System.out.println(x.getID()+","+y);
			}
		}
		g.greedyColoring();

	}
}

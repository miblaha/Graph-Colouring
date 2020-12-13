package test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int Ver; // Poèet vrcholù
	private LinkedList<Integer> adjLst[]; // List pro sousedící vrcholy 

	// Constructor
	Graph(int ver) {
		Ver = ver;
		adjLst = new LinkedList[ver];
		for (int i = 0; i < ver; ++i)
			adjLst[i] = new LinkedList();
	}

	// Funkce pro øidání hran do grafu, ochrana proti dvojtýmu pøidání
	// Vznikne neorientovaný graf
	void addEdge(int x, int y) {
		if(!adjLst[x].contains(y) || !adjLst[y].contains(x)) {
			adjLst[x].add(y);
			adjLst[y].add(x); 
		}
	}

	// Pøiøazení barev  greedy algoritmem, zaèíná od 0, díky našemu øazení zaèíná od vrcholu s nejvíce hranami
	void greedyColoring() {
		int red = 0;
		int blue = 0;
		int green = 0;
		int yel = 0;
		int un = 0;
		int result[] = new int[Ver];

		// Inicializace vrcholù (nepøiøazené)
		Arrays.fill(result, -1);

		// Pøiøazení první barvy vrcholu 0
		result[0] = 0;

		// Doèasné pole, kde se ukládají dostupné barvy. Hodnota False znamená, 
		// že barva byla pøidìlena sousednímu vrcholu
		
		boolean avlClr[] = new boolean[Ver];

		// Celé pole má hodntu True, to znamená že jsou dosupné všechny barvy.
		Arrays.fill(avlClr, true);

		// Pøiøazení barev zbytku vrcholù
		for (int u = 1; u < Ver; u++) {
			// Projde všechny sousedicí vrcholy a oznaèí je jako nedostupné.
			Iterator<Integer> it = adjLst[u].iterator();
			while (it.hasNext()) {
				int i = it.next();
				if (result[i] != -1)
					avlClr[result[i]] = false;
			}

			// Najdeprvní dostupnou barvu
			int cr;
			
			for (cr = 0; cr < Ver; cr++) {
				if (avlClr[cr])
					break;
			}
			// Øadící podmínky, rozøadí a poèítá jednotlivé barvy.
			if (cr == 0) {
				red++;
				result[u] = cr; // Pøiøadí nalezenou barvu
			}
			else if (cr == 1 ) {
				blue++;
				result[u] = cr; // Pøiøadí nalezenou barvu
			}
			else if (cr == 2) {
				green++;
				result[u] = cr; // Pøiøadí nalezenou barvu
			}
			else if (cr == 3) {
				yel++;
				result[u] = cr; // Pøiøadí nalezenou barvu
			}
			
			else {
				un++;
				result[u] = cr; // Pøiøadí nalezenou barvu, 
								// toto je záchytná podmínka, která nastane pokud je pøekroèen maximální poèet barev.
			}
			

			// Vrátí hodnoty pole na true, umožní další iteraci.
			Arrays.fill(avlClr, true);
		}

		// Vytiskne výsledky
		for (int u = 0; u < Ver; u++)
			System.out.println("Vertex " + u + " --->  Color " + result[u]);
		System.out.println(red +1);
		System.out.println(blue);
		System.out.println(green);
		System.out.println(yel);
		System.out.println(un);

	}
}

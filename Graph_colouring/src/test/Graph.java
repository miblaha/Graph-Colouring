package test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int Ver; // Po�et vrchol�
	private LinkedList<Integer> adjLst[]; // List pro soused�c� vrcholy 

	// Constructor
	Graph(int ver) {
		Ver = ver;
		adjLst = new LinkedList[ver];
		for (int i = 0; i < ver; ++i)
			adjLst[i] = new LinkedList();
	}

	// Funkce pro �id�n� hran do grafu, ochrana proti dvojt�mu p�id�n�
	// Vznikne neorientovan� graf
	void addEdge(int x, int y) {
		if(!adjLst[x].contains(y) || !adjLst[y].contains(x)) {
			adjLst[x].add(y);
			adjLst[y].add(x); 
		}
	}

	// P�i�azen� barev  greedy algoritmem, za��n� od 0, d�ky na�emu �azen� za��n� od vrcholu s nejv�ce hranami
	void greedyColoring() {
		int red = 0;
		int blue = 0;
		int green = 0;
		int yel = 0;
		int un = 0;
		int result[] = new int[Ver];

		// Inicializace vrchol� (nep�i�azen�)
		Arrays.fill(result, -1);

		// P�i�azen� prvn� barvy vrcholu 0
		result[0] = 0;

		// Do�asn� pole, kde se ukl�daj� dostupn� barvy. Hodnota False znamen�, 
		// �e barva byla p�id�lena sousedn�mu vrcholu
		
		boolean avlClr[] = new boolean[Ver];

		// Cel� pole m� hodntu True, to znamen� �e jsou dosupn� v�echny barvy.
		Arrays.fill(avlClr, true);

		// P�i�azen� barev zbytku vrchol�
		for (int u = 1; u < Ver; u++) {
			// Projde v�echny sousedic� vrcholy a ozna�� je jako nedostupn�.
			Iterator<Integer> it = adjLst[u].iterator();
			while (it.hasNext()) {
				int i = it.next();
				if (result[i] != -1)
					avlClr[result[i]] = false;
			}

			// Najdeprvn� dostupnou barvu
			int cr;
			
			for (cr = 0; cr < Ver; cr++) {
				if (avlClr[cr])
					break;
			}
			// �ad�c� podm�nky, roz�ad� a po��t� jednotliv� barvy.
			if (cr == 0) {
				red++;
				result[u] = cr; // P�i�ad� nalezenou barvu
			}
			else if (cr == 1 ) {
				blue++;
				result[u] = cr; // P�i�ad� nalezenou barvu
			}
			else if (cr == 2) {
				green++;
				result[u] = cr; // P�i�ad� nalezenou barvu
			}
			else if (cr == 3) {
				yel++;
				result[u] = cr; // P�i�ad� nalezenou barvu
			}
			
			else {
				un++;
				result[u] = cr; // P�i�ad� nalezenou barvu, 
								// toto je z�chytn� podm�nka, kter� nastane pokud je p�ekro�en maxim�ln� po�et barev.
			}
			

			// Vr�t� hodnoty pole na true, umo�n� dal�� iteraci.
			Arrays.fill(avlClr, true);
		}

		// Vytiskne v�sledky
		for (int u = 0; u < Ver; u++)
			System.out.println("Vertex " + u + " --->  Color " + result[u]);
		System.out.println(red +1);
		System.out.println(blue);
		System.out.println(green);
		System.out.println(yel);
		System.out.println(un);

	}
}

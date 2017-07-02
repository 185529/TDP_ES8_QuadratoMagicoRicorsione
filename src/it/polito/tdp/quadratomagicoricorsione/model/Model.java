package it.polito.tdp.quadratomagicoricorsione.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	List<Square> solutions = null;

	public List<Square> findMagicSquares(int dim) {
		
		solutions = new ArrayList<Square>();
		
		// creo oggetto Square
		
		Square square = new Square(dim);
		
		// chiamo funzione ricorsiva
		
		int step = 0;
		
		recursive(square, step);
		
		// ritorno le soluzioni trovate
		
		return solutions;
	}
	
	private void recursive(Square square, int step){
		
		// A -- condizione di terminazione
		
		if(step>=square.getN2()){
			// valuto soluzione
			
			if(square.chackMagicConst()){
				solutions.add(square);
			}
			
			return;
		}
		
		for(int i=1; i<=square.getN2(); i++){
			
			
			if(!square.contains(i)){
				
				// B -- aggiungo numero e genero nuovo candidato
			
				square.add(i);
			
				// C -- discesa ricorsiva
			
				recursive(square, step+1);
			
				// D -- rimuovo numero

				square.remove(step);
				
			}
			
		}
		
	}

}

package it.polito.tdp.quadratomagicoricorsione.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model model = new Model();
		
		Long start = System.nanoTime();
		
		List<Square> solutions = model.findMagicSquares(3);
		
		Long stop = System.nanoTime();
		
		if(solutions!=null && solutions.size()>0){
			
			System.out.println("Trovata almeno una soluzione in "+(stop-start)/1e9+" secondi.\n");
			
			for(Square s : solutions){
				System.out.println(s.toString());
			}
			
		}else{
			
			System.out.println("Nessuna soluzione trovata.\n");
			
		}

	}

}

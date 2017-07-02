package it.polito.tdp.quadratomagicoricorsione.model;

import java.util.ArrayList;
import java.util.List;

public class Square {
	
	private int N;
	private int N2;
	int magicConst;
	private List<Integer> griglia;
	
	/**
	 * @param n
	 * @param griglia
	 */
	public Square(int n) {
		super();
		this.N = n;
		this.N2 = N*N;
		this.magicConst = N*(N*N+1)/2;
		this.griglia = new ArrayList<Integer>();
	}

	/**
	 * @return the n2
	 */
	public int getN2() {
		return N2;
	}

	public boolean chackMagicConst() {
		
		// controllo dimensioni
		
		if(griglia.size()!=N2)
			return false;
		
		// controllo righe
		
		if(!checkRows())
			return false;
		
		// controllo colonne
		
		if(!checkColumns())
			return false;
		
		// controllo diagonali
		
		if(!checkDiagonals())
			return false;
		
		return true;
	}

	private boolean checkDiagonals() {
		
		// diagonale principale
		
		int tmp = 0;
		
		for(int i=0; i<N; i++)
			tmp += griglia.get(i*N+i);
			
		if(tmp!=magicConst)
			return false;
		
		// diagonale secondaria
		
		tmp = 0;
				
		for(int i=N-1; i>=0; i--)
			tmp += griglia.get((N-1-i)*N+i);
					
		if(tmp!=magicConst)
			return false;
		
		return true;
		
	}

	private boolean checkColumns() {
		
		for(int i=0; i<N; i++){
			int tmp = 0;
			for(int j=0; j<N; j++){
				tmp += griglia.get(j*N+i);
			}
			
			if(tmp!=magicConst)
				return false;
			
		}
		
		return true;
		
	}

	private boolean checkRows() {
		
		for(int i=0; i<N; i++){
			int tmp = 0;
			for(int j=0; j<N; j++){
				tmp += griglia.get(i*N+j);
			}
			
			if(tmp!=magicConst)
				return false;
			
		}
		
		return true;
		
	}

	public void add(int i) {
		griglia.add(i);		
	}

	public void remove(int pos) {
		griglia.remove(pos);	
	}

	public boolean contains(int i) {
		return griglia.contains(i);
	}
	
	public String toString(){
		return griglia.toString();
	}

}

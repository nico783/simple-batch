package com.example.simplebatch.writer.repository;

import java.io.Serializable;

public interface RepositoryCustom<T, ID extends Serializable> {

	/**
	 * Envoie les données à la bdd puis les détaches de la session (cache de niveau 1).
	 * Cette méthode est utile dans le cas ou beaucoup de données doivent être persistées. 
	 * Elle évite de surcharger l'espace mémoire. 
	 */
	void flushAndClear();
	
	boolean contains(T entity);

}

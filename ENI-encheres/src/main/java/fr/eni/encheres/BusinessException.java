package fr.eni.encheres;

import java.util.List;
import java.util.ArrayList;

/**
 * BusinessException permet de recenser l'ensemble des erreurs (par leur code) pouvant survenir lors d'un traitement
 * quel que soit la couche à l'origine.
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<Integer> listeCodesErreur;
	
	public BusinessException() {
		super();
		this.listeCodesErreur=new ArrayList<>();
	}
	
	public BusinessException(String string) {
	}

	/**
	 * methode permettant l'ajout d'erreur
	 * @param code Code de l'erreur. 
	 * Doit avoir un message associé dans un fichier properties.
	 */
	public void ajouterErreur(int code)
	{
		if(!this.listeCodesErreur.contains(code))
		{
			this.listeCodesErreur.add(code);
		}
	}
	
	public boolean hasErreurs()
	{
		return this.listeCodesErreur.size()>0;
	}
	
	public List<Integer> getListeCodesErreur()
	{
		return this.listeCodesErreur;
	}

}
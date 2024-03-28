package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;

/**
 * interface pour la CategorieDAO
 */
public interface CategorieDAO {
	
	/**
	 * select Categorie by Id
	 * @param idCategorie
	 * @return Categorie
	 * @throws BusinessException
	 */
	Categorie selectById(int idCategorie) throws BusinessException;
	
	/**
	 * Selectionne toutes les categories
	 * @return Liste Categorie
	 * @throws BusinessException
	 */
	List<Categorie> selectAll() throws BusinessException;
}

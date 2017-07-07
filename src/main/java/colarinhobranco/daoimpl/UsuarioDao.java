package colarinhobranco.daoimpl;


import javax.persistence.EntityManager;

import colarinhobranco.util.JPAUtil;

import javax.persistence.Query;

public class UsuarioDao {

	
	public Boolean auth(String email, String senha) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
	
		Query query = manager.createQuery(
			"SELECT COUNT(u.id) FROM Usuario u WHERE u.email=:uEmail AND u.senha=:uSenha"
		);
		
		query.setParameter("uEmail", email);
		query.setParameter("uSenha", senha);
		
		Long existe = (Long) query.getSingleResult();
		
		if (existe > 0) {
			return true;
		}
		
		return false;
		
	}
}
package colarinhobranco.services; 

import colarinhobranco.daoimpl.UsuarioDao;

public class ApplicationServiceUsuario {
	
	private UsuarioDao usuarioDao = new UsuarioDao();

	public boolean auth(String email, String senha) {
		return this.usuarioDao.auth(email, senha);
	}

}

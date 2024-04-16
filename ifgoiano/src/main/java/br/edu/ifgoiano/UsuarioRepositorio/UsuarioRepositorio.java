package br.edu.ifgoiano.UsuarioRepositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.entidade.Usuario;


public class UsuarioRepositorio {

	private Connection conn;
	
	public UsuarioRepositorio(){
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
			conn.close();
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public List<Usuario> listaUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			String sql = ("select id,nome,senha,email,data_nascimento from usuario");
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usu = new Usuario();
				usu.setNome(rs.getString("nome"));
				usu.setSenha(rs.getString("senha"));
				usu.setEmail(rs.getString("email"));
				usu.setDataNascimento(rs.getDate("data_nascimento"));
				usu.setId(rs.getInt("id"));
				
				usuarios.add(usu);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro na consulta de usuarios.");
		}
		
		return usuarios;
	}
}

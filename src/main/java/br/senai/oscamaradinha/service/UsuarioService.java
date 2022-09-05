package br.senai.oscamaradinha.service;


import br.senai.oscamaradinha.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService extends UserDetailsService {

    public static Usuario create(Usuario usuario) {
        return null;
    }

    public Usuario update (Long id, Usuario usuario);
    public boolean delete(Long id);
    public Optional<Usuario> read(Long id);

    public List<Usuario> findAll();
}
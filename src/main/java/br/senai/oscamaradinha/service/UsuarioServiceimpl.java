package br.senai.oscamaradinha.service;

import br.senai.oscamaradinha.model.Usuario;
import br.senai.oscamaradinha.repository.UsuarioRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Optional<Usuario> updateUsuario = usuarioRepository.findById(id);
        if (!updateUsuario.isEmpty()){
            updateUsuario.get().setNome(usuario.getNome());
            updateUsuario.get().setUsername(usuario.getUsername());
            updateUsuario.get().setPassword(usuario.getPassword());
            return usuarioRepository.save(updateUsuario.get());
        } else {
            return null;
        }
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> read(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return usuarioRepository.findById(id).isEmpty();
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }

        UserDetails user = User.withUsername(usuario.getUsername())
                .password(usuario.getPassword())
                .authorities(List.of()).build();
        return user;
    }
    private class BCryptPasswordEncoder {
    }
    private class UserDetails {
    }
    private class UsernameNotFoundException extends Exception {
    }
}
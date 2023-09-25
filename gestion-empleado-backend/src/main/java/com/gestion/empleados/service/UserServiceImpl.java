package com.gestion.empleados.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gestion.empleados.modelo.User;
import com.gestion.empleados.repositorio.UserRepository;

@Service
public class UserServiceImpl implements UserService {
 
    private final UserRepository userRepository;
 
    public UserServiceImpl(UserRepository usuarioRepository){
        this.userRepository = usuarioRepository;
    }

	
	public void guardar(User user){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    userRepository.save(user);
	}
//	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
//	    User user = userRepository.findByNombre(nombre);
//	    if(user == null){
//	        System.out.println("Usuario o password incorrectos");
//	        throw new UsernameNotFoundException("Usuario o password incorrectos");
//	    }
//	    return (UserDetails) new User(user.getNombre(), user.getPassword(), mapearAutoridadesRoles(user.getRol()));
//	}
//	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Rol rol){
//	    return Collections.singleton((T) new SimpleGrantedAuthority(rol.getNombre()));
//	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
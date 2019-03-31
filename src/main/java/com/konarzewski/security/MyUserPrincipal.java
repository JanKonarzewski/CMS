package com.konarzewski.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.konarzewski.domain.Profile;
import com.konarzewski.domain.Role;

public class MyUserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Profile user;

	public MyUserPrincipal(Profile user) {
		this.user = user;

	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
//		System.out.println("here");
//		List<Role> e = new ArrayList<>();
//		Role d = new Role();
//		e.add(d);
//		List<SimpleGrantedAuthority> list = user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getRole()))
//				.collect(Collectors.toList());
//		System.out.println("list: " + list);
		List<SimpleGrantedAuthority> list1 = user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getRole().getAuthority())).collect(Collectors.toList());
		return list1;
	}

	public String getPassword() {
		System.out.println(user.getPassword());
		return user.getPassword();
	}

	public String getUsername() {
		System.out.println(user.getEmail());
		return user.getEmail();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}

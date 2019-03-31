package com.konarzewski.enumeration;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType implements GrantedAuthority {
	ROLE_ADMIN(5,"Admin"), ROLE_MANAGER(4,"Manager"), ROLE_USER(1,"User"), ROLE_REVIEWER(3,"Reviewer"), ROLE_SPREAKER(2,"Speaker");

	private int intRole;
	private String viewName;
	
	private RoleType(int intRole, String viewName) {
		this.intRole = intRole;
		this.viewName = viewName;
	}
	public static String getRolleByInt(int i) {
		switch (i) {
		case 1: return "User";
		case 2: return "Speaker";
		case 3: return "Reviewer";
		case 4: return "Manager";
		case 5: return "Admin";
		default : return "User";
		}
	}
	public int getIntRole() {
		return intRole;
	}

	public String getViewName() {
		return viewName;
	}

	@Override
	public String getAuthority() {
		return name();
	}

}

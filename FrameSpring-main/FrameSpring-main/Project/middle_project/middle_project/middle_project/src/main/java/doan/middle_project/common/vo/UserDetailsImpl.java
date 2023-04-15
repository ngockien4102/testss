package doan.middle_project.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import doan.middle_project.entities.Account;
import doan.middle_project.entities.UserRole;
import doan.middle_project.repositories.UserRoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 1L;

	private String id;

	private String username;


	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(String id, String username, String password,
						   Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;

		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Account account) {
		String role = "";
		List<UserRole> lstUserRole = account.getRoleId();
		for (UserRole item : lstUserRole) {
			role = item.getRole();
		}
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(simpleGrantedAuthority);

		return new UserDetailsImpl(
				account.getAccountId().toString(),
				account.getUserName(),

				account.getPassword(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getId() {
		return id;
	}


	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

}

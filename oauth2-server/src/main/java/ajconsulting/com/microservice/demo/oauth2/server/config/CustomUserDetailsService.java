package ajconsulting.com.microservice.demo.oauth2.server.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("SHOP_READ", "SHOP_WRITE");

		return new ProteineUser("ms-demo-admin", "admin", authorities, "code_eic1");
	}

}

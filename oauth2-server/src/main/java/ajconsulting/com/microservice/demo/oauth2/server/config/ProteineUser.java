package ajconsulting.com.microservice.demo.oauth2.server.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class ProteineUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codeEic;

	public ProteineUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String codeEic) {
		super(username, password, authorities);
		this.codeEic = codeEic;
	}

	public String getCodeEic() {
		return codeEic;
	}

	public void setCodeEic(String codeEic) {
		this.codeEic = codeEic;
	}

}

package ajconsulting.com.microservice.demo.shop.jwt;

import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

	@Override
	public Authentication extractAuthentication(Map<String, ?> map) {

		UsernamePasswordAuthenticationToken aut = (UsernamePasswordAuthenticationToken) super.extractAuthentication(
				map);
		aut.setDetails(map.get("codeEic"));
		return aut;
	}

}

package ajconsulting.com.microservice.demo.oauth2.server.config;

import java.util.HashMap;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(new HashMap<String, Object>());
		accessToken.getAdditionalInformation().put("codeEic", "1XAJAA1983");
		return super.enhance(accessToken, authentication);
	}

}

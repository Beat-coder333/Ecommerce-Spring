package it.object.mapstruct.ecommerce.service;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import it.object.mapstruct.ecommerce.model.Utente;

@Component
public class JWTService {

	private static Logger log = LoggerFactory.getLogger(JWTService.class);

	private static final String SECRET_JWT_KEY = "my-very-complicated-jwt-key";

	public String createJWTToken(Utente user) {

		Calendar cal = Calendar.getInstance();

		int minute = cal.get(Calendar.MINUTE) + 30;
		if (minute > 60) {
			minute = minute - 30;
			cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + 1);
		}
		cal.set(Calendar.MINUTE, minute);

		Algorithm alg = Algorithm.HMAC256(SECRET_JWT_KEY);
		String token = JWT.create().withClaim("id_utente", user.getId()).withClaim("username", user.getNomeUtente())
				.withExpiresAt(cal.getTime()).sign(alg);
		return token;

	}

	public boolean checkJWTToken(String jwtToken) {
		boolean valid = false;
		Algorithm alg = Algorithm.HMAC256(SECRET_JWT_KEY);
		try {
			JWTVerifier ver = JWT.require(alg).build();
			DecodedJWT decoded = ver.verify(jwtToken);

			// Long userId = decoded.getClaim("id_utente").asLong();
			String userName = decoded.getClaim("username").asString();
			log.info("" + "JWTService - Utente verificato " + userName);

			valid = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return valid;
	}

	public Utente getUserByToken(String jwtToken) {
		Utente user = new Utente();
		Algorithm alg = Algorithm.HMAC256(SECRET_JWT_KEY);
		try {
			JWTVerifier ver = JWT.require(alg).build();
			DecodedJWT decoded = ver.verify(jwtToken);

			Long userId = decoded.getClaim("user_id").asLong();
			String userName = decoded.getClaim("user_name").asString();

			user.setId(userId);
			user.setNomeUtente(userName);

			log.trace("Utente verificato! " + userName);

		} catch (Exception e) {
			e.printStackTrace();
			user = null;
		}
		return user;
	}

}

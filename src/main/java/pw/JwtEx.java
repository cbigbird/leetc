package pw;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;

public class JwtEx {
    public static void main(String[] args) {
        JwtEx entity = new JwtEx();
        System.out.println(entity.generateSampleJwtToken());
        System.out.println(entity.verifySampleJwtToken());
    }

    public String generateSampleJwtToken() {
        String key = "my-test-hs256-key";
        Algorithm algorithm = Algorithm.HMAC256(key);
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("sub", "1234567890");
        payload.put("name", "John Doe");
        payload.put("iat", 1516239022);
        String token = JWT.create()
                .withPayload(payload)
                .sign(algorithm);
        return token;
    }

    public boolean verifySampleJwtToken() {
        try {
            String key = "my-test-hs256-key";
            String token = generateSampleJwtToken();
            Algorithm algorithm = Algorithm.HMAC256(key);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

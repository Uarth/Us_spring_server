package ybigta.us.dto;

import lombok.Builder;
import lombok.Getter;
import ybigta.us.domain.User;
import java.util.Map;

@Getter
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String email;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String email) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.email = email;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
        return ofGoogle(registrationId, userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofGoogle(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .email( (String) attributes.get("email") )
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity(String email) {
        User user = new User();
        user.setEmail(email);
        user.setRole("ROLE_USER");
        return user;
    }


}

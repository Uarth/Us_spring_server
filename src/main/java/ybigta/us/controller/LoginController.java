package ybigta.us.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private static final String authorizationRequestBaseUri="oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls=new HashMap<>();
    private final ClientRegistrationRepository clientRegistrationRepository;

    @GetMapping("/login")
    public String getLoginPage(Model model)throws Exception {
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type =ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);

        if (type!=ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])){
            clientRegistrations=(Iterable<ClientRegistration>) clientRegistrationRepository;
        }
        assert clientRegistrations != null;
        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientSecret(),
                        authorizationRequestBaseUri+"/"+registration.getRegistrationId()));
        model.addAttribute("urls",oauth2AuthenticationUrls);

        return "login";
    }

    //로그인 성공했을 때
    @GetMapping("/login/success")
    public String login_success() {
        return "login_success";
    }

    //로그인 거절됐을 때
    @RequestMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
}


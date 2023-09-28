package com.carry.myproject.security.config;

//import com.carry.myproject.security.service.ClientDetailService;
import com.carry.myproject.security.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private TokenEnhancer tokenEnhancer;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
//    @Autowired
//    private ClientDetailService clientDetailService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancers = new ArrayList<>();
        enhancers.add(tokenEnhancer);
        enhancers.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(enhancers);

        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST, HttpMethod.DELETE)
                .userDetailsService(userDetailService)
                .tokenEnhancer(enhancerChain)
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter)
                .authorizationCodeServices(authorizationCodeServices)
                .exceptionTranslator(new DefaultWebResponseExceptionTranslator());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(172800)
                .refreshTokenValiditySeconds(864000)
                .scopes("all");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }
}

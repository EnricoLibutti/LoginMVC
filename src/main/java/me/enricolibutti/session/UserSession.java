package me.enricolibutti.session;

import lombok.Data;
import me.enricolibutti.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class UserSession implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private User user;
    private boolean authenticated = false;
    
    public void login(User user) {
        this.user = user;
        this.authenticated = true;
    }
    
    public void logout() {
        this.user = null;
        this.authenticated = false;
    }
    
    public boolean isAuthenticated() {
        return authenticated;
    }
}
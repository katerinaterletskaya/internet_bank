package terletskayasamuseva.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import terletskayasamuseva.UserService;
import terletskayasamuseva.model.AppUserPrincipal;
import terletskayasamuseva.model.UserDTO;

@Service(value = "appUserDetailsService")
public class AppUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(AppUserDetailsServiceImpl.class);

    private final UserService userService;

    @Autowired
    public AppUserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Username: " + username);
        UserDTO user = userService.getUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AppUserPrincipal(user);
    }
}

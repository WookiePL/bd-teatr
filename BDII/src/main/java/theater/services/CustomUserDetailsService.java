package theater.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import theater.persist.daos.UserDAO;
import theater.persist.model.RoleEntity;
import theater.persist.model.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userDAO.getUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }

        return new org.springframework.security.core.userdetails.User
                (user.getEmail(), user.getPassword(), true,
                        true, true, true, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<RoleEntity> role) {
        return getGrantedAuthorities(getRoles(role));
    }

    private static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    private List<String> getRoles(Collection<RoleEntity> roles) {
        return roles.stream().map(RoleEntity::getRole).collect(Collectors.toList());
    }
}

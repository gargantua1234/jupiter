package com.arek.domain.enums;

import com.arek.library.util.SetUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.Set;

import static com.arek.domain.enums.UserPermission.*;

public enum UserRole {
    STUDENT(Collections.emptySet()),
    ADMIN(Set.of(COURSE_WRITE, COURSE_READ, STUDENT_WRITE, STUDENT_READ)),
    ADMIN_TRAINEE(Set.of(COURSE_READ, STUDENT_READ));

    private static final String ROLE_PREFIX = "ROLE_";
    private final Set<UserPermission> permissions;

    UserRole(final Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> getGrantedAuthorities() {
        final Set<GrantedAuthority> authorities = SetUtils.transform(permissions,
                permission -> new SimpleGrantedAuthority(permission.getPermission()));
        authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + name()));
        return authorities;
    }
}

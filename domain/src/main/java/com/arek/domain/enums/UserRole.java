package com.arek.domain.enums;

import java.util.Collections;
import java.util.Set;

import static com.arek.domain.enums.UserPermission.*;

public enum UserRole {
    STUDENT(Collections.emptySet()),
    ADMIN(Set.of(COURSE_WRITE, COURSE_READ, STUDENT_WRITE, STUDENT_READ));

    private final Set<UserPermission> permissions;

    UserRole(final Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}

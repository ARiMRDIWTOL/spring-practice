package pl.gov.arimr.spring.core.constant;

public enum UserRole {

    ADMIN,
    USER;

    public static UserRole getByName(final String name) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.name().equals(name)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Value not found for name: " + name);
    }
}

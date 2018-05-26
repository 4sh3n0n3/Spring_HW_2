package ru.bagautdinov.models.enums;

public enum UserRoles {
    ROLE_USER ("ROLE_USER");

    private final String name;

    UserRoles(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}

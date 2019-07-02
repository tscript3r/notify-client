package pl.tscript3r.notify.client.backend.data;

public class Role {

    public static final String USER = "user";
    public static final String ADMIN = "admin";

    private Role() {
    }

    public static String[] getAllRoles() {
        return new String[]{ADMIN, USER};
    }

}

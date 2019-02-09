package base.lesson6;

public enum User {

    PITER_CHAILOVSKII("epam","1234","PITER CHAILOVSKII");

    public final String login;
    public final String password;
    public final String username;


    User(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.username = userName;
    }

    public static User getUserByUserName(String userName) {
        for (User user : values()) {
            if (user.username.equalsIgnoreCase(userName)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Wrong user name: " + userName);
    }
}

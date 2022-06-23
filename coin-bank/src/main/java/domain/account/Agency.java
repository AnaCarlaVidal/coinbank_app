package domain.account;

public class Agency {

    private String id;
    private String number;
    private String name;

    private Agency(String id, String number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public static Agency of(String number, String name) {
        return new Agency(null, number, name);
    }

    public static Agency of(String id, String number, String name) {
        return new Agency(id, number, name);
    }

    public String id() {
        return id;
    }

    public String number() {
        return number;
    }

    public String name() {
        return name;
    }

}

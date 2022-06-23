package domain.customer;

public class Customer {

    private String id;
    private String name;
    private String cpf;

    private Customer(final String id, final String name, final String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public static Customer of(final String name, final String cpf) {
        return new Customer(null, name, cpf);
    }

    public static Customer of(final String id, final String name, final String cpf) {
        return new Customer(id, name, cpf);
    }

    public String cpf() {
        return cpf;
    }

    public String name() {
        return name;
    }
}

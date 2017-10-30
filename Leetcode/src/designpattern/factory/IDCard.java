package designpattern.factory;

public class IDCard extends Product {
    private String owner;

    public IDCard(String owner) {
        System.out.println(owner + "'s card is created.");
        this.owner = owner;
    }

    @Override
    void use() {
        System.out.println(owner + "'s card is used.");
    }

    public String getOwner() {
        return owner;
    }
}

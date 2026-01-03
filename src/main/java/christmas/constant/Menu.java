package christmas.constant;

public enum Menu {
    MASHROOM_SOOP("양송이수프",6_000,Type.APPETIZER),
    TAPAS("타파스",5_500,Type.APPETIZER),
    CAESAR_SALAD("시저샐러드",8_000,Type.APPETIZER),

    TBONE_STEAK("티본스테이크",55_000,Type.MAIN),
    BARBECUE_RIBS("바비큐립",54_000,Type.MAIN),
    SEAFOOD_PASTA ("해산물파스타",35_000,Type.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타",25_000,Type.MAIN),

    CHOCOLATE_CAKE("초코케이크",15_000,Type.DESSERT),
    ICE_CREAM("아이스크림",5_000,Type.DESSERT),


    ZERO_COKE("제로콜라",3_000,Type.DRINK),
    RED_WINE("레드와인",60_000,Type.DRINK),
    CHAMPAGNE("샴페인",25_000,Type.DRINK);

    private final String name;
    private final double price;
    private final Type type;

    Menu(String name, double price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }
}

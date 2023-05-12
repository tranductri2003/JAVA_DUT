public class Card {
    private String CardId;
    private String Name;
    private float amount;

    public Card(String cardid, String name, float Amount) {
        CardId =  cardid;
        Name = name;
        amount = Amount;
    }

    public Card() {

    }

    public String getCardId() {
        return CardId;
    }


    public void setCardId(String cardId) {
        CardId = cardId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}

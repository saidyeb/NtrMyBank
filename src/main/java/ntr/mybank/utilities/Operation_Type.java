package ntr.mybank.utilities;

public enum Operation_Type {

	Transfer("Virement"),
	Debit("Prélèvement"),
	Credit("Crédit");
	
    private final String text;

    Operation_Type(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

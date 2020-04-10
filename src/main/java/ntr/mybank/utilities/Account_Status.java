package ntr.mybank.utilities;

public enum Account_Status {
	
	Active("Actif"),
	InActive("Cloturé"),
	Checking("En cours de création");
	
	
    private final String text;

    Account_Status(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

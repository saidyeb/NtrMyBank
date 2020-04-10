package ntr.mybank.utilities;

public enum Operation_Status {
	
	InProgress("En cours de traitement"),
	Valided("Validé"),
	Refused("Refusé");
	
    private final String text;

    Operation_Status(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

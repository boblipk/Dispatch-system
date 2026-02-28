public class Incident {
    private String IncType;
    private String IncDistrict;
    private boolean isHighPriority;
    private Incident next;

    public Incident(String IncType, String IncDistrict, boolean isHighPriority) {
        this.IncType = IncType;
        this.IncDistrict = IncDistrict;
        this.isHighPriority = isHighPriority;
        this.next = null;
    }

    public void newNext(Incident newIncident) {
        this.next = newIncident;
    }

    public boolean getPriority() {
        return isHighPriority;
    }

    public String getIncType() {
        return IncType;
    }

    public String getIncDistrict() {
        return IncDistrict;
    }

    public Incident getNext() {
        return next;
    }

    
}

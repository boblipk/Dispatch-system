public class Incedent {
    private String IncType;
    private String IncDistrict;
    private boolean isHighPriority;
    private Incedent next;

    public Incedent(String IncType, String IncDistrict, boolean isHighPriority) {
        this.IncType = IncType;
        this.IncDistrict = IncDistrict;
        this.isHighPriority = isHighPriority;
        this.next = null;
    }

    public void newNext(Incedent newIncedent) {
        this.next = newIncedent;
    }

    public boolean getPriority() {
        return isHighPriority;
    }

    
}

import java.time.Instant;
import java.util.UUID;


public class Incident {
    private String IncType;
    private String IncDistrict;
    private boolean isHighPriority;
    private Incident next;
    private UUID id;
    private Instant timestamp;

    public Incident(String IncType, String IncDistrict, boolean isHighPriority) {
        this.IncType = IncType;
        this.IncDistrict = IncDistrict;
        this.isHighPriority = isHighPriority;
        this.next = null;
        this.id = UUID.randomUUID();
        this.timestamp = Instant.now();
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
    
    public UUID getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    
}

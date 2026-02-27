public class IncedentQueue {
    private Incedent head;
    private Incedent tail;

    public IncedentQueue() {
        this.head = null;
        this.tail = null;
    }
    public void enqueue(Incedent newIncedent) {
        if (head == null) {
            head = newIncedent;
            tail = newIncedent;
        } else if (newIncedent.getPriority()) {
            newIncedent.newNext(head);
            head = newIncedent;
        } else {
            tail.newNext(newIncedent);
            tail = newIncedent;
        }
    
    }
}
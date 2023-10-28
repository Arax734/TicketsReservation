import java.util.ArrayList;

public class TicketDB {
    private static TicketDB instance;
    private ArrayList<Ticket> tickets;
    public TicketDB(){
        this.tickets = new ArrayList<Ticket>();
    }
    public static TicketDB getInstance(){
        if (instance == null) {
            instance = new TicketDB();
        }
        return instance;
    }
    public ArrayList<Ticket> getTickets(){
        return this.tickets;
    }
    public void addTicket(Ticket ticket){
        this.getTickets().add(ticket);
    }
}

import java.util.Random;

public class Client extends Thread{
    private String firstName;
    private String lastName;
    public Client(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void reserveTicket(Ticket ticket){
        //Synchronization of activate threads
        synchronized (ticket) {
            if (!ticket.getReserved()) {
                ticket.setReserved(true);
                ticket.setReservedBy(this);
                System.out.println(this.getFirstName() + " " + this.getLastName() + " reserved the ticket ID: " + ticket.getId());
            } else {
                if (ticket.getReservedBy() == this) {
                    ticket.setReserved(false);
                    ticket.setReservedBy(null);
                    System.out.println(this.getFirstName() + " " + this.getLastName() + " cancelled reservation of the ticket ID: " + ticket.getId());
                } else {
                    System.out.println(this.getFirstName() + " " + this.getLastName() + " is waiting for ticket ID: " + ticket.getId());
                }
            }
        }
    }
    @Override
    public void run() {
            while (!this.isInterrupted()) {
                TicketDB tickets = TicketDB.getInstance();
                Random rand = new Random();
                int index = rand.nextInt(tickets.getTickets().size());
                Ticket selectedTicket = tickets.getTickets().get(index);
                reserveTicket(selectedTicket);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.isInterrupted()) {
                    System.out.println(this.getFirstName()+" "+this.getLastName()+" lost hope and does not want to reserve tickets anymore.");
                    return;
                }
            }
    }
}

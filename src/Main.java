import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TicketDB tickets = TicketDB.getInstance();
        tickets.addTicket(new Ticket(1,20));
        tickets.addTicket(new Ticket(2,50));
        tickets.addTicket(new Ticket(3,30));

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        ArrayList<Client> clients = new ArrayList<>();
        Client client1 = new Client("Emma", "Smith");
        Client client2 = new Client("Liam ", "Johnson");
        Client client3 = new Client("Olivia", "Brown");
        Client client4 = new Client("Noah", "Williams");
        Client client5 = new Client("Ava", "Jones");
        Client client6 = new Client("William", "Davis");
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);
        for (Client client : clients) {
            executorService.execute(client);
        }
        //Example of interrupting single thread
        client1.interrupt();
        //Example of interrupting all threads
        /*for (Client client : clients) {
            if(!client.isInterrupted()){
                client.interrupt();
            }
        }*/
    }
}
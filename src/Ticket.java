public class Ticket {
    private int id;
    private int price;
    private boolean reserved;
    private Client reservedBy;
    public Ticket(int id,int price){
        this.id = id;
        this.price = price;
        this.reserved = false;
        this.reservedBy = null;
    }
    public int getId(){
        return this.id;
    }
    public int getCena(){
        return this.price;
    }
    public boolean getReserved(){
        return this.reserved;
    }
    public void setReserved(boolean reserved){
        this.reserved = reserved;
    }

    public Client getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(Client reservedBy) {
        this.reservedBy = reservedBy;
    }
}

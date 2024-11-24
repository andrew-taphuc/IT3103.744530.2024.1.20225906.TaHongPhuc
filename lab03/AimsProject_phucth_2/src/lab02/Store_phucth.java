package lab02;

public class Store_phucth {
    public static final int MAX_DVD = 50;
    private DigitalVideoDisc_phucth itemsInStore[] = new DigitalVideoDisc_phucth[MAX_DVD];
    private int qtyOrdered = 0;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int n) {
        qtyOrdered += n;
    }

    public void addDVDStore(DigitalVideoDisc_phucth disc) {
        if(this.getQtyOrdered() <= 50) {
            itemsInStore[this.getQtyOrdered()] = disc;
            setQtyOrdered(1);
            System.out.println("DVD " +'"'+ disc.getTitle() +'"'+ " has been added in phucth");
        } else {
            System.out.println("The phucth store is almost full");
        }
    }

    public void removeDVDStore(DigitalVideoDisc_phucth disc) {
        for(int i=0; i<qtyOrdered; i++) {
            if(itemsInStore[i].getTitle() == disc.getTitle()) {
                for(int j=i; j<qtyOrdered; j++) {
                    itemsInStore[j] = itemsInStore[j+1];
                }
                i--;
                setQtyOrdered(-1);
                System.out.println("The DVD " + disc.getTitle() + " has been removed in phucth ");
            }
        }
    }
}

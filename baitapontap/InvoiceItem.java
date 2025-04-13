public class InvoiceItem {
private String ID;
private String Desc;
private int Qty;
private double UnitPrice;
public InvoiceItem(String iD, String desc, int qty, double unitPrice) {
	this.ID = iD;
	this.Desc = desc;
	this.Qty = qty;
	this.UnitPrice = unitPrice;
}

public String getID() {
	return ID;
}

public void setID(String iD) {
	ID = iD;
}

public String getDesc() {
	return Desc;
}

public void setDesc(String desc) {
	Desc = desc;
}

public int getQty() {
	return Qty;
}

public void setQty(int qty) {
	Qty = qty;
}

public double getUnitPrice() {
	return UnitPrice;
}

public void setUnitPrice(double unitPrice) {
	UnitPrice = unitPrice;
}

public double getTotal() {
	return Qty*UnitPrice;
}

public String toString() {
	return "InvoiceItem [ID=" + ID + ", Desc=" + Desc + ", Qty=" + Qty + ", UnitPrice=" + UnitPrice + "]";
}

}

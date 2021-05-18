package in.nareshit.raghu.util;

import in.nareshit.raghu.model.Product;

//JDK 1.8
public interface ProductUtil {

	public static void calculateDetails(Product p) {
		double cost = p.getProdCost();
		p.setProdDisc(cost * 12/100);
		p.setProdGst(cost * 18/100);
	}
	
}

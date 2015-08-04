import java.awt.List;

public class MainClass {

	public MainClass() {
		// TODO Auto-generated constructor stub
	}

	static void function(Store store) {
		java.util.List<Item> itemList = store.getItems();
		System.out.println("---" + store.getId() + "---\n");
		for (int i = 0; i < itemList.size(); i++) {
			Item item = store.getItem(i);
			System.out.println("Item No : " + (i + 1) + " Price : "
					+ item.getDefaultPriceInCents());

			System.out.println("Purchase Detail\n");

			java.util.List<Purchase> purchaseList = item.getPurchases();
			for (int j = 0; j < purchaseList.size(); j++) {
				Purchase purchase = purchaseList.get(j);
				System.out.println("Purchase by : "
						+ purchase.getMembershipCard() + " No of Item : "
						+ purchase.getNumberOfItems());
			}

			System.out.println("Special Sprice\n");
			java.util.List<SpecialPrice> sprice = item.getSpecialPrices();
			for (int j = 0; j < sprice.size(); j++) {
				SpecialPrice sp = sprice.get(j);
				System.out.println("Special Price : " + sp.getPriceInCents());
			}
			System.out.println("Group Price\n");
			java.util.List<GroupPrice> gp = item.getGroupPrices();
			for (int j = 0; j < gp.size(); j++) {
				GroupPrice gPrice = gp.get(j);
				System.out.println("Get number To get Price : "
						+ gPrice.getNumberToBuyToGetPrice() + " Price : "
						+ gPrice.getPriceInCents());
			}

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store("Department Store");
		Item book = new Item(true, true, 10);
		Item pen = new Item(true, true, 10);
		Item laptop = new Item(true, true, 10);
		MembershipCardType mcType = new MembershipCardType("specialMiles");
		MembershipCardType mcType2 = new MembershipCardType("specialMiles");
		MembershipCard mCard = new MembershipCard(12233, mcType);
		MembershipCard mCard2 = new MembershipCard(12233, mcType2);
		SpecialPrice sPrice = new SpecialPrice(100, book, mcType);
		SpecialPrice sPrice2 = new SpecialPrice(20, pen, mcType);
		GroupPrice gPrice = new GroupPrice(200, 5, pen);
		GroupPrice gPrice2 = new GroupPrice(200, 8, book);
		Purchase purchase = new Purchase("10", book);
		Purchase purchase2 = new Purchase("5", pen);

		store.addItem(laptop);
		store.addItem(pen);
		store.addItem(laptop);

		function(store);

	}

}

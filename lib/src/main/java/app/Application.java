package app;

import Bson.BSon;
import model.Bitcoin;

public class Application {
	private static final String filePath = "./lib/src/main/resources/Bitcoin.json";

	public static void main(String[] args) {
		System.out.println("\n\n@@@@@@@@@@@@@@@@@ Main Method Now Start. @@@@@@@@@@@@@@@@@@\n");

		try {
//			Class<?> bson = Class.forName("Bson.BSon");
//			Method[] bsonMethod = bson.getClass().getDeclaredMethods();

			Bitcoin bitcoin = new Bitcoin();
			BSon bson = new BSon();

			System.out.println(bitcoin.getType());
			System.out.println(Bitcoin.class.getTypeName());
			System.out.println(bson.parse(bitcoin.getClass()));

//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

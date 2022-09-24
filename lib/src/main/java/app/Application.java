package app;

import Bson.BSon;
import model.Bitcoin;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {
	private static final String filePath = "./lib/src/main/resources/Bitcoin.json";

	public static void main(String[] args) {
		System.out.println("\n\n@@@@@@@@@@@@@@@@@ Main Method Now Start. @@@@@@@@@@@@@@@@@@\n");

		try {
			String json = null;

			try {
				json = new String(Files.readAllBytes(Paths.get(filePath)));
			} catch (Exception except) {
				except.printStackTrace();
			}

//			Class<?> bson = Class.forName("Bson.BSon");
//			Method[] bsonMethod = bson.getDeclaredMethods();

			Bitcoin bitcoin = new Bitcoin();

			bitcoin.from = "alice";
			bitcoin.to = "bob";
			bitcoin.addr = "addr bitcoin blur blur";

			BSon bson = new BSon();

			System.out.println(bitcoin.getType());
			System.out.println(Bitcoin.class);
			System.out.println(bson.parse(Bitcoin.class));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

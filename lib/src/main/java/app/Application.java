package app;

import java.lang.reflect.Method;

public class Application {
	private static final String filePath = "./lib/src/main/resources/Bitcoin.json";

	public static void main(String[] args) {
		System.out.println("\n\n@@@@@@@@@@@@@@@@@ Main Method Now Start. @@@@@@@@@@@@@@@@@@\n");

		try {
			String className = "Bitcoin";

			Class<?> bson = Class.forName("Bson.BSon");
			Object bsonInstance = bson.getDeclaredConstructor().newInstance();
			Method[] bsonMethod = bson.getDeclaredMethods();

			Class<?> model = Class.forName("model." + className);
			Object modelInstance = model.getDeclaredConstructor().newInstance();
			Method modelMethod = model.getDeclaredMethod("getType");

//			Bitcoin bitcoin = new Bitcoin();
//			BSon bson = new BSon();

//			System.out.println(bsonMethod);
//			System.out.println(model);
			String key  = modelMethod.invoke(modelInstance).toString();
			System.out.println(key);
//			System.out.println(bsonMethod[3].invoke(bsonInstance, key));
			Object parseResult = bsonMethod[0].invoke(bsonInstance, bson, key);
//			for (int i = 0; i < bsonMethod.length; i++) {
//				System.out.println(bsonMethod[i]);
//			}

//			System.out.println(Bitcoin.class.getTypeName());
//			Coin.Type str = bitcoin.getType();
//			String json = bson.getJsonFile(bitcoin.getType().toString());
//			System.out.println(bson.parse(bitcoin.getClass()));

//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		System.out.println("\n\n@@@@@@@@@@@@@@@@@ Main Method Now End. @@@@@@@@@@@@@@@@@@\n");
	}
}

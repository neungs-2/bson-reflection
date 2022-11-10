package app;

import Bson.BSon;
import model.User;

import java.util.HashMap;

public class Application {
	public static void main(String[] args) {
		System.out.println("\n\n@@@@@@@@@@@@@@@@@ Main Method Now Start. @@@@@@@@@@@@@@@@@@\n");

		try {
//			String key = Coin.Type.BITCOIN.toString();
			String key = User.Type.USER.toString();
			String className = key.charAt(0) + key.substring(1).toLowerCase();

			BSon bson = new BSon();
			String jsonResource = bson.getJsonFile(key);

			Class<?> cls = Class.forName("model." + className);
			HashMap parsedObj = (HashMap) bson.parse(cls, jsonResource);
			String json = bson.toJSON(parsedObj);

			System.out.println("=========" + className + "=========");
			System.out.println(parsedObj);

			System.out.println("\n========= JSON =========");
			System.out.println(json);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("className 변수에 올바른 값을 할당해주세요.\n\n");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		System.out.println("\n\n@@@@@@@@@@@@@@@@@ Main Method Now End. @@@@@@@@@@@@@@@@@@\n");
	}
}

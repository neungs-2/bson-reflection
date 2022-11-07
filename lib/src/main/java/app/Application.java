package app;

import org.json.simple.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Application {
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
			Field[] jsonFields = model.getDeclaredFields();

			// JSON 파일을 JSONObject로 파싱
			String key  = modelMethod.invoke(modelInstance).toString();
			JSONObject jsonObj = (JSONObject) bsonMethod[0].invoke(bsonInstance, bson, key);

			System.out.println("=========" + className + "=========");

			for (int i = 0; i < jsonFields.length; i++) {
				String[] fieldNameArr = jsonFields[i].toString().split("\\b.\\b");
				String field = fieldNameArr[fieldNameArr.length - 1];
				System.out.println(field + ": " + jsonObj.get(field));
			}

			// JSONObject를 JSON으로 변환
			System.out.println("\n========= JSON =========");
			Object json = bsonMethod[3].invoke(bsonInstance, jsonObj);
			System.out.println(json);


		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		System.out.println("\n\n@@@@@@@@@@@@@@@@@ Main Method Now End. @@@@@@@@@@@@@@@@@@\n");
	}
}

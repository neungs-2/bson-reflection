package Bson;


import org.json.JSONObject;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class BSon {

	private String getJsonPath(String key) {
		HashMap<String, String> jsonPath = new HashMap<>();
		jsonPath.put("BITCOIN", "./lib/src/main/resources/Bitcoin.json");
		jsonPath.put("ETHEREUM", "./lib/src/main/resources/Ethereum.json");
		jsonPath.put("USER", "./lib/src/main/resources/User.json");

		return jsonPath.get(key);
	}

	public String getJsonFile(String key) {
		String json = "";
		String filePath = this.getJsonPath(key);

		try {
			json = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (Exception except) {
			except.printStackTrace();
		}

		return json;
	}

	/**: JSON to Object Method
	 *
	 * @param cls: Class 타입
	 * @param json: String 타입, 파싱할 JSON
	 * @return JSONObject 타입, JSON을 Object로 변환한 객체
	 * @throws Exception
	 */
	public Object parse(Class<?> cls, String json) throws Exception {
		try {
			Object clsInstance = cls.getDeclaredConstructor().newInstance();
			Field[] jsonFields = cls.getDeclaredFields();

			if (jsonFields.length == 0) {
				Object superCls = cls.getSuperclass();
				jsonFields = ((Class<?>) superCls).getDeclaredFields();
			}

			JSONObject jsonObj = new JSONObject(json);
			HashMap<String, String> parsedMap = new HashMap<>();

			for (Field field: jsonFields) {
				String[] fieldNameArr = field.toString().split("\\b.\\b");
				String fieldName = fieldNameArr[fieldNameArr.length - 1];
				parsedMap.put(fieldName, jsonObj.get(fieldName).toString());

			}

			return parsedMap;
		} catch (Exception except) {
			except.printStackTrace();
		}

		return null;
	}

	public String toJSON(Object map) {
		JSONObject jsonObject = new JSONObject(map);
		return map.toString();
	}
}

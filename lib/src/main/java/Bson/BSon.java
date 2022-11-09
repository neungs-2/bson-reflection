package Bson;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class BSon {
	private String getJsonPath(String key) {
		HashMap<String, String> jsonPath = new HashMap<String, String>();
		jsonPath.put("BITCOIN", "./lib/src/main/resources/Bitcoin.json");
		jsonPath.put("ETHEREUM", "./lib/src/main/resources/Ethereum.json");
		jsonPath.put("USER", "./lib/src/main/resources/User.json");

		return jsonPath.get(key);
	}

	private String getJsonFile(String key) {
		String json = "";
		String filePath = this.getJsonPath(key);

		try {
			json = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (Exception except) {
			System.out.println(except);
			except.printStackTrace();
		}

		return json;
	}

	/**: JSON to Object Method
	 *
	 * @param cls: Class 타입
	 * @param key: String 타입, 모델명
	 * @return JSONObject 타입, JSON을 Object로 변환한 객체
	 * @throws Exception
	 */
	public JSONObject parse(Class<?> cls, String key) throws Exception {
		try {
			String json = this.getJsonFile(key);
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(json);
			return jsonObj;
		} catch (Exception except) {
			System.out.println(except);
			except.printStackTrace();
		}

		return null;
	}

	public String toJSON(JSONObject jsonObj) {
		return jsonObj.toJSONString();
	}
}

package Bson;

import org.json.simple.JSONObject;
import java.util.HashMap;


public class BSon {
	public String getJsonPath(String key) {
		HashMap<String, String> jsonPath = new HashMap<String, String>();
		jsonPath.put("BITCOIN", "./lib/src/main/resources/Bitcoin.json");
		jsonPath.put("ETHEREUM", "./lib/src/main/resources/Ethereum.json");
		jsonPath.put("USER", "./lib/src/main/resources/User.json");

		return jsonPath.get(key);
	}


	// parse 메서드를 model을 넣어서 실행 --> model에 값이 들어가야 함
	// model.getType을 이용해 어떤 모델인지 판단
	public Object parse(Class<?> cls) throws Exception {
		Object obj = cls.getDeclaredConstructor().newInstance();
		// TODO

		JSONObject jsonObj = new JSONObject();

//		JSONParser jsonParser = new JSONParser();
//		JSONObject jsonObject = (JSONObject) jsonParser.parse(String.valueOf(cls));
//		System.out.println(jsonObject);
		return obj;
	}

	// toJSON에 JSON(resource)를 넣어서 실행 --> Object로 변환
	// 요 안에서 parse를 써서 json 값을 model에 맞는 object로 변환
	// 즉 main method --> toJSON --> parse
	public Object toJSON(String param) {
		Object obj = new Object();
		return obj;
	}
}

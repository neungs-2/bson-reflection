package Bson;

import java.lang.reflect.Method;
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

	private String getJsonFile(String filePath) {
		String json = null;

		try {
			json = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (Exception except) {
			except.printStackTrace();
		}

		return json;
	}

	// parse 메서드를 model을 넣어서 실행 --> model에 값이 들어가야 함
	// model.getType을 이용해 어떤 모델인지 판단
	public Object parse(Class<?> cls) throws Exception {
		// model을 cls로 주입하여 인스턴스 생성하기

		Object obj = cls.getDeclaredConstructor().newInstance();
		Method[] methodArr = obj.getClass().getDeclaredMethods();
		System.out.println(getJsonPath("USER"));
		System.out.println(methodArr[0].invoke(obj));

		// TODO
		// obj의 타입을 통해 JSON 가져오기
		String jsonPath = this.getJsonPath(methodArr[0].invoke(obj).toString());
		String json = this.getJsonFile(jsonPath);

//		JSONObject jsonObj = new JSONObject();

//		JSONParser jsonParser = new JSONParser();
//		JSONObject jsonObject = (JSONObject) jsonParser.parse(String.valueOf(cls));
//		System.out.println(jsonObject);
		return json;
	}

	// toJSON에 JSON(resource)를 넣어서 실행 --> Object로 변환
	// 요 안에서 parse를 써서 json 값을 model에 맞는 object로 변환
	// 즉 main method --> toJSON --> parse
	public Object toJSON(String param) {
		Object obj = new Object();
		return obj;
	}
}

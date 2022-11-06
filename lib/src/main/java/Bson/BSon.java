package Bson;

import com.fasterxml.jackson.databind.ObjectMapper;
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
			except.printStackTrace();
		}

		return json;
	}

	// parse 메서드를 model을 넣어서 실행 --> model에 값이 들어가야 함
	// model.getType을 이용해 어떤 모델인지 판단
	// TODO: param에 필요한 값 넣어주기 (ex: parse에 String (JSON) 넣기)
	public Object parse(Class<?> cls, String key) throws Exception {
		// model을 cls로 주입하여 인스턴스 생성하기
		String json = this.getJsonFile(key);
		Object result = null;
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(json);
			System.out.println(obj);

			ObjectMapper mapper = new ObjectMapper();
			result = mapper.readValue(json, cls);
			System.out.println(result);
		} catch (Exception except) {
			except.printStackTrace();
		}

		return result;
//		Object obj = cls.getDeclaredConstructor().newInstance();
//		Method[] methodArr = obj.getClass().getDeclaredMethods();
//		Field[] fieldArr = obj.getClass().getDeclaredField();
//		System.out.println(getJsonPath("USER"));
//		System.out.println(methodArr[0].invoke(obj));

		// TODO
		// obj의 타입을 통해 JSON 가져오기
//		try{
//			for(int i = 0; i < methodArr.length; i++) {
//				if (methodArr[i].getName().equals("getType")) {
//					jsonPath = this.getJsonPath(methodArr[0].invoke(obj).toString());
//					json = this.getJsonFile(jsonPath);
//				}
//			}

			// TODO: 직접 구현하고 싶다면 field에 JSON 값 직접 할당하는 코드 작성
//			for(int i = 0; i < fieldArr.length; i++) {
//				if ()
//			}


//		} catch(Exception e) {
//			e.printStackTrace();
//		}



//		JSONObject jsonObj = new JSONObject();

//		JSONParser jsonParser = new JSONParser();
//		JSONObject jsonObject = (JSONObject) jsonParser.parse(String.valueOf(cls));
//		System.out.println(jsonObject);
	}

	// toJSON에 JSON(resource)를 넣어서 실행 --> Object로 변환
	// 요 안에서 parse를 써서 json 값을 model에 맞는 object로 변환
	// 즉 main method --> toJSON --> parse
	public Object toJSON(String param) {
		Object obj = new Object();
		return obj;
	}
}

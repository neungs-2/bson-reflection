package Bson;

public class BException extends Exception{
	/**
	 * 에러 코드 : 로그인에 대한 에러코드 Category.JOIN
	 * 
	 * @param code : Category.JOIN.getCode()
	 * @param msg
	 */

	public BException(String code, String msg) {
		System.out.print(code + " : " + msg);
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
		System.out.print("Error in BSon");
	}
}

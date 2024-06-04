package myTests;


import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

public class EnodeAndDecodeTest {

	
	@Test
	public void encodeDecode()
	{
		String str ="12345@Password";
	
			byte[] encodeString = null;
			try {
				encodeString = Base64.encodeBase64(str.getBytes());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		System.out.println("Encode String is  : " + new String(encodeString));
				
		byte[] decodedString = Base64.decodeBase64(encodeString);
		System.out.println("Decoded String is  : " + new String(decodedString));
	}
}

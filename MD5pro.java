package md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
 
public class MD5 {
	
 
	public static String md5(String str) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String md5Code = new BigInteger(1, secretBytes).toString(16); // 16��������
		// �����������δ��32λ,��Ҫ��ǰ�油0
		for (int i = 0; i < 32 - md5Code.length(); i++) {
			md5Code += "0";
		}
		
		char sh;int k=0,n;
		while(true) {
			sh=md5Code.charAt(k++);
			if(Character.isDigit(sh)) {
				n=(int)sh-48;
				break;
			}
		}
		
		StringBuffer str1 =new StringBuffer();  //�ÿɱ��ַ���,
		SecureRandom rand=new SecureRandom();
		for(int i=0;i<n+1;i++) {
		boolean bool=true;
		char ch = 0;
		while(bool) {        
			 ch=(char)rand.nextInt(48,123);     //�������48-122�����ַ�
			if(Character.isUpperCase(ch)||Character.isLowerCase(ch)||Character.isDigit(ch)){   //����ĸ����������ѭ�� ch>='0'&&ch<='9'||ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'
				bool=false;
			}
		}
		str1.append(ch);             //����ch�ַ���.  ���ò��ɱ�String,ÿ��ѭ���������ַ���,վ���ڴ�;
		}
		md5Code = md5Code.substring(0, 6)+str1+md5Code.substring(6);
		return md5Code;
	}
	
	public static void main(String[] args) {
		System.out.println(md5("0"));
	}
}



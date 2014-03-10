//
//  wpaFastweb.java Modem Pirelli
//  
//
//  Created by G on 25/01/11.
//  Copyright 2011 Esy-Exit Strategy. All rights reserved.
//
import java.security.*;



public class wpaFastweb {

	public static void main(String[] args){
	
		String pass = "";
		
		//OK
		
		String testString = "0021962D5718";
		char testChar = 00;
		byte[] defaultBytes = {(byte)0x,(byte)0xc3,(byte)0xBC,(byte)0x,(byte)0x2E,(byte)0x00};
		int aaaa = 0xFA;
		
		byte[] aaa={(byte)0x22,(byte)0x33,(byte)0x11,(byte)0x34,(byte)0x02,(byte)0x81,(byte)0xFA,(byte)0x22,(byte)0x11,(byte)0x41,(byte)0x68,(byte)0x11,(byte)0x12,(byte)0x01,(byte)0x05,(byte)0x22,(byte)0x71,(byte)0x42,(byte)0x10,(byte)0x66};
		
		try{
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			algorithm.update(aaa);
			byte messageDigest[] = algorithm.digest();
			
			
			int a=0;
			int b,c,d;	
			StringBuffer hexString = new StringBuffer();
			for (int i=0;i<messageDigest.length;i++) {
				if(i==0){
					a =	(0xFF & messageDigest[i]); 
					a = a<<24;
				//	System.out.println(a);
				}else if(i==1){
					b= (0xFF & messageDigest[i]);
					b=b<<16;
					a=b+a;
				//	System.out.println(b);
				}else if(i==2){
					c= (0xFF & messageDigest[i]);
					c=c<<8;
					a=c+a;
				//	System.out.println(c);
				}else if(i==3){
					d= (0xFF & messageDigest[i]);
					a=d+a;
				//	System.out.println(Integer.toHexString(a));
				}
				
				String hex = Integer.toHexString(0xFF & messageDigest[i]); 
			//	System.out.println(Integer.toHexString(0xFF & messageDigest[i]));
				if(hex.length()==1){
					hexString.append('0');
					
				}
				hexString.append(hex);
			}
			int g;
			int h;
			int i;
			int l;
			int fa;
			int control = 0x0F;
			b=a;
			b=b>>>7;
			fa=(0x1F & b);
			System.out.println(Integer.toHexString(fa));
			b=a>>>12;
			g=(0x1F & b);
			System.out.println(Integer.toHexString(g));
			b=a>>>17;
			h=(0x1F & b);
			System.out.println(Integer.toHexString(h));
			b=a>>>22;
			i=(0x1F & b);
			System.out.println(Integer.toHexString(i));
			b=a>>>27;
			l=(0x1F & b);
			System.out.println(Integer.toHexString(l));
			
			int e=0x0A;//byte di controllo
			int f=0x57;
			if(fa>=e){
				fa = fa + f;
			}
			if(g>=e){
				g = g + f;
			}
			if(h>=e){
				h = h + f;
			}
			if(i>=e){
				i = i + f;
			}
			if(l>=e){
				l = l + f;
			}
			
			
			
			String codice="";
			
			if(l<control){
				codice = codice + "0" + Integer.toHexString(l);
			}else{
				codice = codice + Integer.toHexString(l);			
			}
			
			if(i<control){
				codice = codice + "0" + Integer.toHexString(i);
			}else{
				codice = codice + Integer.toHexString(i);			
			}
			
			
			if(h<control){
				codice = codice + "0" + Integer.toHexString(h);
			}else{
				codice = codice + Integer.toHexString(h);			
			}
			
			if(g<control){
				codice = codice + "0" + Integer.toHexString(g);
			}else{
				codice = codice + Integer.toHexString(g);			
			}
						
			if(fa<control){
				codice = codice + "0" + Integer.toHexString(fa);
			}else{
				codice = codice + Integer.toHexString(fa);
			}
						System.out.println("chiave wpa: "+ codice);
			System.out.println("chiave wpa fastweb:"+Integer.toHexString(l)+" "+Integer.toHexString(i)+" "+Integer.toHexString(h)+" "+Integer.toHexString(g)+" "+Integer.toHexString(fa));
			/*
			byte a,b,c,d;
			
			byte[] primi4 = hexString.toString().getBytes();
			System.out.println(primi4[0]);
			a = primi4[0];
			int appo1 = a;
			b = primi4[1];
			int appo2 = b;  
			c = primi4[2]; 
			int appo3 = c;
			d = primi4[3];
			int appo4 = d;
			String aho1 =  dalBin(Integer.toBinaryString(appo1));
			String aho2 =  dalBin(Integer.toBinaryString(appo2));
			String aho3 =  dalBin(Integer.toBinaryString(appo3));
			String aho4 =  dalBin(Integer.toBinaryString(appo4));
			System.out.println(aho1+" "+aho2+" "+aho3+" "+aho4);
			String ehi1 = aho1.charAt(0) +"" + aho1.charAt(1)+""+aho1.charAt(2)+""+aho1.charAt(3)+""+aho1.charAt(4);
			String ehi2 = aho1.charAt(5)+""+aho1.charAt(6)+""+aho1.charAt(7)+""+aho2.charAt(0)+""+aho2.charAt(1);
			String ehi3 = aho2.charAt(2)+""+aho2.charAt(3)+""+aho2.charAt(4)+""+aho2.charAt(5)+""+aho2.charAt(6);
			String ehi4 = aho2.charAt(7)+""+aho3.charAt(0)+""+aho3.charAt(1)+""+aho3.charAt(2)+""+aho3.charAt(3);
			String ehi5 = aho3.charAt(4)+""+aho3.charAt(5)+""+aho3.charAt(6)+""+aho3.charAt(7)+""+aho4.charAt(0);
			System.out.println(ehi1+" "+ehi2+" "+ehi3+" "+ehi4+" "+ehi5);
			//String prova = Integer.toHexString(0xFF & ehi1);
			//System.out.println("--->" + prova);
			//*** Testausgabe
			
			 */
			System.out.println("pass "+pass+"   md5 version is "+hexString.toString());
			
			pass = hexString+"";
		}
		catch(NoSuchAlgorithmException nsae){
			
		}
	
	
	
	}	
	
	public static String dalBin(String a){
		String appo=a;
		for(int i=a.length();i<8;i++){
			appo= "0"+appo;
		}
		return appo;
	}
	
	public static void aliceWpa(){
		int ssid=11111111;
		int q=1019201;
		int k = 13;
		int seriale = (ssid-q)/k;
	
	
	}
	
	
}

// 컴퓨터학과, 20190975, 신효경
package pr01;

import java.lang.reflect.*;

public class pr01 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> cls = Class.forName("Date");
		
		System.out.println("생성자 정보");
		Constructor<?> ctorlist[] = cls.getDeclaredConstructors();
		for (int i = 0; i < ctorlist.length; i++) {
			Constructor<?> ct = ctorlist[i];
			System.out.println(ct.toString());
			System.out.println("name = " + ct.getName());
			System.out.println("decl class = " + ct.getDeclaringClass());
			
			Class<?> prev[] = ct.getParameterTypes();
			for (int j = 0; j < prev.length; j++) {
				System.out.println("  param #"+j+" "+prev[j]);
			}
			
			Class<?> evec[] = ct.getExceptionTypes();
			for (int j = 0; j < evec.length; j++) {
				System.out.println("  exc #"+j+" "+evec[j]);
			}
			System.out.println("-----------");
		}
		
		System.out.println();
		
		System.out.println("메소드 정보");
		Method mlist[] = cls.getDeclaredMethods();
		for (Method m : mlist) {
			System.out.println(m.toString());
			System.out.println("name = " + m.getName());
			System.out.println("decl class = " + m.getDeclaringClass());
			
			Class<?> prev[] = m.getParameterTypes();
			for (int i = 0; i < prev.length; i++) {
				System.out.println("  param #"+i+" "+prev[i]);
			}
			
			Class<?> evec[] = m.getExceptionTypes();
			for (int i = 0; i < evec.length; i++) {
				System.out.println("  exe #"+i+" "+evec[i]);
			}
			
			System.out.println("return type = " + m.getReturnType());
			System.out.println("-----------");
		}
		
		System.out.println("필드 정보");
		Field fieldlist[] = cls.getDeclaredFields();
		for (Field fld : fieldlist) {
			System.out.println("name = "+fld.getName());
			System.out.println("decl class = "+fld.getDeclaringClass());
			System.out.println("type = "+fld.getType());
			
			int mod = fld.getModifiers();
			System.out.println("modifiers = "+Modifier.toString(mod));
			System.out.println("-----");
		}
	}

}

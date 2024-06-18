// 컴퓨터학과, 20190975, 신효경
package main;

import java.util.Arrays;
import java.util.Scanner;

import enums.Message;
import hospital.Hospital;
import hospital.HospitalMain;
import key_manager.keyManagerMain;
import pw_manager.Password;
import research_center.ResearchCenter;
import research_center.ResearchCenterMain;


public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String inputPassword = null;
		char[] passwordArray = null;
		
		System.out.print(Message.INIT_OBJECT_AND_KEY.getMessage());
		
		Hospital hospital = new Hospital();
		System.out.print(Message.MEDICAL_OBJECT_CREATED.getMessage());
		
		new ResearchCenter();
		System.out.print(Message.RESEARCH_OBJECT_CREATED.getMessage());
		
		System.out.print(Message.OBJECT_CREATED_SUCCESS.getMessage());
		
		keyManagerMain.createSaveAsymKeys();
		System.out.print(Message.KEY_CREATED_SUCCESS.getMessage());
		
		int i = 0;
		boolean ifContinue = false;
		System.out.print(Message.HOSPITAL_GREETING.getMessage());
		do {
			System.out.print(Message.HOSPITAL_INPUT_PW.getMessage());
			inputPassword = sc.nextLine();
			passwordArray = inputPassword.toCharArray();
			inputPassword = null;
			i++;
			if (i == 3) {
				System.out.print(Message.PW_ERROR_PG_TERMINATE.getMessage());
				sc.close();
				return;
			}
			if (Password.checkPassWord(passwordArray)){
				Arrays.fill(passwordArray, ' ');
				ifContinue = HospitalMain.run(hospital, sc);
				break;		
			}else {
				Arrays.fill(passwordArray, ' ');
				System.out.print(Message.PW_ERROR.getMessage());
				System.out.print(i+Message.PW_ERROR_WARNING.getMessage());
			}			
		} while(i < 3);
		System.out.print("\n==============================================\n");
		i = 0;
		if (ifContinue == true) {
			System.out.print(Message.RESEARCH_CENTER_GREETING.getMessage());
			do {
				System.out.print(Message.RESEARCH_INPUT_PW.getMessage());
				inputPassword = sc.next();
				passwordArray = inputPassword.toCharArray();
				inputPassword = null;
				i++;
				if (i == 3) {
					System.out.print(Message.PW_ERROR_PG_TERMINATE.getMessage());
					sc.close();
					return;
				}if (Password.checkPassWord(passwordArray)){
					Arrays.fill(passwordArray, ' ');
					ResearchCenterMain.run(sc);
					break;
				}else {
					Arrays.fill(passwordArray, ' ');
					System.out.print(Message.PW_ERROR.getMessage());
					System.out.print(i+Message.PW_ERROR_WARNING.getMessage());
				}
			} while(i < 3);
		}
	}

}

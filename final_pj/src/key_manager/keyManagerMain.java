// 컴퓨터학과, 20190975, 신효경
package key_manager;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import exceptions.IdNotExistsException;
import id_manager.IdGenerator;


public class keyManagerMain {
	private static String hospitalPublicId = null;
	private static String hospitalPrivateId = null;
	private static String centerPublicId = null;
	private static String centerPrivateId = null;
	
	private static void initKeyId() {
		hospitalPublicId = IdGenerator.getRandomId();
		hospitalPrivateId = IdGenerator.getRandomId();
		centerPublicId = IdGenerator.getRandomId();
		centerPrivateId = IdGenerator.getRandomId();
	}
	
	public static void createSaveAsymKeys() throws IdNotExistsException, NoSuchAlgorithmException, IOException{
		// 병원, 연구소 고유 ID 초기화
		initKeyId();
		
		// 기존 키 삭제
		CreateSaveAsymKeys.initDirectory();
		
		// 비대칭키 초기화
		try {
			CreateSaveAsymKeys.initKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// 병원 공개키 & 개인키 생성
		try {
			CreateSaveAsymKeys.create(hospitalPrivateId, hospitalPublicId);
		} catch (IdNotExistsException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			throw new IOException();
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException();
		}
		
		// 연구소 공개키 & 개인키 생성
		try {
			CreateSaveAsymKeys.create(centerPrivateId, centerPublicId);
		} catch (IdNotExistsException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			throw new IOException();
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException();
		}
	}

	// getter가 public이어도 setter가 정의되어있지 않기때문에 안전.(규칙3)
	public static String getHospitalPublicId() {
		return hospitalPublicId;
	}

	public static String getHospitalPrivateId() {
		return hospitalPrivateId;
	}

	public static String getCenterPublicId() {
		return centerPublicId;
	}

	public static String getCenterPrivateId() {
		return centerPrivateId;
	}
}

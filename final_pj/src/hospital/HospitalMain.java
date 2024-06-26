package hospital;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import crypto_manager.EncryptionUtils;
import crypto_manager.Hash;
import key_manager.CreateSaveSymKey;
import key_manager.keyManagerMain;
import sign.signMode;
import enums.Extension;
import enums.FilePath;
import enums.Message;
import file_manager.ReadFile;
import file_manager.SaveFile;
import file_manager.SendFile;


public class HospitalMain {	
	public static void encryptAndSaveToFile(SecretKey sk, byte[] data, String filePath){
		Cipher cipher = EncryptionUtils.encrypt(sk);
		try {
			SaveFile.saveCipherDataToFile(cipher, data, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getMedicalRecord(Hospital hospital){
		StringBuilder sb = new StringBuilder();
		
		try {
			sb.append(hospital.getDoctor().toString());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		sb.append("\n");
		
		try {
			sb.append(hospital.getPatient().toString());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		sb.append("\n");
		
		try {
			sb.append(hospital.getMedicalRecord().toString());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static boolean run(Hospital hospital, Scanner sc){
		StringBuilder sb = null;
		
		//대칭키 생성
		SecretKey sk = CreateSaveSymKey.create();
		System.out.print(Message.SYMMETRIC_KEY_GENERATED.getMessage());
		
		// 개인키 가져오기
		String hospitalPId = keyManagerMain.getHospitalPrivateId();
		sb = new StringBuilder()
				.append(FilePath.PK.getPath())
				.append(hospitalPId)
				.append(Extension.KEY_EXT.getExtension());
		PrivateKey hospitalPrivateKey = (PrivateKey) ReadFile.loadKeyFromFile(sb.toString());

		// 환자의 의료 기록 가져오기
		String MR = getMedicalRecord(hospital);
		// 환자의 의료 기록을 대칭키로 암호화 하여 파일에 저장
		encryptAndSaveToFile(sk, MR.getBytes(), FilePath.HOSPITAL_SECRET_MR.getPath());
		
		// 환자의 의료 기록을 해시화한 값을 병원의 사설키로 암호화
		byte[] hashedMR = Hash.SHA1HashMedicalRecord(MR);
		byte[] signature = signMode.sign(hashedMR, hospitalPrivateKey);
		// 위의 값을 대칭키로 암호화하여 파일에 저장
		encryptAndSaveToFile(sk, signature, FilePath.HOSPITAL_SECRET_HASHED_MR.getPath());
		
		// 대칭키를 센터의 공개키로 암호화
		String centerPubId = keyManagerMain.getCenterPublicId();
		sb = new StringBuilder();
		sb.append(FilePath.PubK.getPath())
			.append(centerPubId)
			.append(Extension.KEY_EXT.getExtension());
		PublicKey centerPubK = (PublicKey) ReadFile.loadKeyFromFile(sb.toString());
		byte[] encryptedKey = EncryptionUtils.encryptSecretKey(sk, centerPubK);
		
		SaveFile.saveHashToFile(encryptedKey, FilePath.HOSPITAL_ENCRYPTED_SK.getPath());
		System.out.print(Message.DE_CREATED.getMessage());
		
		String answer = null;
		do{
			System.out.print(Message.TRANSMISSION_CHOICE.getMessage());
			answer = sc.next();
			if (answer.equals(Message.YES.getMessage())) {
				SendFile.send(FilePath.HOSPITAL_SECRET_MR.getPath(), FilePath.RC_SECRET_MR.getPath());
				SendFile.send(FilePath.HOSPITAL_SECRET_HASHED_MR.getPath(), FilePath.RC_SECRET_HASHED_MR.getPath());
				SendFile.send(FilePath.HOSPITAL_ENCRYPTED_SK.getPath(), FilePath.RC_ENCRYPTED_SK.getPath());
				return true;
			}
			else if (answer.equals(Message.NO.getMessage())) {
				System.out.print(Message.TRANSMISSION_CANCELED.getMessage());
				return false;
			}else {
				System.out.print(Message.WRONG_INPUT.getMessage());
			}
		}while(!answer.equals(Message.QUIT.getMessage()));
		
		System.out.print(Message.PROGRAM_TERMINATE.getMessage());
		return false;
	}
}

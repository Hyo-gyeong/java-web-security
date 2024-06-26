// 컴퓨터학과, 20190975, 신효경
package research_center;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.SecretKey;

import crypto_manager.DecryptionUtils;
import crypto_manager.Hash;
import enums.Extension;
import enums.FilePath;
import enums.Message;
import file_manager.ReadFile;
import key_manager.keyManagerMain;
import sign.verificationMode;


public class ResearchCenterMain {
	public static void run(Scanner sc) throws Exception {
		StringBuilder sb;
		
		//0. 센터 사설키로 대칭키 얻기
		String centerPId = keyManagerMain.getCenterPrivateId();
		sb = new StringBuilder();
		sb.append(FilePath.PK.getPath())
			.append(centerPId)
			.append(Extension.KEY_EXT.getExtension());
		PrivateKey pk = (PrivateKey) ReadFile.loadKeyFromFile(sb.toString());
		byte[] encryptedKey = ReadFile.readFromFile(FilePath.RC_ENCRYPTED_SK.getPath());
		SecretKey sk = DecryptionUtils.decryptSecretKey(encryptedKey, pk);

		// 비밀키를 이용해서 2개의 파일 해독
		// 1. 의료 기록
		byte[] secretMR = ReadFile.readFromFile(FilePath.RC_SECRET_MR.getPath());
		byte[] byteMR = DecryptionUtils.decrypt(secretMR, sk);
		String MR = new String(byteMR, StandardCharsets.UTF_8); //byte array to string

		// 2. 해시화되고 비밀키로 암호화된 의료 기록
		byte[] secretHashedMR = ReadFile.readFromFile(FilePath.RC_SECRET_HASHED_MR.getPath());
		byte[] byteHashedMR = DecryptionUtils.decrypt(secretHashedMR, sk);
		
		// 병원의 공개키로 2번(해시화되고 비밀키로 암호화된 의료 기록) 복호화
		String hospitalPubId = keyManagerMain.getHospitalPublicId();
		sb = new StringBuilder();
		sb.append(FilePath.PubK.getPath())
			.append(hospitalPubId)
			.append(Extension.KEY_EXT.getExtension());
		PublicKey hospitalPK = (PublicKey) ReadFile.loadKeyFromFile(sb.toString());
		byte[] hashedMR = Hash.SHA1HashMedicalRecord(MR);
		
		// 파일 비교 검증
		boolean result = verificationMode.verify(hospitalPK, hashedMR, byteHashedMR);
        System.out.println(Message.SIGN_RESULT.getMessage() + result);
        System.out.println(Message.MEDICAL_RECORD.getMessage());
        if (result == true) {
        	System.out.println(MR);
        } else {
        	System.out.println(Message.FILE_HACKED.getMessage());
        }
        
		sc.close();
	}
}

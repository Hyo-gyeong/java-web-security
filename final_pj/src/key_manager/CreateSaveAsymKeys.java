// 컴퓨터학과, 20190975, 신효경
package key_manager;

import java.io.File;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import enums.Extension;
import enums.FilePath;
import enums.Message;
import exceptions.IdNotExistsException;
import file_manager.SaveFile;


public class CreateSaveAsymKeys {
	private static StringBuilder sb = null;
	private static PublicKey publickey = null;
	private static PrivateKey privatekey = null;
	private static KeyPair keypair = null;
	
	protected static void create(String pkId, String pubkId) throws IdNotExistsException, IOException, NoSuchAlgorithmException {
		if (pkId == null || pubkId == null) {
			throw new IdNotExistsException(Message.ID_NOT_EXISTS.getMessage());
		}
		
		try{ // 개인키 생성
			createPrivateKey(pkId);
		} catch (IOException e) {
			throw new IOException();
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException();
		}
		
		try{ // 공개 생성
			createPublicKey(pubkId);
		} catch (IOException e) {
			throw new IOException();
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException();
		}
	}
	
	protected static void initKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);
		
		keypair = keyPairGen.generateKeyPair();
		publickey = keypair.getPublic();
		privatekey = keypair.getPrivate();
		
	}
	
	protected static void initDirectory() {
		deleteDirectory(new File(FilePath.PubK_DIRECTORY.getPath()));
		deleteDirectory(new File(FilePath.PK_DIRECTORY.getPath()));
		deleteDirectory(new File(FilePath.SK_DIRECTORY.getPath()));
	}

	private static void deleteDirectory(File directory) {
	    if (directory.exists()) {
	        File[] files = directory.listFiles();
	        if (files != null) {
	            for (File file : files) {
	            	file.delete();
	            }
	        }
	    }
	}

	private static void createPublicKey(String id) throws NoSuchAlgorithmException, IOException {
		sb = new StringBuilder()
				.append(FilePath.PubK.getPath())
				.append(id)
				.append(Extension.KEY_EXT.getExtension());
		String publicPath = sb.toString();
		SaveFile.saveKey(publicPath, publickey);
	}
	
	private static void createPrivateKey(String id) throws NoSuchAlgorithmException, IOException {
		sb = new StringBuilder()
				.append(FilePath.PK.getPath())
				.append(id)
				.append(Extension.KEY_EXT.getExtension());
		String privatePath = sb.toString();
		SaveFile.saveKey(privatePath, privatekey);
	}
}

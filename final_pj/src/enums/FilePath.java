package enums;

public enum FilePath {
    // 기본 경로
    KEY_MANAGER("./src/key_manager/"),
    HOSPITAL("./src/hospital/"),
    RESEARCH_CENTER("./src/research_center/"),
    PW_MANAGER("./src/pw_manager/"),

    // 키 관리자 경로
    PK_DIRECTORY(KEY_MANAGER.getPath() + "private_keys/"),
    PubK_DIRECTORY(KEY_MANAGER.getPath() + "public_keys/"),
    SK_DIRECTORY(KEY_MANAGER.getPath() + "secret_keys/"),
    PK(PK_DIRECTORY.getPath() + "private_"),
    PubK(PubK_DIRECTORY.getPath() + "public_"),
    SK(KEY_MANAGER.getPath() + "symmetric_key/skey" + Extension.KEY_EXT.getExtension()),

    // 파일 경로 및 파일
    SECRET_MR("secret_medical_record.txt"),
    SECRET_HASHED_MR("secret_hashed_medical_record" + Extension.KEY_EXT.getExtension()),
    ENCRYPTED_SK("encrypted_secret_key" + Extension.KEY_EXT.getExtension()),

    // 연구소 파일 경로
    RC_SECRET_MR(RESEARCH_CENTER.getPath() + SECRET_MR.getPath()),
    RC_SECRET_HASHED_MR(RESEARCH_CENTER.getPath() + SECRET_HASHED_MR.getPath()),
    RC_ENCRYPTED_SK(RESEARCH_CENTER.getPath() + ENCRYPTED_SK.getPath()),

    // 병원 파일 경로
    HOSPITAL_SECRET_MR(HOSPITAL.getPath() + SECRET_MR.getPath()),
    HOSPITAL_SECRET_HASHED_MR(HOSPITAL.getPath() + SECRET_HASHED_MR.getPath()),
    HOSPITAL_ENCRYPTED_SK(HOSPITAL.getPath() + ENCRYPTED_SK.getPath()),
	
	// salt경로
	SALT(PW_MANAGER.getPath() + "salt.txt"),
	// pw + salt 경로
	HASHED_PW(PW_MANAGER.getPath() + "hashed_pw.txt");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
package enums;

public enum Message {
    INIT_OBJECT_AND_KEY("객체 및 키를 초기화합니다.\n"),
    MEDICAL_OBJECT_CREATED("의사 정보, 환자 정보, 의료 정보를 생성했습니다.\n"),
    RESEARCH_OBJECT_CREATED("연구소 정보를 생성했습니다.\n"),
    OBJECT_CREATED_SUCCESS("------- 모든 객체 생성이 성공적으로 완료되었습니다. -------\n"),
    KEY_CREATED_SUCCESS("------- 모든 비대칭키 생성이 성공적으로 완료되었습니다. -------\n"),
    HOSPITAL_GREETING("\n안녕하세요. A병원 서버입니다.\n"),
    HOSPITAL_INPUT_PW("의료 기록을 암호화 하려면 비밀번호를 입력하세요: "),
    RESEARCH_CENTER_GREETING("\n안녕하세요. B연구소 서버입니다.\n"),
    RESEARCH_INPUT_PW("전자봉투를 열려면 암호를 입력하세요: "),
    PW_ERROR_PG_TERMINATE("3회 이상 오류. 프로그램이 종료됩니다.\n"),
    PW_ERROR_WARNING("회 오류. 3회 이상 오류시 프로그램이 닫힙니다.\n\n"),
    PW_ERROR("비밀번호가 일치하지 않습니다.\n"),
    SYMMETRIC_KEY_GENERATED("대칭키를 생성했습니다.\n"),
    ID_NOT_EXISTS("아이디가 존재하지 않습니다.\n"),
    DE_CREATED("전자봉투를 생성했습니다.\n"),
    TRANSMISSION_CHOICE("전자봉투를 연구소로 보내시겠습니까? y/n (나가기 q) : "),
    YES("y"),
    NO("n"),
    QUIT("q"),
    TRANSMISSION_CANCELED("파일 전송을 취소했습니다. 파일은 삭제되지 않습니다.\n"),
    WRONG_INPUT("입력이 잘못되었습니다.\n"),
    SIGN_RESULT("\n서명 검증 결과 : "),
    MEDICAL_RECORD("<의료 기록>"),
    FILE_HACKED("원본 파일이 훼손되었습니다.\n"),
    PROGRAM_TERMINATE("프로그램이 종료됩니다.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// 컴퓨터학과, 20190975, 신효경
package id_manager;

import java.util.Random;

import enums.ID;

public class IdGenerator {
    private static final Random RANDOM = new Random();
    
	public static String getRandomId() {
        int length = RANDOM.nextInt(5) + 8; // 8 이상 12 이하의 길이 랜덤 생성
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(ID.CHARACTERS.getCharacters().length());
        char randomChar = ID.CHARACTERS.getCharacters().charAt(randomIndex); // 0~9, a~Z사이 랜덤 숫자 또는 문자 선택
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
	}
}

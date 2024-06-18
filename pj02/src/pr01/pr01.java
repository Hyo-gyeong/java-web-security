// 컴퓨터학과, 20190975, 신효경
package pr01;

public class pr01 {

	public static void main(String[] args) {
		calcSum(10, 20);
		calcSum(10, 20, 30);
		calcSum(10, 20, 30, 40, 50);
	}

	public static void calcSum(int... numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		System.out.println(sum);
	}
}

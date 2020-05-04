package src.ByteRun;

import java.util.Random;
import common.CommonUtil;

/**
 * The rand7() API is already defined in the parent class SolBase.
 *  * public int rand7();
 *  * @return a random integer in the range 1 to 7
 */
public class ImplementRtenByRseven {
	// 已经定义好,返回[1,2,3,4,5,6,7]中的一个
	private static int rand7() {
		Random random = new Random();
		return random.nextInt(7) + 1;
	}

	private static int rand10() {
		// 返回在[1,2,3,4,...,49]中的一个
		int r49 = (rand7() - 1) * 7 + rand7();
		// 需要去除41-49，因为没有50，结果为0的情况不均匀
		return r49 = r49 <= 40 ? r49 % 10 + 1 : rand10();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			CommonUtil.printNumber(rand10());
		}
	}
}

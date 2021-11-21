
public class Programa {

	public static void main(String[] args) {

		if (args.length < 1) {
			System.exit(-1);
		}

		try {
			
			int num = Integer.parseInt(args[0]);
			if (num < 0) {
				System.exit(3);
			}

			System.exit(0);

		} catch (Exception e) {
			System.exit(2);
		}

	}

}

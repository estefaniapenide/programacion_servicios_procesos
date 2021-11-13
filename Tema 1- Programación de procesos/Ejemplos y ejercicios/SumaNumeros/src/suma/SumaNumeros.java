package suma;

public class SumaNumeros {

	public static void main(String[] args) {
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);

		
		int resultado=0;
		
		if(a<b) {
			for(int i =a;i<=b;i++) {
				resultado+=i;
			}
			
		}else if(a>b) {

			for(int i =b;i<=a;i++) {
				resultado+=i;
			}
			
		}else {
			resultado=a+b;
		}
		
		System.out.println("Número:"+a+"\n"
				+"Número:"+b+"\n"
				+"SumaTotal:"+resultado+"\n");

	}

}

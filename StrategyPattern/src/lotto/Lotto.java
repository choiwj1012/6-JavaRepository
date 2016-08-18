package lotto;

public class Lotto {

	public static void main(String[] args){

		System.out.println("로또 번호 자동 추첨기");
		
		int i = 0;
		boolean isFind = false;
		int[] lottoNumber = new int[6];
		
		while( i < 6 ){
			
			isFind = false;
			
			lottoNumber[i] = (int)(Math.random() * 45) + 1;
			
			for(int j=0; j<i; j++){
				if(lottoNumber[i] == lottoNumber[j]){
					isFind = true;
					break;
				}
			}
			
			if(isFind){
				continue;
			}
			
			System.out.print(lottoNumber[i] + "번  ");	
			i++;

		}

	}

}


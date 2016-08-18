package lotto;

import java.util.ArrayList;

public class lotto_2 {
	
	public static void main(String[] args){
		
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		lotto.add((int)(Math.random()*6+1));   // 로또 첫번째 숫자
		boolean flag = true;
		boolean isFind;
		
		int num = 0;
		
		while(flag)
		{
			isFind = false;
			num = (int)(Math.random()*6+1) ; 

			// 랜덤숫자와 현재 로또 리스트에 있는 숫자들을 비교, 중복이 있다면 isFind 를 true로 바꿈
			for(int i=0; i <lotto.size(); i++)				
			{
				if(num == lotto.get(i))
				{
					isFind = true;
				}
				
			}
			
			// isFind가 false 일때만 num의 랜덤값을 로또 리스트에 넣음.
			if(isFind == false)   
			{
				lotto.add(num);
			}
			
			// 로또 리스트의 사이즈가 6이 되면 반복문 탈출
			if(lotto.size() == 6)
			{
				flag = false;
			}
			
		}
		
		// 반복문을 탈출하면 로또 리스트 출력
		for(int i = 0; i < lotto.size(); i++ )
		{
			System.out.println(lotto.get(i));
		}
	}
	
}
package application;

import java.util.Arrays;
import java.util.Formatter;


public class DecimalBigInt {
	
	final static int BASE = 1000000000;
	final static int BASE_DECIMAL_DIGITS = 9;
	private int[] digits;

	
	public DecimalBigInt(int... digits) 
	{
	    for(int digit : digits) {
	        if( BASE <= digit) {
	            throw new IllegalArgumentException("digit " + digit + " out of range!");
	        }
	    }
	    this.digits = digits.clone();
	}
	
	
	public String toString() 
	{
	    return "Big" + Arrays.toString(digits);
	}
	
	
	//DODAWANIE !!!
	
	public static DecimalBigInt valueOf(String decimal)
	{
	 int decLen = decimal.length();
	 int bigLen = (decLen-1) / BASE_DECIMAL_DIGITS + 1;
	 int firstSome = decLen - (bigLen-1) * BASE_DECIMAL_DIGITS;
	 int[] digits = new int[bigLen];
	 
	 for(int i = 0; i < bigLen ; i++) {
		String block = decimal.substring(Math.max(firstSome + (i-1)*BASE_DECIMAL_DIGITS, 0),firstSome +   i  *BASE_DECIMAL_DIGITS);
		 digits[i] = Integer.parseInt(block);
	 }
	 
	 return new DecimalBigInt(digits);
	
	}
	
	public String toDecimalString() {
	    Formatter f = new Formatter();
	    f.format("%d", digits[0]);
	    for(int i = 1 ; i < digits.length; i++) {
	        f.format("%09d", digits[i]);
	    }
	    return f.toString();
	}
	
	public DecimalBigInt plus(DecimalBigInt that) {
	    int[] result = new int[Math.max(this.digits.length,
	                                    that.digits.length)+ 1];

	    addDigits(result, result.length-1, this.digits);
	    addDigits(result, result.length-1, that.digits);

	  
	    if(result[0] == 0) {
	        result = Arrays.copyOfRange(result, 1, result.length);
	    }
	    return new DecimalBigInt(result);
	}
	
	private void addDigit(int[] result, int resultIndex,
            int addendDigit)
					{
						int sum = result[resultIndex] + addendDigit;
						result[resultIndex] = sum % BASE;
						int carry = sum / BASE;
							if(carry > 0) 
							{
								addDigit(result, resultIndex - 1, carry);
						    }
					}
	
	private void addDigits(int[] result, int resultIndex,
            int... addend)
			{
				int addendIndex = addend.length - 1;
				while(addendIndex >= 0) {
				addDigit(result, resultIndex,
				      addend[addendIndex]);
				addendIndex--;
				resultIndex--;
				}
			}
	
	
	//MNOZENIE
	
	private void multiplyDigit(int[] result, int resultIndex,
            int firstFactor, int secondFactor) 
			{
				long prod = (long)firstFactor * (long)secondFactor;
				int prodDigit = (int)(prod % BASE);
				int carry = (int)(prod / BASE);
				addDigits(result, resultIndex, carry, prodDigit);
			}
	
	
	private void multiplyDigits(int[] result, int resultIndex,
            int[] leftFactor, int[] rightFactor) 
	{
				for(int i = 0; i < leftFactor.length; i++) 
				{
				for(int j = 0; j < rightFactor.length; j++)
					{

					multiplyDigit(result, resultIndex - (i + j),
					          leftFactor[leftFactor.length-i-1],
					          rightFactor[rightFactor.length-j-1]);
					}
				}
	}
	

	public DecimalBigInt times(DecimalBigInt that) {
	    int[] result = new int[this.digits.length + that.digits.length];
	    multiplyDigits(result, result.length-1, 
	                   this.digits, that.digits);

	    if(result[0] == 0) {
	        result = Arrays.copyOfRange(result, 1, result.length);
	    }
	    return new DecimalBigInt(result);
	}
	
	
	
	
	
	
	
	
	
	
	
}




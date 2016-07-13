class test{
	public static void main(String[] args){
		int n= 7;
		n<<=3;
		System.out.println(n);
		n=n&(n+1)|(n+2)^(n+3);
		/*
			56 and
		*/
		System.out.println(n);
		n>>=2;
		System.out.println(n);
	}
}

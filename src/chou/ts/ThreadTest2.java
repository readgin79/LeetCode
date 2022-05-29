package chou.ts;

public class ThreadTest2 {

	public static void main(String[] args) {
		/*
		 * 建立一個帳戶
		 * 透過多次的提款，檢查帳戶的金額是否有誤
		 * 
		 * */
		Account account = new Account(10000);
		AccountThread s1 = new AccountThread(account, "提款A", 1000);
		AccountThread s2 = new AccountThread(account, "提款B", 1000);
		AccountThread s3 = new AccountThread(account, "提款C", 1000);
		AccountThread s4 = new AccountThread(account, "提款D", 1000);
		AccountThread s5 = new AccountThread(account, "提款E", 1000);

		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s5.start();
	}

}

class Account{
	int atmMoney = 0;
	Account(int atmMoney){
		this.atmMoney = atmMoney;
	}
	//第一種鎖，鎖方法，讓各個Thread執行到此方法時，需等待到方法執行完畢
	//synchronized void getMoney( int money) {
	/* void getMoney( int money) {
		atmMoney-=money;
		System.out.println(Thread.currentThread().getName() + "----ATM尚存："+atmMoney);
	}*/
	//第二種鎖，鎖區段，區段內鎖定的this(物件自己)，需等待到區段執行完畢
	/*void getMoney( int money) {
		synchronized(this) {
			atmMoney-=money;
			System.out.println(Thread.currentThread().getName() + "----ATM尚存："+atmMoney);
		}
	}*/
	void getMoney( int money) {
		atmMoney-=money;
		System.out.println(Thread.currentThread().getName() + "----ATM尚存："+atmMoney);
	}
}

class AccountThread extends Thread{

	Account account;
	int getMoney;
	AccountThread(Account account, String name, int getMoney){
		this.account = account;
		this.setName(name);
		this.getMoney = getMoney;
	}

	
	@Override
	public void run() {
		//第三種鎖，鎖區段，對象是要執行的整個物件。
		/*synchronized(account) {
			account.getMoney( getMoney);
		}*/
		//第四種鎖，鎖區段，對象是要執行的整個類別。
		/*synchronized(Account.class) {
			account.getMoney( getMoney);
		}*/
		account.getMoney( getMoney);
	}
}

//第五種鎖，當鎖定的對象是靜態類別時，鎖定執行的方法
/*class Account{
	static int atmMoney = 0;
	Account(int atmMoney){
		this.atmMoney = atmMoney;
	}
	
	static synchronized void getMoney( int money) {
		atmMoney-=money;
		System.out.println(Thread.currentThread().getName() + "----ATM尚存："+atmMoney);
	}
}*/
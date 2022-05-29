package chou.ts;

public class ThreadTest2 {

	public static void main(String[] args) {
		/*
		 * �إߤ@�ӱb��
		 * �z�L�h�������ڡA�ˬd�b�᪺���B�O�_���~
		 * 
		 * */
		Account account = new Account(10000);
		AccountThread s1 = new AccountThread(account, "����A", 1000);
		AccountThread s2 = new AccountThread(account, "����B", 1000);
		AccountThread s3 = new AccountThread(account, "����C", 1000);
		AccountThread s4 = new AccountThread(account, "����D", 1000);
		AccountThread s5 = new AccountThread(account, "����E", 1000);

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
	//�Ĥ@����A���k�A���U��Thread����즹��k�ɡA�ݵ��ݨ��k���槹��
	//synchronized void getMoney( int money) {
	/* void getMoney( int money) {
		atmMoney-=money;
		System.out.println(Thread.currentThread().getName() + "----ATM�|�s�G"+atmMoney);
	}*/
	//�ĤG����A��Ϭq�A�Ϭq����w��this(����ۤv)�A�ݵ��ݨ�Ϭq���槹��
	/*void getMoney( int money) {
		synchronized(this) {
			atmMoney-=money;
			System.out.println(Thread.currentThread().getName() + "----ATM�|�s�G"+atmMoney);
		}
	}*/
	void getMoney( int money) {
		atmMoney-=money;
		System.out.println(Thread.currentThread().getName() + "----ATM�|�s�G"+atmMoney);
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
		//�ĤT����A��Ϭq�A��H�O�n���檺��Ӫ���C
		/*synchronized(account) {
			account.getMoney( getMoney);
		}*/
		//�ĥ|����A��Ϭq�A��H�O�n���檺������O�C
		/*synchronized(Account.class) {
			account.getMoney( getMoney);
		}*/
		account.getMoney( getMoney);
	}
}

//�Ĥ�����A����w����H�O�R�A���O�ɡA��w���檺��k
/*class Account{
	static int atmMoney = 0;
	Account(int atmMoney){
		this.atmMoney = atmMoney;
	}
	
	static synchronized void getMoney( int money) {
		atmMoney-=money;
		System.out.println(Thread.currentThread().getName() + "----ATM�|�s�G"+atmMoney);
	}
}*/
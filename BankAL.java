/*1: Implement a Bank Account having Instance variables: Account Number, Balance and having methods:
float Deposit (float x)
float withdraw (float x)
int get account no ()
float get balance ()
tax deduction ()
Then implement class Bank having an array list of accounts of type BankAccount. Implement following methods:
AddAccount in Bank
Get Total balance in Bank
Get account number with max. and min. balance
Find an account given a bank account no.
Count no. of accounts having atleast specific balance*/
//!!! Resource @tutorials duniya
package bankal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Account
{
    Random no=new Random();
    private int acc;
    private int bal;
    private String name;
    private ArrayList<Account> accounts=new ArrayList<Account>();
    	Account(int x){
            acc=x;
            bal=0;
            accounts.add(new Account("Alen",acc));
            acc++;
            accounts.add(new Account("Bob",acc));
            acc++;
        }
	Account(String name,int acc){
            this.name=name;
            this.acc=acc;
            bal=0;//
	}
	public void createexist(){
            int ch;
            do{
		System.out.println("--- This is Existing Account Menu ---");
		System.out.println("1.Get Balance");
		System.out.println("2.Withdraw from bank");
		System.out.println("3.Deposit in Account");
		System.out.println("4.Go to bank menu");
		System.out.println(">>>Enter Option: ");
		Scanner sc = new Scanner(System.in);
		ch = sc.nextInt();
		switch(ch){
                    case 1: this.getBal();
		            break;
                    case 2: this.withdrawl();
                            break;
	            case 3: this.deposit();
		            break;
                    case 4: menu();
                            break;
                    default: System.out.println("Wrong Input !");
                        }
		}while(ch!=9);
        }
	public void menu(){
        int ch;
	do{
            System.out.println("--- This is Bank Menu ---");
            System.out.println("1.Create New Account");
            System.out.println("2.Show Total Bank Balance");
            System.out.println("3.Show Max and Min Account Balance Holders");
            System.out.println("4.Check for Given Balance");
            System.out.println("5.Check for Given Account");
            System.out.println("6.Check existing account");
            System.out.println("7.Exit");
            System.out.println(">>>Enter Option: ");
            Scanner sc = new Scanner(System.in);
            ch = sc.nextInt();
            switch(ch){
                case 1: this.createAccount();
			break;
		case 2: this.showBankBal();
			break;
		case 3: this.maxMin();
			break;
		case 4: this.checkBal();
			break;
		case 5: this.checkAccount();
			break;
		case 6: this.createexist();
			break;
		case 7: System.exit(0);
		default: System.out.println("Wrong Input !");
	    }
        }while(ch!=9);
        }
	public void getBal(){
            System.out.println(">>>Enter Your Account Number: ");
            Scanner inp=new Scanner(System.in);
            int ac=inp.nextInt();
            int f=1;
		for (int i = 0; i <accounts.size(); i++){
                    if(ac==accounts.get(i).acc){
                        f=0;
                        System.out.println("Your Account Balance is : " + accounts.get(i).bal);
                        break;
                    }
                    else{
                        f=1;
                    }
                }
		if(f==1){
                    System.out.println("Account not found !");
                }
        }
	public void withdrawl(){
            System.out.println(">>>Enter Your Account Number: ");
            Scanner inp=new Scanner(System.in);
            int ac=inp.nextInt();
            int f=1;
            for (int i = 0; i <accounts.size(); i++){
		if(ac==accounts.get(i).acc){
                    int ac1=i;
                    f=0;
                    System.out.println(">>>Enter withdrawl amount: ");
                    int withdraw=inp.nextInt();
                    if(withdraw>accounts.get(i).bal){
                        System.out.println("Insufficient Balance !");
                    }
                    else if(withdraw<=0){
                        System.out.println("Wrong withdrawl amount !");
                    }
                    else{
			accounts.get(ac1).bal-=withdraw;
                        System.out.println("Your Updated Balance is : "+  accounts.get(ac1).bal);
                    }
                    break;
                    }
                else{
                    f=1;
                }
            }
            if(f==1){
                System.out.println("Account not found !");
            }
        }
	public void deposit(){
            System.out.println(">>>Enter Your Account Number : ");
            Scanner inp=new Scanner(System.in);
            int ac=inp.nextInt();
            int f=1;
            for (int i = 0; i <accounts.size(); i++){
                if(ac==accounts.get(i).acc){
                    f=0;
                    int ac1=i;
                    System.out.println(">>>Enter the amount to be deposited : ");
                    int deposit=inp.nextInt();
                    if(deposit<=0){
                        System.out.println("Wrong deposit amount !");
		    }
                    else if(deposit>10000){
                        int a=tax_red(deposit);
                        accounts.get(ac1).bal+=a;
			System.out.println("Your Updated Balance is : "+ accounts.get(ac1).bal);
                    }
                    else{
                        accounts.get(ac1).bal+=deposit;
                        System.out.println("Your Updated Balance is : "+ accounts.get(ac1).bal);
                    }
                    break;
                }
            else{
            	f=1;
            }
            }
            if(f==1){
                System.out.println("Account not found !");
            }
        }
	public int tax_red(int d){
            int x=(int)(d-(.02*d));
            return x;
        }
	void createAccount(){
            System.out.println(">>>Enter Your name: ");
            Scanner sc = new Scanner(System.in);
            String name=sc.nextLine();
            this.acc++;
		accounts.add(new Account(name,this.acc));
            System.out.println("Welcome " +name+" Your Account is successfully created with acc no : " + this.acc);
	}
	private void showBankBal(){
            int total=0;
            for (int i = 0; i <accounts.size(); i++){
		total+=accounts.get(i).bal;
            }
            System.out.println("Total Amount in bank : "+total);
	}
        private void maxMin(){
            int minValue=accounts.get(0).bal;
            for(int i=1;i<accounts.size();i++){
                if(accounts.get(i).bal< minValue){
                    minValue = accounts.get(i).bal;
		}
            }
            int maxValue=accounts.get(0).bal;
            for(int i=1;i<accounts.size();i++){
		if(accounts.get(i).bal> maxValue){
                    maxValue = accounts.get(i).bal;
                }
            }
            System.out.println("Min Balance in Bank : "+minValue);
            System.out.println("Max Balance in Bank : "+maxValue);
	}
	private void checkBal(){
            System.out.println(">>>Enter the amount to be checked... - ");
            Scanner sc=new Scanner(System.in);
            int b=sc.nextInt();
            int count=0;
            for(int i=1;i<accounts.size();i++){
		if(accounts.get(i).bal>= b){
                    count++;
	        }
            }
            System.out.println("Total accounts with balance greater than or equal to "+b+" are : "+count);
            }
	private void checkAccount(){
            System.out.println(">>>Enter Your Account Number : ");
            Scanner inp=new Scanner(System.in);
            int ac=inp.nextInt();
            int f=1;
            for (int i = 0; i <accounts.size(); i++){
		if(ac==accounts.get(i).acc){
                    f=0;
                    System.out.println("Your account was found with Account Balance : " + accounts.get(i).bal);
                    break;
                }
		else{
                    f=1;
                }
            }
            if(f==1){
                System.out.println("Account not found !");
            }
        }
}
public class BankAL{
    public static void main(String[] args){
        int ch;
        Account bk=new Account(2000);  
        Scanner sc=new Scanner(System.in);
        System.out.println("---- Check Into ----");
        System.out.println("1.Existing account");
        System.out.println("2.Bank ");
        System.out.println(">>>Enter Option: ");
        ch=sc.nextInt();
        if(ch==1){
            bk.createexist();
        }
        else{
            bk.menu();
        }
    }
}

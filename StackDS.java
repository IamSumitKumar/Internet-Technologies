/* Implement an Abstract Class Stack with methods push, pop, display for two classes: StaticStack and DyanamicStack.
StaticStack uses one dimensional integer array to store numbers and DyanamicStack uses an integer ArrayList to store.
*/
//!!! Resource @tutorials duniya

package stackds;
import java.util.Scanner;
import java.util.ArrayList;

abstract class Stack{
    int top;
    Stack(){
	this.top = -1;
    }
    abstract void push(int Val);
    abstract int pop();
    abstract void display();
}

class dynamicStack extends Stack{
    ArrayList<Integer> arr;
    dynamicStack(){
	this.arr = new ArrayList();
    }

    void push(int Val){
	this.arr.add(++this.top, Integer.valueOf(Val));
    }

    int pop(){
	if (this.top == -1){
            return -1;
        }
	return ((Integer)this.arr.remove(this.top--)).intValue();
    }

    void display(){
	System.out.print("The Stack is : ");
	for (int i = 0; i <this.arr.size(); i++){
            System.out.print(this.arr.get(i) + " ");
	}
        System.out.println();
    }
}

class staticStack extends Stack{
    int[] arr;
    int size;
    staticStack(int Val){
	this.size = Val;
	this.arr = new int[this.size];
    }

    void push(int Val){
	if (this.top == this.size - 1){
            System.out.println("Overflow");
        }
	else{
            this.arr[(++this.top)] = Val;
	}
    }
    
    int pop(){
	if (this.top == -1){
            return -1;
        }
	return this.arr[(this.top--)];
    }

    void display(){
	System.out.print("The Stack is : ");
	for (int i = 0; i <= this.top; i++){
            System.out.print(this.arr[i] + " ");
	}
	System.out.println();
    }
}

public class StackDS{
    public static void main(String[] args){
	Scanner S = new Scanner(System.in);
	System.out.println("Enter");
	System.out.println("1.staticStack");
	System.out.println("2.dynamicStack");
	System.out.println("3.Exit");
        System.out.println("Enter Choice: ");
	int m = S.nextInt();
	switch (m){
            case 1: System.out.println("Enter array size");
                    int i3 = S.nextInt();
                    staticStack sS = new staticStack(i3);
                    System.out.println("Enter");
                    System.out.println("1.Push");
                    System.out.println("2.Pop");
                    System.out.println("3.Display");
                    int i4;
                    do{
                        System.out.println("Enter your choice");
                        int i = S.nextInt();
                        switch (i){
                            case 1: System.out.println("Enter a number to be pushed into the stack");
                                    int j = S.nextInt();
                                    sS.push(j);
                                    break;

                            case 2: int k = sS.pop();
                                    if (k == -1){
                                        System.out.println("Underflow");
                                    }
                                    else{
                                        System.out.println("Number popped =" + k);
                                    }
                                    break;
                            case 3: sS.display();
			}

			System.out.println("Enter 0 if you want to continue");
			i4 = S.nextInt();
                    } while (i4 == 0);
                    break;
		
            case 2: dynamicStack dS = new dynamicStack();
                    System.out.println("Enter");
                    System.out.println("1.Push");
                    System.out.println("2.Pop");
                    System.out.println("3.Display");
                    for (;;){
			System.out.println("Enter your choice");
			int n = S.nextInt();
                        switch (n){
                            case 1: System.out.println("Enter a number to be pushed into the stack");
                                    int i1 = S.nextInt();
                                    dS.push(i1);
                                    break;
                            case 2: int i2 = dS.pop();
                                    if (i2 == -1){
                                        System.out.println("Underflow");
                                    }
                                    else{
                                        System.out.println("Number popped =" + i2);
                                    }
                                    break;
                            case 3: dS.display();
			}

			System.out.println("Enter 0 if you want to continue");
			int i5 = S.nextInt();
			if (i5 != 0){
                            break;
			}
                    }
                }
        }
}

package subham;
import java.io.*;  
class Stack
{  
char a[]=new char[100];  
int top=-1;  
void push(char c)  
{  
try  
{  
a[++top]= c;  
}  
catch(StringIndexOutOfBoundsException e)  
{  
System.out.println("Stack full, no room to push, size=100");  
System.exit(0);  
}  
}  
char pop()  
{  
return a[top--];  
}  
boolean isEmpty()  
{  
return (top==-1)?true:false;  
}  
char peek()  
{  
return a[top];  
}  
}     
public class main 
{  
static Stack operators = new Stack();         
public static void main(String argv[]) throws IOException  
{  
String infix;  
 
BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));  

System.out.print("\nEnter the infix expression you want to convert: ");  
infix = keyboard.readLine();  
 
System.out.println("Postfix expression for the given infix expression is:" + toPostfix(infix));  
}  
private static String toPostfix(String infix)  
 
{  
char symbol;  
String postfix = "";  
for(int i=0;i<infix.length();++i)  
 
{  
symbol = infix.charAt(i);  
  
if (Character.isLetter(symbol))  
postfix = postfix + symbol;  
else if (symbol=='(')  
 
{  
operators.push(symbol);  
}  
else if (symbol==')')  
 
{  
while (operators.peek() != '(')  
{  
postfix = postfix + operators.pop();  
}  
operators.pop();        
}  
else  

{  
while (!operators.isEmpty() && !(operators.peek()=='(') && prec(symbol) <= prec(operators.peek()))  
postfix = postfix + operators.pop();  
operators.push(symbol);  
}  
}  
while (!operators.isEmpty())  
postfix = postfix + operators.pop();  
return postfix;  
}  
static int prec(char x)  
{  
if (x == '+' || x == '-')  
return 1;  
if (x == '*' || x == '/' || x == '%')  
return 2;  
return 0;  
}  
}    
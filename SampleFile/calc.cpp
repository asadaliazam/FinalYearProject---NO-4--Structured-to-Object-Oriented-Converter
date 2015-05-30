#include<iostream>
using namespace std;
int add(int a,int b);
int sub(int a,int b);
int mul(int a,int b);
float divd(float a,float b);
int main()
{
	int a,b;
	char op;
	cout<<"PLEASE ENTER THE FOLLOWING..	"<<endl;
	cout<<"Integer 1 : ";
	cin>>a;
	cout<<endl;
	cout<<"integer 2 : ";
	cin>>b;
	cout<<endl;
	cout<<"Input the operator ( + , - , * , / ) : ";
	cin>>op;
	cout<<endl;
	if(op=='+')
		cout<<"SUM ( "<<a<<" + "<<b<<" ) = "<<add(a,b)<<endl;
	else if(op=='-')
		cout<<"DIFFERENCE ( "<<a<<" - "<<b<<") = "<<sub(a,b)<<endl;
	else if(op=='*')
		cout<<"PRODUCT ( "<<a<<" * "<<b<<") = "<<mul(a,b)<<endl;
	else if(op=='/')
		cout<<"DIVISION ( "<<a<<" / "<<b<<") = "<<divd(a,b)<<endl;
	else
		cout<<" --> ERROE : unknown operator"<<endl;
}
int add(int a,int b)
{
	int c;
	c=a+b;
	return c;
}
int sub(int a,int b)
{
	int c;
	c=a-b;
	return c;
}
int mul(int a,int b)
{
	int c;
	c=a*b;
	return c;
}
float divd(float a,float b)
{
	float c;
	c=a/b;
	return c;
}

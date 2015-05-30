
#include<iostream>
#include<cstring>
using namespace std;
struct date
{
	int dt;
	int month;
	int year;
};

struct dbs
{
	char bkn[20];
	int isbn;
	char pbn[20];
	char athn[20];
	int ncps;
	int x;
};

struct user
{
	int id;
	char name1[20];
	char name2[20];
	char member[10];
	date dob;
};

struct issue
{
	int isbn;
	int id;
	date curent;
	date last;
};

////// Declaring structure variables globally/////////

dbs var[10];
user temp[4];
issue jack[4];

///////////////////////////////////////////////////////


///////////////Functions prototypes////////////////////
void add_book(dbs[]);
void search_book(dbs[]);
void edit_book (dbs[]);
void delete_book(dbs[]);
void add_library_user(user[]);
void edit_user(user[]);
void search_library_user (user[]);
void issue_book (issue[]);
void delete_library_user (user[]);
/////////////////////////////////////////////////////////

int main()   //// "Main" starts here
{cout<<endl;
	
	cout<<"                         FAST LIBRARY MANAGEMENT SYSTEM"<<endl;
	for (int k=0;k<80;k++)
		cout<<"-";
	cout<<endl<<endl<<endl;

	cout<<"Press option key to activate the required function. "<<endl<<endl;
	cout<<"(0). Add Book"<<endl<<"(1). Edit Book"<<endl<<"(2). Search Book"<<endl<<"(3). Add Library user"<<endl<<"(4). Edit Library user"<<endl<<"(5). Search Library user"<<endl;
cout<<"(6). Issue Book"<<endl<<"(7). Delete Book"<<endl<<"(8). Delete user Information"<<endl<<endl;

	strcpy(var[9].athn,"Bauer");
	strcpy(var[9].bkn,"24");
	var[9].isbn=5678;
	strcpy(var[9].pbn,"CTU");
	var[9].ncps=1000;
	var[9].x=2002;


	strcpy(var[8].athn,"Gibbs");
	strcpy(var[8].bkn,"NCIS");
	var[8].isbn=1234;
	strcpy(var[8].pbn,"NAVAL");
	var[8].ncps=1000;
	var[8].x=2005;

	//temp[1].dob.dt=25; //temp[1].dob.month=01; //temp[1].dob.year=1993;
	temp[1].id=1234; strcpy(temp[1].member,"Student"); strcpy(temp[1].name1,"Shoaib");strcpy(temp[1].name2,"Akhtar");
	//temp[2].dob.dt=15; //temp[2].dob.month=05; //temp[2].dob.year=1976;
	temp[2].id=5678; strcpy(temp[2].member,"Employee"); strcpy(temp[2].name1,"Anthony");strcpy(temp[2].name2,"Dinozzo");



	int opt;
	
	cin>>opt;

	if (opt==0)
		add_book(var);
	


	else if (opt==2)
		search_book(var);
	else if (opt==1)
		edit_book(var);


	else if (opt==3)
	add_library_user(temp);
	else if (opt==4)
		edit_user(temp);
	else if (opt==5)
		search_library_user(temp);
	else if (opt==6)
		issue_book(jack);
	else if (opt==7)
		delete_book(var);
	else if (opt==8)
		delete_library_user(temp);
	else
		cout<<"Wrong option selected!"<<endl<<" Please execute the software again and enter the correct option";


}




void add_book(dbs[])
{
		dbs *ptr;
cout<<"Details of how many books you want to enter?"<<endl<<endl;
	int d;
cin>>d;

ptr=new dbs[d];

cout<<"Enter the detail of books: "<<endl;
for (int i=0;i<d;i++)
{

	cout<<"Author:  "; cin>>ptr[i].athn; cout<<endl<<"Book name:  ";cin>>ptr[i].bkn;cout<<endl<<"ISBN No.  ";cin>>ptr[i].isbn;	
	cout<<endl<<"Information about "<<"'"<<ptr[i].bkn<<"'"<<" has been saved."<<endl<<endl ;
}

delete ptr;
} //// "add_books" ends


void search_book(dbs var[])
{

	cout<<"Enter the index of the option by which you want to search:"<<endl<<endl<<endl<<"0. ISBN Number"<<endl<<"1. Book Name"<<endl<<"2. Author"<<endl<<"3.Book Name";
	cout<<endl<<"4.Publisher"<<endl<<"5. Publishing Year"<<endl;

int opx;
cin>>opx;


if (opx==0)

{

int y;
cout<<"Enter ISBN No. of book: ";
cin>>y;


	for (int i=0;i<10;i++)
	
	{
		if  (y==var[i].isbn)
		{
	cout<<"Book Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<".    "<<"No. of copies: "<<var[i].ncps;
		}
	}
}

else if (opx==1)   // Search by Book Name
{
	char name[20];
	cout<<"Enter Book name: ";
	cin>>name;
	
		for (int i=0;i<10;i++)
		{
			if (strcmp(var[i].bkn,name)==0)
			{
				cout<<"Book Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".    "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<".    "<<"No. of copies: "<<var[i].ncps;
		break;
			}
		}

	
}

else if (opx==2)
{

char name[20];
cout<<"Enter Author's name: ";
	cin>>name;
	
		for (int i=0;i<10;i++)
		{
			if (strcmp(var[i].athn,name)==0)
			{
				cout<<"Book Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<".    "<<"No. of copies: "<<var[i].ncps;
		break;
			}
		}

}

else if (opx==3)
{
	char name[20];
	cout<<"Enter Book name: ";
	cin>>name;
	
		for (int i=0;i<10;i++)
		{
			if (strcmp(var[i].bkn,name)==0)
			{
				cout<<"Book Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".    "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<".    "<<"No. of copies: "<<var[i].ncps;
		break;
			}
		}

}

else if (opx==4)
{
	char name[20];
	cout<<"Enter Publisher name: ";
	cin>>name;
	
		for (int i=0;i<10;i++)
		{
			if (strcmp(var[i].pbn,name)==0)
			{
				cout<<"Book Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<".    "<<"No. of copies: "<<var[i].ncps;
		break;
			}
		}

}

else if (opx==5)
{
	int name;
	cout<<"Enter Publishing year: ";
	cin>>name;
	
		for (int i=0;i<10;i++)
		{
			if (var[i].x==name)
			{
				cout<<"Book Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".   "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<".    "<<"No. of copies: "<<var[i].ncps;
		break;
			}
		}

}

	
}   //// "search_books" end

void edit_book(dbs var[])
{
	cout<<"Indicate the index of the option by which you want to search. "<<endl<<"1.ISBN"<<endl<<"2. Book Name"<<endl<<"3. Author's Name"<<endl;
	cout<<"4. Publisher"<<endl<<"5. Publishing Year"<<endl<<endl;
	int opx;
	cin>>opx;
	if (opx==1)
	{
		int isbn;
		cout<<endl<<endl<<"Enter ISBN Number:  "<<endl;
		cin>>isbn;
		for (int i=0;i<10;i++)
		{
			if (var[i].isbn==isbn)
			{cout<<"Current particulars of book are: "<<endl<<endl;

			cout<<"Book Name: "<<var[i].bkn<<"    "<<"Author: "<<var[i].athn<<"    "<<"Publisher: "<<var[i].pbn<<"  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"    "<<"No. of copies: "<<var[i].ncps<<endl<<endl;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. Book Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
		cout<<"4. Isbn"<<endl<<"5. No of copies"<<endl<<"6. Publishing Year"<<endl<<endl;

		int mod;
		cin>>mod;

		if (mod==1)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter the new name: ";
		cin>>ptr;

			strcpy(var[i].bkn,ptr);
			cout<<"New name of the book is: "<<var[i].bkn<<endl;
			
			
		}

		else if (mod==2)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter the new Author: ";
		cin>>ptr;

			strcpy(var[i].athn,ptr);
			cout<<"New name of the author is: "<<var[i].athn<<endl;
			
			
		}

		else if (mod==3)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter the new Publisher: ";
		cin>>ptr;

			strcpy(var[i].pbn,ptr);
			cout<<"New name of the publisher is: "<<var[i].pbn<<endl;
			
		}

		else if (mod==4)
		{
			int new_var;
			cout<<"Enter the new ISBN No.: ";
		cin>>new_var;
		var[i].isbn=new_var;
cout<<"New ISBN No. is: "<<var[i].isbn<<endl;
			}
else if (mod==5)

			{
			int new_var;
			cout<<"Enter the No. of copies: ";
		cin>>new_var;
		var[i].ncps=new_var;
cout<<"Now No. of copies are: "<<var[i].ncps<<endl;
			}

else if (mod==6)

			{
			int new_var;
			cout<<"Enter the new Publishing Year: ";
		cin>>new_var;
		var[i].x=new_var;
cout<<"New publishing year is: "<<var[i].pbn<<endl;
			}

break;
			}
		}
	}

	if (opx==2)
	{
		char *ptr;
		ptr=new char[20];
		cin>>ptr;

		for (int i=0;i<10;i++)
		{
			if (strcmp(var[i].bkn,ptr)==0)
			{cout<<"Current info is:"<<endl;

			cout<<"Book Name: "<<var[i].bkn<<"    "<<"Author: "<<var[i].athn<<"    "<<"Publisher: "<<var[i].pbn<<"    "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"    "<<"No. of copies: "<<var[i].ncps;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. Book Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
		cout<<"4. Isbn"<<endl<<"5. No of copies"<<endl<<"6. Publishing Year"<<endl<<endl;
		int mod;
		cin>>mod;

		if (mod==1)
		{char *ptr;
		ptr=new char[20];
		cin>>ptr;

			strcpy(var[i].bkn,ptr);
			cout<<"done"<<endl;
		}

		else if (mod==2)
		{
			char *ptr;
		ptr=new char[20];
		cin>>ptr;

			strcpy(var[i].athn,ptr);
			cout<<"done"<<endl;
		}

		else if (mod==3)
		{
			char *ptr;
		ptr=new char[20];
		cin>>ptr;

			strcpy(var[i].pbn,ptr);
			cout<<"done"<<endl;
		}

		else if (mod==4)
		{
			int new_var;
		cin>>new_var;
		var[i].isbn=new_var;
cout<<"done";
			}
else if (mod==5)

			{
			int new_var;
		cin>>new_var;
		var[i].ncps=new_var;
cout<<"done";
			}

else if (mod==6)

			{
			int new_var;
		cin>>new_var;
		var[i].x=new_var;
cout<<"done";
			}
break;
			}
		}
	}
	if (opx==3)
	{
		char *ptr;
		ptr=new char[20];
		cout<<"Enter Author's name:    ";
		cin>>ptr;
		for (int i=0;i<10;i++)
		{
			if (strcmp(var[i].athn,ptr)==0)
			{cout<<"Current info is:"<<endl;

			cout<<"Book Name: "<<var[i].bkn<<"  "<<"Author: "<<var[i].athn<<"  "<<"Publisher: "<<var[i].pbn<<"  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"  "<<"No. of copies: "<<var[i].ncps;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. Book Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
		cout<<"4. Isbn"<<endl<<"5. No of copies"<<endl<<"6. Publishing Year"<<endl<<endl;
		int mod;
		cin>>mod;

		if (mod==1)
		{char *ptr;
		ptr=new char[20];
		cout<<"Enter the new name: ";
		cin>>ptr;

			strcpy(var[i].bkn,ptr);
			cout<<"New name of the book is: "<<var[i].bkn;
		}

		else if (mod==2)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter the new Author: ";
		cin>>ptr;

			strcpy(var[i].athn,ptr);
			cout<<"New name of the Author is: "<<var[i].athn;
		}

		else if (mod==3)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter the new publisher: ";
		cin>>ptr;

			strcpy(var[i].pbn,ptr);
			cout<<"New publisher is: "<<var[i].pbn;
		}

		else if (mod==4)
		{
			int new_var;
		cin>>new_var;
		var[i].isbn=new_var;
cout<<"done";
			}
else if (mod==5)

			{
			int new_var;
			cout<<"Enter new No. of copies: ";
		cin>>new_var;
		var[i].ncps=new_var;
		cout<<"New No. of copies are: "<<var[i].ncps<<".";
			}

else if (mod==6)

			{
			int new_var;
		cin>>new_var;
		var[i].x=new_var;
cout<<"New Publishing year is: "<<var[i].x<<".";
			}
break;
			}
		}
	}
else if (opx==4)
	{
		char *ptr;
		ptr=new char[20];
		cout<<"Enter Publisher's name:    ";
		cin>>ptr;
		for (int i=0;i<10;i++)
		{
			if (strcmp(var[i].pbn,ptr)==0)
			{cout<<"Current detail of book is:"<<endl<<endl;

			cout<<"Book Name: "<<var[i].bkn<<"  "<<"Author: "<<var[i].athn<<"  "<<"Publisher: "<<var[i].pbn<<"  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"  "<<"No. of copies: "<<var[i].ncps;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. Book Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
		cout<<"4. Isbn"<<endl<<"5. No of copies"<<endl<<"6. Publishing Year"<<endl<<endl;
		int mod;
		cin>>mod;

		if (mod==1)
		{char *ptr;
		ptr=new char[20];
		cout<<"Enter new name: ";
		cin>>ptr;

			strcpy(var[i].bkn,ptr);
			cout<<"New name of the book is: "<<var[i].bkn;
		}

		else if (mod==2)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter Auhtor's name: ";
		cin>>ptr;

			strcpy(var[i].athn,ptr);
			cout<<"New author of the book is: "<<var[i].athn;
		}

		else if (mod==3)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter name of new publisher: ";
		cin>>ptr;

			strcpy(var[i].pbn,ptr);
			cout<<"New publisher is: "<<var[i].pbn;
		}

		else if (mod==4)
		{
			int new_var;
			cout<<"Enter new ISBN No. :";
		cin>>new_var;
		var[i].isbn=new_var;
cout<<"New ISBN No. is: "<<var[i].isbn;
			}
else if (mod==5)

			{
			int new_var;
			cout<<"Enter new No. of copies: ";
		cin>>new_var;
		var[i].ncps=new_var;
cout<<"New No. of copies are: "<<var[i].ncps;
			}

else if (mod==6)

			{
			int new_var;
			cout<<"Enter new publishing year:";
		cin>>new_var;
		var[i].x=new_var;
cout<<"New publishing year is: "<<var[i].x<<endl;
			}
break;
			}
		}
	}
if (opx==5)
	{
		int isbn;
		cout<<"Enter Publishing Year:  ";
		cin>>isbn;
		for (int i=0;i<10;i++)
		{
			if (var[i].x==isbn)
			{cout<<"Current detail of book is:"<<endl<<endl;

			cout<<"Book Name: "<<var[i].bkn<<"  "<<"Author: "<<var[i].athn<<"  "<<"Publisher: "<<var[i].pbn<<"  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"  "<<"No. of copies: "<<var[i].ncps<<cout<<endl<<endl;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. Book Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
		cout<<"4. Isbn"<<endl<<"5. No of copies"<<endl<<"6. Publishing Year"<<endl<<endl;

		int mod;
		cin>>mod;

		if (mod==1)
		{char *ptr;
		ptr=new char[20];
		cout<<"Enter new name: ";
		cin>>ptr;

			strcpy(var[i].bkn,ptr);
			cout<<"New name of the book is: "<<var[i].bkn<<endl<<endl;
		}

		else if (mod==2)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter new Author's name: ";
		cin>>ptr;

			strcpy(var[i].athn,ptr);
			cout<<"New Author is: "<<var[i].athn<<endl<<endl;
		}

		else if (mod==3)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter new Publisher's name: ";
		cin>>ptr;

			strcpy(var[i].pbn,ptr);
			cout<<"New Publisher is: "<<var[i].pbn<<endl<<endl;
		}

		else if (mod==4)
		{
			int new_var;
			cout<<"Enter the new ISBN No.: ";
		cin>>new_var;
		var[i].isbn=new_var;
cout<<"New ISBN No. is: "<<var[i].isbn<<endl<<endl;
			}
else if (mod==5)

			{
			int new_var;
			cout<<"Enter the new no. of copies: ";
		cin>>new_var;
		var[i].ncps=new_var;
cout<<"New No. of copies are: "<<var[i].ncps<<endl<<endl;
			}

else if (mod==6)

			{
			int new_var;
			cout<<"Enter new Publishing year: ";
		cin>>new_var;
		var[i].x=new_var;
cout<<"New Publishing year is: "<<var[i].x<<endl<<endl;
			}
break;
			}
		}
	}


}   //////////////  Edit_book ends 

void add_library_user(user [])
{
	user *ptr;
cout<<"Details of how many user you want to enter?"<<endl<<endl;
	int d;
cin>>d;

ptr=new user[d];

cout<<"Enter the detail of user: "<<endl;
for (int i=0;i<d;i++)
{

cout<<"Enter Date of Birth of user: ";cin>>ptr[0].dob.dt;cout<<endl<<"Enter month of birth: ";cin>>ptr[0].dob.month;cout<<endl<<"Enter year of birth: ";cin>>ptr[0].dob.year;cout<<endl<<"Enter id: ";cin>>ptr[0].id;cout<<endl<<"Student or employee? ";cin>>ptr[0].member;cout<<endl<<"Enter first name: ";cin>>ptr[0].name1;cout<<endl<<"Enter second name:";cin>>ptr[0].name2;
	cout<<endl<<endl;
}
cout<<endl<<endl<<"Information saved";



}   /// "add_library_user" ends



void edit_user(user temp[])
{
	cout<<"Enter the index of the option by which you want to search: "<<endl<<"1. Id."<<endl<<"2. First Name."<<endl<<"3. Second Name."<<endl;
	cout<<"4. Date of Birth."<<endl<<endl;
	int opx;
	cin>>opx;
	if (opx==1)
	{
		int id;
		cout<<"Enter Id Number:  ";
		cin>>id;
		for (int i=0;i<10;i++)
		{
			if (temp[i].id==id)
			{cout<<"Current Detail of user is:"<<endl<<endl;

			cout<<"Date of birth of user: "<<temp[i].dob.dt<<".  "<<"Month of birth of user: "<<temp[i].dob.month<<".   "<<"Year of birth of user: "<<temp[i].dob.year<<"  "<<endl;
		cout<<"Membership type: "<<temp[i].member<<".    "<<"Name:  "<<temp[i].name1<<" "<<temp[i].name2;	


		cout<<"Enter the index of the option you want to edit: "<<endl<<endl<<"1. Date of Birth"<<endl<<"2. Id."<<endl<<"3. Membership type."<<endl;
		cout<<"4. First name."<<endl<<"5. Second name."<<endl;

		int mod;
		cin>>mod;

		if (mod==1)
		{int ptr;
		int ptr1;
		int ptr2;
		

		cout<<"Enter date of birth: ";cin>>ptr1;cout<<endl<<"Enter month of birth: ";cin>>ptr2;cout<<"Enter year of birth: ";cin>>ptr;

			temp[i].dob.dt=ptr; temp[i].dob.month=ptr1;temp[i].dob.year=ptr2;
			cout<<"done"<<endl;
		}

		else if (mod==2)
		{
			int ptr;
			cout<<"Enter new Id: ";
		
		cin>>ptr;

			temp[i].id=ptr;
			cout<<endl<<endl<<"Information saved";
		}

		else if (mod==3)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter new membership type: ";
		cin>>ptr;

			strcpy(temp[i].member,ptr);
			cout<<endl<<endl<<"Information saved";
		}

		else if (mod==4)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter first name: ";
		cin>>ptr;

			strcpy(temp[i].name1,ptr);
			cout<<endl<<endl<<"Information saved";
			}
else if (mod==5)

			{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter second name: ";
		cin>>ptr;

			strcpy(temp[i].name2,ptr);
			cout<<endl<<endl<<"Information saved";
			}


break;
			}
		}
	}

	if (opx==2)  // search by 1st name
	{
		char *ptr;
		ptr=new char[20];
		cin>>ptr;

		for (int i=0;i<10;i++)
		{
			if (strcmp(temp[i].name1,ptr)==0)
			{cout<<"Current detail of user is: "<<endl<<endl;cout<<"Date of birth of user: "<<temp[i].dob.dt<<".  "<<"Month of birth of user: "<<temp[i].dob.month<<".   "<<"Year of birth of user: "<<temp[i].dob.year<<"  "<<endl;
		cout<<"Membership type: "<<temp[i].member<<".    "<<"Name:  "<<temp[i].name1<<" "<<temp[i].name2;	


		cout<<"Enter index of the option you want to edit: "<<endl<<endl<<"1. Date of Birth"<<endl<<"2. Id."<<endl<<"3. Membership type."<<endl;
		cout<<"4. First name."<<endl<<"5. Second name."<<endl;
		int mod;
		cin>>mod;

		if (mod==1)
		{
			int ptr,ptr1,ptr2;
			cout<<"Enter information in following format:"<<endl<<"Date of birth"<<endl<<"Month of birth"<<"Year of bith: "<<endl;
		
cin>>ptr>>ptr1>>ptr2;
			temp[i].dob.dt=ptr; temp[i].dob.month=ptr1;temp[i].dob.year=ptr2;
			cout<<"done"<<endl;
		}

		else if (mod==2)
		{
			int ptr;
			cout<<"Enter new id: ";
		
		cin>>ptr;

			temp[i].id=ptr;
			cout<<endl<<endl<<"Information saved"<<endl;
		}

		else if (mod==3)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter new membership type: ";
		cin>>ptr;

			strcpy(temp[i].member,ptr);
			cout<<endl<<endl<<"Information saved"<<endl;
		}

		else if (mod==4)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter first name: ";
		cin>>ptr;

			strcpy(temp[i].name1,ptr);
			cout<<"done"<<endl;cout<<"done"<<endl;
			}
else if (mod==5)

			{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter second name: ";
		cin>>ptr;

			strcpy(temp[i].name2,ptr);
			cout<<endl<<endl<<"Information saved"<<endl;
			}


break;
			}
		}
	}
	if (opx==3)
	{
		char *ptr;
		ptr=new char[20];
		cout<<"2nd name    ";
		cin>>ptr;
		for (int i=0;i<10;i++)
		{
			if (strcmp(temp[i].name2,ptr)==0)
			{cout<<"Current detail of user is: "<<endl<<endl;cout<<"Date of birth of user: "<<temp[i].dob.dt<<".  "<<"Month of birth of user: "<<temp[i].dob.month<<".   "<<"Year of birth of user: "<<temp[i].dob.year<<"  "<<endl;
		cout<<"Membership type: "<<temp[i].member<<".    "<<"Name:  "<<temp[i].name1<<" "<<temp[i].name2;	


		cout<<"Enter index of the option you want to edit: "<<endl<<endl<<"1. Date of Birth"<<endl<<"2. Id."<<endl<<"3. Membership type."<<endl;
		cout<<"4. First name."<<endl<<"5. Second name."<<endl;
		int mod;
		cin>>mod;

		
		if (mod==1)
		{int ptr,ptr1,ptr2;
		cout<<"Enter information in following format:"<<endl<<"Date of birth"<<endl<<"Month of birth"<<"Year of bith: "<<endl;
		
cin>>ptr>>ptr1>>ptr2;
			temp[i].dob.dt=ptr; temp[i].dob.month=ptr1;temp[i].dob.year=ptr2;
			cout<<"Information saved. ";
		}

		else if (mod==2)
		{
			int ptr;
		cout<<"Enter id: ";
		cin>>ptr;

			temp[i].id=ptr;
			cout<<"Information saved. ";
		}

		else if (mod==3)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter new membership type: ";
		cin>>ptr;

			strcpy(temp[i].member,ptr);
			cout<<"Information saved. ";
		}

		else if (mod==4)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter first name: ";
		cin>>ptr;

			strcpy(temp[i].name1,ptr);
			cout<<"Information saved. ";
			}
else if (mod==5)

			{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter second name: ";
		cin>>ptr;

			strcpy(temp[i].name2,ptr);
			cout<<"Information saved. ";
			}


break;
			}
		}
	}
else if (opx==4)
	{
		
		cout<<"dob    ";
		
		int x ,y,z;
		cin>>x;
		cin>>y;
		cin>>z;

		for (int i=0;i<10;i++)
		{
			if (temp[i].dob.dt==x, temp[i].dob.month==y,temp[i].dob.year==z)
			{{cout<<"Current detail of user is: "<<endl<<endl;cout<<"Date of birth of user: "<<temp[i].dob.dt<<".  "<<"Month of birth of user: "<<temp[i].dob.month<<".   "<<"Year of birth of user: "<<temp[i].dob.year<<"  "<<endl;
		cout<<"Membership type: "<<temp[i].member<<".    "<<"Name:  "<<temp[i].name1<<" "<<temp[i].name2;	


		cout<<"Enter index of the option you want to edit: "<<endl<<endl<<"1. Date of Birth"<<endl<<"2. Id."<<endl<<"3. Membership type."<<endl;
		cout<<"4. First name."<<endl<<"5. Second name."<<endl;
		int mod;
		cin>>mod;

		if (mod==1)
		if (mod==1)
		{int ptr,ptr1,ptr2;
		cout<<"Enter information in following format:"<<endl<<"Date of birth"<<endl<<"Month of birth"<<"Year of bith: "<<endl;
		
cin>>ptr>>ptr1>>ptr2;
			temp[i].dob.dt=ptr; temp[i].dob.month=ptr1;temp[i].dob.year=ptr2;
			cout<<"Information saved. "<<endl;
		}

		else if (mod==2)
		{
			int ptr;
		cout<<"Enter new id: ";
		cin>>ptr;

			temp[i].id=ptr;
			cout<<"Information saved. "<<endl;
		}

		else if (mod==3)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter new membership type: ";
		cin>>ptr;

			strcpy(temp[i].member,ptr);
			cout<<"Information saved. "<<endl;
		}

		else if (mod==4)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter first name: ";
		cin>>ptr;

			strcpy(temp[i].name1,ptr);
			cout<<"Information saved. "<<endl;
			}
else if (mod==5)

			{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter second name: ";
		cin>>ptr;

			strcpy(temp[i].name2,ptr);
			cout<<"Information saved. "<<endl;
			}


break;
			}
		}
	}


} 
}  //////////////  edit_user ends

void search_library_user(user temp[])
{
cout<<"Enter the index of the option you want to search by:"<<endl<<endl<<endl<<"0. Id"<<endl<<"1. First Name"<<endl<<"2. Second name"<<endl<<"3.Date of birth";
	

int opx;
cin>>opx;


if (opx==0)  // Search bi Id

{

int y;
cout<<"Enter Id: ";
cin>>y;


	for (int i=0;i<10;i++)
	
	{
		if  (temp[i].id==y)
		{
	cout<<"First name "<<temp[i].name1<<".    "<<"name2: "<<temp[i].name2<<".    "<<"id "<<temp[i].id<<".  "<<endl;
		cout<<"membership: "<<temp[i].member<<".    "<<"dob:  "<<temp[i].dob.year;
		}
	}
}

else if (opx==1)   // Search by 1st Name
{
	char name[20];
	cout<<"Enter First  name: ";
	cin>>name;
	
		for (int i=0;i<10;i++)
		{
			if (strcmp(temp[i].name1,name)==0)
			{
				cout<<"First name "<<temp[i].name1<<".    "<<"name2: "<<temp[i].name2<<".    "<<"id "<<temp[i].id<<".  "<<endl;
		cout<<"membership: "<<temp[i].member<<".    "<<"dob:  "<<temp[i].dob.year;
		break;
			}
		}

	
}

else if (opx==2)
{

char name[20];
cout<<"Enter second name: ";
	cin>>name;
	
		for (int i=0;i<10;i++)
		{
			if (strcmp(temp[i].name2,name)==0)
			{
				cout<<"First name "<<temp[i].name1<<".    "<<"name2: "<<temp[i].name2<<".    "<<"id "<<temp[i].id<<".  "<<endl;
		cout<<"membership: "<<temp[i].member<<".    "<<"dob:  "<<temp[i].dob.year;
		break;
			}
		}

}

else if (opx==3)
{
	int x ,y,z;
	cout<<"Enter the detail in following format:"<<endl<<endl<<"Date of birth"<<endl<<"Month of birth"<<endl<<"Year of birth"<<endl<<endl;
		cin>>x;
		cin>>y;
		cin>>z;

		for (int i=0;i<10;i++)
		{
			if (temp[i].dob.dt==x, temp[i].dob.month==y,temp[i].dob.year==z)
			{

			cout<<"First name "<<temp[i].name1<<".    "<<"name2: "<<temp[i].name2<<".    "<<"id "<<temp[i].id<<".  "<<endl;
		cout<<"membership: "<<temp[i].member<<".    "<<"dob:  "<<temp[i].dob.year;
		break;
			}
		}

}



}  /////////// "search_library_user" ends

void issue_book(issue jack[])
{
	cout<<"How many books you want to be issued: "<<endl;
	int d;
int isbn, id;

cin>>d;


issue *ptr;
ptr=new issue [d];


for (int i=0;i<d;i++)
{
	cout<<"Enter the ISBN No. of book: ";
	cin>>isbn;
	ptr[i].isbn=isbn;
	cout<<endl<<"Enter id of the user: ";
	cin>>id;
	ptr[i].id=id;
	cout<<endl<<"Enter issuing date(Date, month, year seperately): ";
	cin>>ptr[i].curent.dt>>ptr[i].curent.month>>ptr[i].curent.year;
	cout<<"Enter Returning date(Date, month, year seperately): ";
	cin>>ptr[i].last.dt>>ptr[i].last.month>>ptr[i].last.year;

	cout<<"Book issued to: "<<ptr[i].id<<endl<<endl;
}
delete ptr;


}   ////////////// "issue_book" ends


void delete_book(dbs var[])
{
	cout<<"Enter ISBN No. of the book you want to delete: ";
	int i;
	cin>>i;
	for (int j=0;j<10;j++)
	{
		if (var[j].isbn==i)
		{
			strcpy(var[j].bkn,"       ");
			strcpy(var[j].athn,"       ");
			strcpy (var[j].pbn,"       ");
			var[j].isbn=0;
			var[j].ncps=0;
			var[j].x=0;
			cout<<"done";
		}

	}
}     /////////// "delete_book" ends


void delete_library_user(user temp[])
{
	cout<<"Enter ID.No of the user: ";
	int k;
	cin>>k;

	for (int i=0;i<4;i++)
	{
		if (temp[i].id==k)
		{
			strcpy(temp[i].member,"     ");
			strcpy(temp[i].name1, "      ");
			strcpy( temp[i].name2, "      ");
			temp[i].dob.dt=0;
			temp[i].dob.month=0;
			temp[i].dob.year=0;
			cout<<"Information deleted"<<endl<<endl;
		}
	}
}       //// "delete_library_user" ends










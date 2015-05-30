
#include<iostream>
#include<cstring>
using namespace std;


struct data
{
	char bkn[20];
	int isbn;
	char pbn[20];
	char athn[20];
	int ncps;
	int x;
};

struct course
{
	int id;
	char name1[20];
	char name2[20];
	char member[10];
};

struct issue
{
	int isbn;
	int id;
};

////// Declaring structure variables globally/////////

data var[10];
course temp[4];
issue jack[4];

///////////////////////////////////////////////////////


///////////////Functions prototypes////////////////////
void add_student(data[]);
void search_student(data[]);
void edit_student (data[]);
void delete_student(data[]);
void add_library_course(course[]);
void edit_course(course[]);
void search_library_course (course[]);
void issue_student (issue[]);
void delete_library_course (course[]);
/////////////////////////////////////////////////////////

int main()   //// "Main" starts here
{cout<<endl;
	
	cout<<"                         STUDENT MANAGEMENT SYSTEM"<<endl;
	for (int k=0;k<80;k++)
		cout<<"-";
	cout<<endl<<endl<<endl;
	
	cout<<"Add student"<<endl;
	cout<<"Edit student"<<endl;
	cout<<"Search student"<<endl;
	cout<<"Add Library course"<<endl;
	cout<<"Edit Library course"<<endl;
	cout<<"Search Library course"<<endl;
	cout<<"Issue student"<<endl;
	cout<<"Delete student"<<endl;
	cout<<"Delete course Information"<<endl<<endl;

	

	int opt;
	
	cin>>opt;

	if (opt==0)
		add_student(var);
	


	else if (opt==2)
		search_student(var);
	else if (opt==1)
		edit_student(var);


	else if (opt==3)
	add_library_course(temp);
	else if (opt==4)
		edit_course(temp);
	else if (opt==5)
		search_library_course(temp);
	else if (opt==6)
		issue_student(jack);
	else if (opt==7)
		delete_student(var);
	else if (opt==8)
		delete_library_course(temp);
	else
		cout<<"Wrong option selected!"<<endl<<" Please execute the software again and enter the correct option";


}




void add_student(data[])
{
		data *ptr;
cout<<"Details of how many students you want to enter?"<<endl<<endl;
	int d;
cin>>d;

ptr=new data[d];

cout<<"Enter the detail of students: "<<endl;
for (int i=0;i<d;i++)
{

	cout<<"Author:  "; cin>>ptr[i].athn; cout<<endl<<"student name:  ";cin>>ptr[i].bkn;cout<<endl<<"ISBN No.  ";cin>>ptr[i].isbn;	
	cout<<endl<<"Information about "<<"'"<<ptr[i].bkn<<"'"<<" has been saved."<<endl<<endl ;
}

delete ptr;
} //// "add_students" ends


void search_student(data var[])
{

	cout<<"Enter the index of the option by which you want to search:"<<endl<<endl<<endl<<"0. ISBN Number"<<endl<<"1. student Name"<<endl<<"2. Author"<<endl<<"3.student Name";
	cout<<endl<<"4.Publisher"<<endl<<"5. Publishing Year"<<endl;

int opx;
cin>>opx;


if (opx==0)

{

int y;
cout<<"Enter ISBN No. of student: ";
cin>>y;


	for (int i=0;i<10;i++)
	
	{
		if  (y==var[i].isbn)
		{
	cout<<"student Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<".    "<<"No. of copies: "<<var[i].ncps;
		}
	}
}

else if (opx==1)   // Search by student Name
{
	char name[20];
	cout<<"Enter student name: ";
	cin>>name;
	
		for (int i=0;i<10;i++)
		{
			if (strcmp(var[i].bkn,name)==0)
			{
				cout<<"student Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".    "<<endl;
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
				cout<<"student Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<".    "<<"No. of copies: "<<var[i].ncps;
		break;
			}
		}

}

else if (opx==3)
{
	char name[20];
	cout<<"Enter student name: ";
	cin>>name;
	
		for (int i=0;i<10;i++)
		{
			if (strcmp(var[i].bkn,name)==0)
			{
				cout<<"student Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".    "<<endl;
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
				cout<<"student Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".  "<<endl;
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
				cout<<"student Name: "<<var[i].bkn<<".    "<<"Author: "<<var[i].athn<<".    "<<"Publisher: "<<var[i].pbn<<".   "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<".    "<<"No. of copies: "<<var[i].ncps;
		break;
			}
		}

}

	
}   //// "search_students" end

void edit_student(data var[])
{
	cout<<"Indicate the index of the option by which you want to search. "<<endl<<"1.ISBN"<<endl<<"2. student Name"<<endl<<"3. Author's Name"<<endl;
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
			{cout<<"Current particulars of student are: "<<endl<<endl;

			cout<<"student Name: "<<var[i].bkn<<"    "<<"Author: "<<var[i].athn<<"    "<<"Publisher: "<<var[i].pbn<<"  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"    "<<"No. of copies: "<<var[i].ncps<<endl<<endl;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. student Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
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
			cout<<"New name of the student is: "<<var[i].bkn<<endl;
			
			
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

			cout<<"student Name: "<<var[i].bkn<<"    "<<"Author: "<<var[i].athn<<"    "<<"Publisher: "<<var[i].pbn<<"    "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"    "<<"No. of copies: "<<var[i].ncps;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. student Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
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

			cout<<"student Name: "<<var[i].bkn<<"  "<<"Author: "<<var[i].athn<<"  "<<"Publisher: "<<var[i].pbn<<"  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"  "<<"No. of copies: "<<var[i].ncps;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. student Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
		cout<<"4. Isbn"<<endl<<"5. No of copies"<<endl<<"6. Publishing Year"<<endl<<endl;
		int mod;
		cin>>mod;

		if (mod==1)
		{char *ptr;
		ptr=new char[20];
		cout<<"Enter the new name: ";
		cin>>ptr;

			strcpy(var[i].bkn,ptr);
			cout<<"New name of the student is: "<<var[i].bkn;
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
			{cout<<"Current detail of student is:"<<endl<<endl;

			cout<<"student Name: "<<var[i].bkn<<"  "<<"Author: "<<var[i].athn<<"  "<<"Publisher: "<<var[i].pbn<<"  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"  "<<"No. of copies: "<<var[i].ncps;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. student Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
		cout<<"4. Isbn"<<endl<<"5. No of copies"<<endl<<"6. Publishing Year"<<endl<<endl;
		int mod;
		cin>>mod;

		if (mod==1)
		{char *ptr;
		ptr=new char[20];
		cout<<"Enter new name: ";
		cin>>ptr;

			strcpy(var[i].bkn,ptr);
			cout<<"New name of the student is: "<<var[i].bkn;
		}

		else if (mod==2)
		{
			char *ptr;
		ptr=new char[20];
		cout<<"Enter Auhtor's name: ";
		cin>>ptr;

			strcpy(var[i].athn,ptr);
			cout<<"New author of the student is: "<<var[i].athn;
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
			{cout<<"Current detail of student is:"<<endl<<endl;

			cout<<"student Name: "<<var[i].bkn<<"  "<<"Author: "<<var[i].athn<<"  "<<"Publisher: "<<var[i].pbn<<"  "<<endl;
		cout<<"Publishing Year: "<<var[i].x<<"  "<<"No. of copies: "<<var[i].ncps<<cout<<endl<<endl;	


		cout<<"Select the required index of the option you want to edit."<<endl<<endl<<"1. student Name"<<endl<<"2. Author's Name"<<endl<<"3. Publisher"<<endl;
		cout<<"4. Isbn"<<endl<<"5. No of copies"<<endl<<"6. Publishing Year"<<endl<<endl;

		int mod;
		cin>>mod;

		if (mod==1)
		{char *ptr;
		ptr=new char[20];
		cout<<"Enter new name: ";
		cin>>ptr;

			strcpy(var[i].bkn,ptr);
			cout<<"New name of the student is: "<<var[i].bkn<<endl<<endl;
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


}   //////////////  Edit_student ends 

void add_library_course(course [])
{
	course *ptr;
cout<<"Details of how many course you want to enter?"<<endl<<endl;
	int d;
cin>>d;

ptr=new course[d];

cout<<"Enter the detail of course: "<<endl;
for (int i=0;i<d;i++)
{

cout<<endl<<"Enter id: ";cin>>ptr[0].id;cout<<endl<<"Student or employee? ";cin>>ptr[0].member;cout<<endl<<"Enter first name: ";cin>>ptr[0].name1;cout<<endl<<"Enter second name:";cin>>ptr[0].name2;
	cout<<endl<<endl;
}
cout<<endl<<endl<<"Information saved";



}   /// "add_library_course" ends



void edit_course(course temp[])
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
			{cout<<"Current Detail of course is:"<<endl<<endl;

			
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
			{
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
			{
		cout<<"Membership type: "<<temp[i].member<<".    "<<"Name:  "<<temp[i].name1<<" "<<temp[i].name2;	


		cout<<"Enter index of the option you want to edit: "<<endl<<endl<<"1. Date of Birth"<<endl<<"2. Id."<<endl<<"3. Membership type."<<endl;
		cout<<"4. First name."<<endl<<"5. Second name."<<endl;
		int mod;
		cin>>mod;

		
		if (mod==1)
		{int ptr,ptr1,ptr2;
		cout<<"Enter information in following format:"<<endl<<"Date of birth"<<endl<<"Month of birth"<<"Year of bith: "<<endl;
		
cin>>ptr>>ptr1>>ptr2;
			
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
			if (1)
			{{
		cout<<"Membership type: "<<temp[i].member<<".    "<<"Name:  "<<temp[i].name1<<" "<<temp[i].name2;	


		cout<<"Enter index of the option you want to edit: "<<endl<<endl<<"1. Date of Birth"<<endl<<"2. Id."<<endl<<"3. Membership type."<<endl;
		cout<<"4. First name."<<endl<<"5. Second name."<<endl;
		int mod;
		cin>>mod;

		

		if (mod==2)
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
}  //////////////  edit_course ends

void search_library_course(course temp[])
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
		cout<<"membership: "<<temp[i].member;
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
		cout<<"membership: "<<temp[i].member;
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
		cout<<"membership: "<<temp[i].member;
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
			if (1)
			{

			cout<<"First name "<<temp[i].name1<<".    "<<"name2: "<<temp[i].name2<<".    "<<"id "<<temp[i].id<<".  "<<endl;
		cout<<"membership: "<<temp[i].member;
		break;
			}
		}

}



}  /////////// "search_library_course" ends

void issue_student(issue jack[])
{
	cout<<"How many students you want to be issued: "<<endl;
	int d;
int isbn, id;

cin>>d;


issue *ptr;
ptr=new issue [d];


for (int i=0;i<d;i++)
{
	cout<<"Enter the ISBN No. of student: ";
	cin>>isbn;
	ptr[i].isbn=isbn;
	cout<<endl<<"Enter id of the course: ";
	cin>>id;
	ptr[i].id=id;
	cout<<endl<<"Enter issuing date(Date, month, year seperately): ";
	
	cout<<"Enter Returning date(Date, month, year seperately): ";
	

	cout<<"student issued to: "<<ptr[i].id<<endl<<endl;
}
delete ptr;


}   ////////////// "issue_student" ends


void delete_student(data var[])
{
	cout<<"Enter ISBN No. of the student you want to delete: ";
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
}     


void delete_library_course(course temp[])
{
	cout<<"Enter ID.No of the course: ";
	int k;
	cin>>k;

	for (int i=0;i<4;i++)
	{
		if (temp[i].id==k)
		{
			strcpy(temp[i].member,"     ");
			strcpy(temp[i].name1, "      ");
			strcpy( temp[i].name2, "      ");
			
			
			
			cout<<"Information deleted"<<endl<<endl;
		}
	}
}       //// "delete_library_course" ends










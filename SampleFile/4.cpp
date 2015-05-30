#include <iostream>

using namespace std;
    struct teacher
    {
        string teacher_name;
        string Course;
    };
    struct student
    {
        string student_name;
        string Roll_No;

    };
    struct departmnet
    {
        string dep;
        teacher teachers;
        student students;
    };


int main()
{
    string str;
    char ch,ch1;
        int size,size1,size2;
        /////////////////////////////////////////////////////////

        int *ptr1;

        ////////////////////
        int *ptr2;
        ///////////////////
        cout<<"How many departments you want to add :";
        cin>>size;
        int *ptr;
        ptr=new int[size];
        departmnet arr[size][size];
        int count1=1;
        int count2=1;
// this Main loop is used to get the data of the department
        for(int i=0; i<size; i++)
        {
            cout<<"Enter name of the department :";
            cin>>arr[i][0].dep;
// this loop is used to get the data of the teachers
            cout<<"How many teachers you want to add :";
            cin>>size1;
            ptr1=new int[size1];
            for(int j=0; j<size1; j++)
            {
                cout<<"Enter the name of the teacher "<<count1++<<" :";
                cin>>arr[i][j].teachers.teacher_name;
                cout<<"Enter the name of the course :";
                cin>>arr[i][j].teachers.Course;
            }count1=1;

            cout<<"information of the students "<<endl;
            // this loop is used to get the data of the students
            cout<<endl;
            cout<<"How many students you want to add :";
            cin>>size2;
            ptr2=new int[size2];
            for(int k=0; k<size2; k++)
            {
                cout<<"Enter the name of the student "<<count2++<<" :";
                cin>>arr[i][k].students.student_name;
                cout<<"Enter the Roll_No of the student :";
                cin>>arr[i][k].students.Roll_No;
            }count2=1;

        }

        /*this part of the program is for dispalying the output*/
       // for to display the data stored.

        for(int j=0; j<size; j++)
        {
            cout<<"In the department ::"<<arr[j][0].dep<<":: department"<<endl;
   ///////////////this is to output the teachers data//////////////////////////////
            for(int k=0; k<size1; k++)
            {
                cout<<"Name of the teacher : ";
                cout<<arr[j][k].teachers.teacher_name<<endl;
                cout<<"Teaches the course of : ";
                cout<<arr[j][k].teachers.Course<<endl;
            }
            cout<<"information of the students "<<endl<<endl;
            for(int x=0; x<size2; x++)
            {
                cout<<"student Name is : ";
                cout<<arr[j][x].students.student_name<<endl;
                cout<<"Roll_No of the student is : ";
                cout<<arr[j][x].students.Roll_No<<endl;
            }

        }


    ////////////////////*searching the department and its EDDITING *///////////////
        int cnt=0;
       do
{
        cout<<"which department you want eddit"<<endl<<endl;
        cin>>str;

        if(arr[0][0].dep==str) //searching for first Row
        {   ////////////////////////////////////////////////////////////////////////////////////////
            cout<<"In the department ::"<<arr[0][0].dep<<":: department"<<endl;

            for(int k=0; k<size1; k++)
            {
                cout<<"Name of the teacher is : "<<arr[0][k].teachers.teacher_name<<endl;//workink area
                cout<<"do you want to change this teacher name [y/n]:";
                cin>>ch1;
                if(ch1=='y')
               {
                    cout<<"Enter new name :";
                    cin>>str;
                    arr[0][k].teachers.teacher_name=str;
               }

                if(ch1=='n'|| ch1=='y')
               {
                    cout<<"Teaches the course of : "<<arr[0][k].teachers.Course<<endl;
                    cout<<"do you want to change his course [y/n]:";
                    cin>>ch1;
                    if(ch1=='y')
                    {   cout<<"Enter the course for him :";
                        cin>>str;
                        arr[0][k].teachers.Course=str;
                    }else{cout<<"you havn't change anything"<<endl;}
               }// working area


            }
            cout<<"information of the students "<<endl<<endl;
            for(int x=0; x<size2; x++)
            {
                cout<<"student Name is : "<<arr[0][x].students.student_name<<endl;
                cout<<"do you want to change his name [y/n]:";
                cin>>ch1;
                if(ch1=='y')
                {   cout<<"Enter new name for him:";
                    cin>>str;
                    arr[0][x].students.student_name=str;
                }
                    if(ch1=='n'|| ch1=='y')
                    {
                        cout<<"Roll_No of the student is : "<<arr[0][x].students.Roll_No<<endl;
                        cout<<"do you want to change his name [y/n]:";
                        cin>>ch1;
                        if(ch1=='y')
                        {
                            cout<<"Enter new Roll_No :";
                            cin>>str;
                            arr[0][x].students.Roll_No=str;
                        }}}}
        else
            if(arr[1][0].dep==str)
        {   ///////////strt

            cout<<"In the department ::"<<arr[1][0].dep<<":: department"<<endl;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            for(int k=0; k<size1; k++)
            {
                cout<<"Name of the teacher is : "<<arr[1][k].teachers.teacher_name<<endl;//workink area
                cout<<"do you want to change this teacher name [y/n]:";
                cin>>ch1;
                if(ch1=='y')
               {
                    cout<<"Enter new name :";
                    cin>>str;
                    arr[1][k].teachers.teacher_name=str;
               }

                if(ch1=='n'|| ch1=='y')
               {
                    cout<<"Teaches the course of : "<<arr[1][k].teachers.Course<<endl;
                    cout<<"do you want to change his course [y/n]:";
                    cin>>ch1;
                    if(ch1=='y')
                    {   cout<<"Enter the course for him :";
                        cin>>str;
                        arr[1][k].teachers.Course=str;
                    }
               }// working area


            }
            cout<<"information of the students "<<endl<<endl;
            for(int x=0; x<size2; x++)
            {
                cout<<"student Name is : "<<arr[1][x].students.student_name<<endl;
                cout<<"do you want to change his name [y/n]:";
                cin>>ch1;
                if(ch1=='y')
                {   cout<<"Enter new name for him:";
                    cin>>str;
                    arr[1][x].students.student_name=str;
                }
                    if(ch1=='n'|| ch1=='y')
                    {
                        cout<<"Roll_No of the student is : "<<arr[1][x].students.Roll_No<<endl;
                        cout<<"do you want to change his name [y/n]:";
                        cin>>ch1;
                        if(ch1=='y')
                        {
                            cout<<"Enter new Roll_No :";
                            cin>>str;
                            arr[1][x].students.Roll_No=str;
                        }}}}





        cout<<"do you want to search more [y/n] :";
        cin>>ch;
        cnt++;
        }while(ch=='y');


  //////////////////updated after the edditing and searching/////////////////////////////////////


            for(int j=0; j<size; j++)
        {
            cout<<"In the department ::"<<arr[j][0].dep<<":: department"<<endl;

            for(int k=0; k<size1; k++)
            {
                cout<<"Name of the teacher : ";
                cout<<arr[j][k].teachers.teacher_name<<endl;
                cout<<"Teaches the course of : ";
                cout<<arr[j][k].teachers.Course<<endl;
            }
            cout<<"information of the students "<<endl<<endl;
            for(int x=0; x<size2; x++)
            {
                cout<<"student Name is : ";
                cout<<arr[j][x].students.student_name<<endl;
                cout<<"Roll_No of the student is : ";
                cout<<arr[j][x].students.Roll_No<<endl;
            }
            cout<<endl<<endl;

        }

    ///////////*searching agian department just to see the effect of updation the *////////////////////////
        int cnt1=0;
do
{
        cout<<"which department you want to search again :"<<endl<<endl;
        cin>>str;

        if(arr[0][0].dep==str)
        {
            cout<<"In the department ::"<<arr[0][0].dep<<":: department"<<endl;

            for(int k=0; k<size1; k++)
            {
                cout<<"Name of the teacher : ";
                cout<<arr[0][k].teachers.teacher_name<<endl;
                cout<<"Teaches the course of : ";
                cout<<arr[0][k].teachers.Course<<endl;
            }
            cout<<"information of the students "<<endl<<endl;
            for(int x=0; x<size2; x++)
            {
                cout<<"student Name is : ";
                cout<<arr[0][x].students.student_name<<endl;
                cout<<"Roll_No of the student is : ";
                cout<<arr[0][x].students.Roll_No<<endl;
            }

        }
        else
            if(arr[1][0].dep==str)
        {   ///////////strt
            cout<<endl<<endl<<endl<<endl;
            cout<<"In the department ::"<<arr[1][0].dep<<":: department"<<endl;

            for(int k=0; k<size1; k++)
            {
                cout<<"Name of the teacher : ";
                cout<<arr[1][k].teachers.teacher_name<<endl;
                cout<<"Teaches the course of : ";
                cout<<arr[1][k].teachers.Course<<endl;
            }
            cout<<"information of the students "<<endl<<endl;
            for(int x=0; x<size2; x++)
            {
                cout<<"student Name is : ";
                cout<<arr[1][x].students.student_name<<endl;
                cout<<"Roll_No of the student is : ";
                cout<<arr[1][x].students.Roll_No<<endl;
            }



        }


    cnt1++;
    cout<<"do you want to seach Again [y/n] :";
    cin>>ch1;
}while(ch1=='y');





    return 0;
}




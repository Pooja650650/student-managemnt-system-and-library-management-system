import java.util.Scanner;
class student {
                String name;
                String reg_no;
                String contact;
               student(String name,String reg_no, String contact){
                   this.name=name;
                   this.reg_no=reg_no;
                   this.contact=contact;
               }
               void display(){
                   System.out.println("student name :" +name);
                   System.out.println("registration number :"+reg_no);
                   System.out.println("contact number :"+contact);
               }
    
            }
    class management{
            student[] s1 = new student[100];
            int count=0;
               void addstudent(String name,String reg_no, String contact){
                      s1[count] = new student(name,reg_no,contact);
                      count++;
                      System.out.println("student added successfully");
               }
               void showstudent(){
                   if(count==0){
                       System.out.println("empty");
                       return;
                   }
                   for(int i=0;i<count;i++){
                       s1[i].display();
                   }
               }
    }
class sms{    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
         management m = new management();
         
         int choice;
         do{
         System.out.println("1.add student");
         System.out.println("2.show student");
         System.out.println("3.Exit");
         
          System.out.println("enter your choice:");
          choice = sc.nextInt();
          
          switch(choice){
                        
              case 1 : 
			            sc.nextLine();
			         System.out.println("Enter student name:");
                      String name = sc.nextLine();
                      System.out.println("enter student reg_no");
                      String reg_no = sc.nextLine();
                      System.out.println("enter student contact");
                      String contact = sc.nextLine();
                      m.addstudent(name,reg_no,contact);
                      break;
            case 2 : m.showstudent();
                     break;
            case 3 : System.out.println("exiting program");
                     break;
            default: System.out.println("invalid choice");         
          }
         }while(choice!=3);
    }
}


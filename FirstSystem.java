// HUB CLASS
import java.util.Scanner;
/**
 * @author Yousef Abdelrahman | 202301656
 */
public class Hub {
    public static void main(String[] args) {
        //Declaration and Initiation
        CommandsExecuting Student;
        Student=new CommandsExecuting();
        Scanner input=new Scanner(System.in);
        String userInput=null;
        String[] arrayCommands={"/h","/r","/s","/p","/e"};
        boolean loop=true;//to controle the loop
        
        //Start of program(Hub section)
        print_();
        System.out.println("\tWelcome to Yousef's collage"
                + "\n\t   (enter \'/h\' to help)");
        print_();
        //while loop that pervent the program to end till the user ends his needs
        while(true){
            while(loop){    //user input
                userInput=input.nextLine();
                    if(checker(userInput)){
                        for(int i=0;i<arrayCommands.length;i++){
                //check if the command was a valid command or not
                            if(userInput.equals(arrayCommands[i])){
                                loop=false;break;
                            }else if(i==arrayCommands.length-1){System.out.println(userInput+" is invalid command\n");}
                        }
                    }else{System.out.println("\'"+userInput+"\' is not a command\n");}
            }//Command Executing
            loop=true;
            Student.CommandCaller(userInput.charAt(1));
            print_();
            if(userInput.charAt(1)=='e'){break;}
            System.out.println("|Enter \'/h\' to help|");
        }
    }
    //Method that checks if the user input was a command or not
    public static boolean checker(String userInput){
        char check=userInput.charAt(0);
        boolean command=false;
            if(check=='/'){command=true;}
        return command;
    }
    //print function
    public static void print_(){
    for(int i=0;i<=23;i++){System.out.print("--");}System.out.print("\n");
    }
}

// CommandsExecuting CLASS


public class CommandsExecuting {
    //Data Field
    public String StudentName;
    String StudentId;
    private String StudentPassword;
    public float StudentAverage;
    private String Email;
    int PhoneNumber;
    
    boolean Boolean=true,Allow=false,registered=false;//To custom the loops
    //Methods
    /*Constructors*/
    public CommandsExecuting(){
       this("Guest 1","oyaGuest@details.com",780000001); 
    }
    public CommandsExecuting(String StudentName,String Email,int PhoneNumber){
        checkStudentName(StudentName);
        checkEmail(Email);
        checkPhoneNumber(PhoneNumber);
        /*id and password*/
        StudentIdMaker();
        PasswordMaker();
    }
    /*Command Methods*/
    public void CommandCaller(char command){
        if(command=='h'){helpCommand();}
        else if(command=='r'){
            if(registered)
                System.out.println("\"You Have Registered\"");
            else
                registrationCommand();
            }
        else if(command=='s'){
                if(PhoneNumber!=780000001&&Email!="oyaGuest@details.com"){//Check if the user has registered
                    System.out.println(toString());
                }else{
                    System.out.println("You Need To Register First!");
                }
            }
        else if(command=='p'){
            if(PhoneNumber!=780000001&&Email!="oyaGuest@details.com"){//Check if the user has registered
                    ChangePasswordCommand();
                }else{
                    System.out.println("You Need To Register First!");
                }
            }
        else if(command=='e'){exitCommand();}
    }
    public void helpCommand(){
        System.out.println("You should type one of the commands."
                + " Here's all the commands\n\'/h\' to help\n"
                + "\'/r\' to registration\n\'/s\' to show Student info\n"
                + "\'/p\' to change the password\n\'/e\' to end the program");
    }
    public void registrationCommand(){
        Boolean=true;
        Scanner input=new Scanner(System.in);
        System.out.print("\t--Registration interface--\n"
                + "\"You should type your name in 2 syllables, Your average\n"
                + "in high school, your email and your phone number\"\n"
        +"\nStarting with your average: "); 
            /*Submitting The Average*/
            while(Boolean){
                StudentAverage=input.nextFloat();
                checkStudentAverage(StudentAverage);
            }
            /*is the Average allowed?*/
            if(Allow){
                Boolean=true;
                System.out.print("\n\n\tSubmitting the name");
            }
            /*Student Name*/
            while(Boolean){
                StudentName=input.nextLine();
                checkStudentName(StudentName);
            }
            Boolean=true;
            /*Student's Email*/
            System.out.print("\nNow please enter your Email: ");
            while(Boolean){
                Email=input.nextLine();
                checkEmail(Email);
            }
            Boolean=true;
            /*Student's Phone Number*/
            System.out.print("And last, Enter your phone number(07########): ");
            while(Boolean){
                PhoneNumber=input.nextInt();
                checkPhoneNumber(PhoneNumber);
            }Boolean=true;
            /*Finish Submitting*/
            System.out.println("\nCongrats "+StudentName+"!\n"
                    + "You're now officially a Student at Yousef's college");
            
            StudentIdMaker();//creat an id
            
            PasswordMaker();//creat a defualt password
            registered=true;
    }
    public void ChangePasswordCommand(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter your phone number to verification:");
        int checkPhone=input.nextInt();
        if(checkPhone==PhoneNumber){
            System.out.println("\nPassword lingth should be between 6 - 18 indices:");
            while(Boolean){
            StudentPassword=input.nextLine();
            setStudentPassword(StudentPassword);
            }Boolean=true;
        }else
            System.out.println("Incorrect Number");
        
    }
    public void exitCommand(){
        System.out.println("\nThis is the end of the program Thanks for your time"
                + "\n\tHave A Good Day!");
    }
    /*Checker Methods*/
    private void checkStudentName(String StudentName){
        if(StudentName.indexOf(" ")!= -1){
            this.StudentName=StudentName;
            Boolean=false;}
        else
            System.out.print("\n\"Your Name Must Be In 2 Syllables\"\n"
                    + "Please enter your name: ");
    }
    private void checkStudentAverage(float StudentAverage){
        if(StudentAverage>=65.0&&StudentAverage<=100.0){
            System.out.println("============");
            if(StudentAverage>=75.0)
                System.out.print("Available majors:\n"
                        + "[Artificial intelligence, Cyber ​​security, Software Engineering,"
                        + "Computer science ,Computer Engineering]");
            else if(StudentAverage>=65.0)
                System.out.print("Available majors:\n"
                        + "[Artificial intelligence, Cyber ​​security, Software Engineering]");
            System.out.print("\n============");
            this.StudentAverage=StudentAverage;
            Allow=true;Boolean =false;
        }else if(StudentAverage>100.0){
            System.out.print("\nAverage Can't Be Greater Than 100.0\n"
                    + "Enter Your Average: ");
        }
        else{
            System.out.println("\nSorry You Can't Join The IT College");
        Boolean=false;}
    }
    public void checkEmail(String Email){
        if(Email.indexOf('@')!=-1 && Email.indexOf('@',Email.indexOf('@')+1)==-1){
            this.Email=Email;
            Boolean=false;
        }
        else
            System.out.print("Invalid Email\n"
                    + "Please Enter An Email: ");
    }
    public void checkPhoneNumber(int PhoneNumber){
        if((""+PhoneNumber).length()==9){
            this.PhoneNumber=PhoneNumber;
            Boolean=false;
        }else
            System.out.print("\n\"Invalid Phone Number\"\n"
                    + "Please Enter Your Phone Number: ");
    }
    //creator Methods
    public void StudentIdMaker(){
        StudentId="2024";
        StudentId+=2000+(int)(Math.random()*(9000-2000));
    }
    private void PasswordMaker(){
        StudentPassword=""+(char)(65+Math.random()*(91-65));
        StudentPassword+=""+(int)(10-Math.random()*(100-10));
        StudentPassword+=(char)(97+Math.random()*(123-97));
        StudentPassword+=""+(int)(10-Math.random()*(100-10));
    }
    //Getter & Setter methods
    public void setStudentPassword(String StudentPassword){
        if(StudentPassword.length()>=6&&StudentPassword.length()<=18){
            this.StudentPassword=StudentPassword;
            Boolean=false;
        }else
            System.out.print("Enter a new password:");
    }
    public String getStudentPassword(){
        return StudentPassword;
    }
    
    public String toString(){
        return "Student Name: "+StudentName
                +"\nStudent Id: "+StudentId
                +"\nPhone number: 0"+PhoneNumber
                +"\nStudent Password: "+StudentPassword;
    }
}

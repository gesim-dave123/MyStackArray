/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class CoupleTester
{
	public static void main(String[] args) {
		Person babae = new Person("Flores","Andie","Lopez",'F');
		Person lalaki = new Person("Amarila","Marco","Garcia",'M');
		Person bff = new Person("Guttierrez","John","Cruz",'M');
		
		babae.displayInfo();
		lalaki.displayInfo();
		bff.displayInfo();
		
		System.out.println("Happilly maried");
		babae.marry(lalaki);
		babae.displayInfo();
		babae.divorce(lalaki);
		babae.displayInfo();
		
		
	}
}
class Person{
	   private String lastname;
	   private String firstname;
	   private String middlename;
	   private String maidenMiddleName;
	   private char sex;
	   
	   public Person(){
	       lastname = "Gesim";
	       firstname ="Dave";
	       middlename="Ong";
	       sex='M';
	   }
	   
	   public Person(String firstname){
	       lastname="Gesim";
	       this.firstname = firstname;
	       middlename="Ong";
	       sex = 'M';
	       
	   }
	   public Person(String middlename,String lastname){
	       this.lastname = lastname;
	       firstname = "Dave";
	       this.middlename=middlename;
	       sex='M';
	   }
	   public Person(String lastname, String firstname, String middlename, char sex){
	       this.lastname=lastname;
	       this.firstname=firstname;
	       this.middlename=middlename;
	       this.sex=sex;
	       
	   }
	     public void setMaidenmiddlename(String maidenMiddleName){
	            this.maidenMiddleName=middlename;
	            
	   }
	   
	   public void setLastname(String lastname){
	       if(lastname.equals(" ")){
	           System.out.println("Invalid lastname");
	       }else
	            this.lastname=lastname;
	   }
	   public void setFirstname(String firstname){
	       if(firstname.equals(" ")){
	           System.out.println("Invalid Firstname");
	       }else
	            this.firstname=firstname;
	            
	   }
	   public void setMiddlename(String middlename){
	       this.middlename=middlename;
	   }
	   public void setSex(char sex){
	       if(sex=='M'||sex=='m'|| sex=='F'||sex=='f'){
	           this.sex=sex;
	       }else
	            System.out.println("Invalid sex ( M or F only)");
	   }
	   public String getLastname(){ return lastname; }
	   public String getFirstname(){ return firstname; }
	   public String getMiddlename(){ return middlename; }
	   public String getmaidenMiddlename(){ return maidenMiddleName; }
	   public char getSex(){ return sex; }
	   
	   public void marry(Person p){
	      if ((this.sex == 'M' && p.getSex() == 'M') || (this.sex == 'F' && p.getSex() == 'F')) {
   
	           System.out.println("Sorry the program cannot proccess this request");
	       }else{
	           if(this.sex=='F'||this.sex=='f'){
	               this.maidenMiddleName=this.middlename;
	               this.middlename=this.lastname;
	               this.lastname=p.lastname;
	           }else{
	               p.maidenMiddleName=p.middlename;
	               p.setMiddlename(p.getLastname());
	               p.setLastname(this.lastname);
	           }
	       }
	   }
	   public void divorce(Person p){
	        if ((this.sex == 'M' && p.getSex() == 'M') || (this.sex == 'F' && p.getSex() == 'F')) {
   
	           System.out.println("Sorry the program cannot proccess this request");
	       }else{
	           if(this.sex=='F'||this.sex=='f'){
	                this.lastname=middlename;
	               this.middlename=this.maidenMiddleName;
	              
	           }else{
	               p.setLastname(this.getmaidenMiddlename());
	               p.setMiddlename(p.getLastname());
	               
	           }
	       }
	       
	       
	   }
	   public void displayInfo(){
	       System.out.println(lastname +", "+getFirstname()+" "+getMiddlename()+" ("+sex+")");
	   }
}
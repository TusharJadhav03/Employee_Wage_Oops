public class Employee_Wage_Oops {
    
    int FULL_TIME_EMP = 1;
    int PART_TIME_EMP = 2;  
    int EMP_FULLTIME_WORK_HOUR = 8;
    int EMP_PARTTIME_WORK_HOUR = 4;
    int total_wage = 0;
    String company;
    int EMP_RATE_PER_HOUR;
    int EMP_WORK_DAYS;
    int EMP_WORK_HOUR;

    public Employee_Wage_Oops(String company,int EMP_RATE_PER_HOUR,int EMP_WORK_DAYS,int EMP_WORK_HOUR){

        this.company = company;
        this.EMP_RATE_PER_HOUR = EMP_RATE_PER_HOUR;
        this.EMP_WORK_DAYS = EMP_WORK_DAYS;
        this.EMP_WORK_HOUR = EMP_WORK_HOUR;
    }
    

    public int calculateEmployeeWage(){

        int emp_wage = 0;
        int total_emp_work_hour = 0;
        int total_emp_work_day = 0;

        while(total_emp_work_hour<=EMP_WORK_HOUR && total_emp_work_day<EMP_WORK_DAYS){

            total_emp_work_day ++;
            int emp_check = (int)Math.floor(Math.random()*10%3);

            if(emp_check == FULL_TIME_EMP){
                emp_wage = EMP_RATE_PER_HOUR * EMP_FULLTIME_WORK_HOUR;
                total_emp_work_hour += EMP_FULLTIME_WORK_HOUR;
            }
            else if(emp_check == PART_TIME_EMP){
                emp_wage = EMP_RATE_PER_HOUR * EMP_PARTTIME_WORK_HOUR;
                total_emp_work_hour += EMP_PARTTIME_WORK_HOUR;
            }
            else{
                emp_wage = 0;
                total_emp_work_hour += 0;
            }
            total_wage += emp_wage;
        }
         return total_wage;
    }

    @Override
    public String toString(){
        return "Total Employee Wage for comapny " +company + " is : " + total_wage;
    }

    public static void main(String[] args) {

        Employee_Wage_Oops emp1 = new Employee_Wage_Oops("Samsung", 300, 25, 250);
        emp1.calculateEmployeeWage();
        System.out.println(emp1);

        Employee_Wage_Oops emp2 = new Employee_Wage_Oops("Apple", 500, 29, 350);
        emp2.calculateEmployeeWage();
        System.out.println(emp2);
        
    }
}

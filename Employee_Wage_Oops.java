 class CompanyEmpWage{
    
    String company;
    int EMP_RATE_PER_HOUR;
    int EMP_WORK_DAYS;
    int EMP_WORK_HOUR;
    int total_wage;

    public CompanyEmpWage(String company,int EMP_RATE_PER_HOUR,int EMP_WORK_DAYS,int EMP_WORK_HOUR){

        this.company = company;
        this.EMP_RATE_PER_HOUR = EMP_RATE_PER_HOUR;
        this.EMP_WORK_DAYS = EMP_WORK_DAYS;
        this.EMP_WORK_HOUR = EMP_WORK_HOUR;
    }

    public void setTotalWage(int total_wage){
         this.total_wage = total_wage;
    }

    @Override
    public String toString(){
        return "Total Employee Wage for comapny " +company + " is : " + total_wage;
    }

}

public class Employee_Wage_Oops {
    int FULL_TIME_EMP = 1;
    int PART_TIME_EMP = 2;  
    int EMP_FULLTIME_WORK_HOUR = 8;
    int EMP_PARTTIME_WORK_HOUR = 4;
    
    
    int noOfCompany = 0;
    CompanyEmpWage[] companyEmpWageArray ;

    public Employee_Wage_Oops(){
        companyEmpWageArray = new CompanyEmpWage[5];
    }

    public void addCompany(String company,int EMP_RATE_PER_HOUR,int EMP_WORK_DAYS,int EMP_WORK_HOUR){

        companyEmpWageArray[noOfCompany] = new CompanyEmpWage(company, EMP_RATE_PER_HOUR, EMP_WORK_DAYS, EMP_WORK_HOUR);
        noOfCompany++;
    }

    public void computeEmpWage(){
        for(int i=0;i<noOfCompany;i++){
            companyEmpWageArray[i].setTotalWage(this.calculateEmployeeWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
    }


    public int calculateEmployeeWage(CompanyEmpWage companyEmpWage){

        int emp_wage = 0;
        int total_emp_work_hour = 0;
        int total_emp_work_day = 0;

        while(total_emp_work_hour<=companyEmpWage.EMP_WORK_HOUR && total_emp_work_day<companyEmpWage.EMP_WORK_DAYS){

            total_emp_work_day ++;
            int emp_check = (int)Math.floor(Math.random()*10%3);

            if(emp_check == FULL_TIME_EMP){
                emp_wage = companyEmpWage.EMP_RATE_PER_HOUR * EMP_FULLTIME_WORK_HOUR;
                total_emp_work_hour += EMP_FULLTIME_WORK_HOUR;
            }
            else if(emp_check == PART_TIME_EMP){
                emp_wage = companyEmpWage.EMP_RATE_PER_HOUR * EMP_PARTTIME_WORK_HOUR;
                total_emp_work_hour += EMP_PARTTIME_WORK_HOUR;
            }
            else{
                emp_wage = 0;
                total_emp_work_hour += 0;
            }
            companyEmpWage.total_wage += emp_wage;
        }
         return companyEmpWage.total_wage;
    }

    

    public static void main(String[] args) {

        Employee_Wage_Oops empwage = new Employee_Wage_Oops();
        empwage.addCompany("Samsung", 20, 25, 200);
        empwage.addCompany("QualityKiosk", 25, 24, 300);
        empwage.addCompany("Bridgelabz", 30, 25, 250);
        empwage.computeEmpWage();
        // empwage.calculateEmployeeWage(null);

        
    }
}
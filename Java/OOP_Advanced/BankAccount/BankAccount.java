public class BankAccount{
    private Integer account_number;
    private Double checking_balance; 
    private Double saving_balance;
    private static int numberOfAccounts = 0;
    private static int total_money_amount = 0;

    public BankAccount(Double checkParam, Double saveParam) {
        numberOfAccounts++;
        rand_acc_num();
        checking_balance = setCheckingBalance(checkParam);
        saving_balance = setSavingBalance(saveParam);
    }

    private int rand_acc_num(){ 
        account_number = (int)((Math.random() * 100000 +1000000000));
        System.out.println("acc num is : "+account_number);
        return account_number;
    }

    public static int AccountCount() {
        return numberOfAccounts;
    }

    public double TotalAmount() {
        total_money_amount = checking_balance + saving_balance;
        return total_money_amount;
    }

    public void setCheckingBalance( double checking_balance){
        this.checking_balance = checking_balance;
    }

    public double getCheckingBalance(){
        return this.checking_balance;
    }

    public void setSavingBalance( double saving_balance){
        this.saving_balance = saving_balance;
    }

    public double getSavingBalance(){
        return this.saving_balance;
    }

    public void depositChecking(double checking_balance){
        this.setCheckingBalance(checking_balance);
        total_money_amount += checking_balance;
    }
    
    public void depositSavings(double saving_balance){
        this.setSavingsBalance(saving_balance);
        total_money_amount += saving_balance;
    }

    public void withdrawalChecking(int amount){
        if (getCheckingBalance() < Double.valueOf(amount)){
            System.out.println("Withdraw not allowed due to insufficient funds");
        } 
        else{
            setCheckingBalance(getCheckingBalance() - amount);
    
        }
    }

    public void withdrawalSaving(int amount){
        if (getSavingBalance() < Double.valueOf(amount)){
            System.out.println("Withdraw not allowed due to insufficient funds");
        } 
        else{
            setSavingBalance(getSavingBalance() - amount);
    
        }
    }

  



}
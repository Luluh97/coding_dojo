class Calculator implements java.io.Serializable {

    
    private Double OperandOne;
    private Double OperandTwo;
    private String Operation;
    private Double Result;
    Calculator(){
    }

    public void setOperandOne( Double OperandOne){
        this.OperandOne = OperandOne;
    }

    public Double getOperandOne(){
        return OperandOne;
    }

    public void setOperandTwo( Double OperandTwo){
        this.OperandTwo = OperandTwo;
    }

    public Double getOperandTwo(){
        return OperandTwo;
    }

    public void setOperation( String Operation){
        this.Operation = Operation;
    }

    public String getOperation(){
        return Operation;
    }

    public void performOperation(){

        if(getOperation() == "+"){
            this.Result = getOperandOne() + getOperandTwo();
        }

        if(getOperation() == "-"){
            this.Result = getOperandOne() - getOperandTwo();  
        }

    }

    public void getResults(){
        System.out.println("Result: "+this.Result);
    }


}
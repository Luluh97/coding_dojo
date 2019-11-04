public abstract class Phone {
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        setversionNumber(versionNumber);
        setcarrier(carrier);
        setringTone(ringTone);
        this.batteryPercentage = batteryPercentage;
  
    }
    // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();

    public void setversionNumber( String versionNumber){
        this.versionNumber = versionNumber;
    }

    public String getversionNumber(){
        return versionNumber;
    }

    public void setcarrier( String carrier){
        this.carrier = carrier;
    }

    public String getcarrier(){
        return carrier;
    }

    public void setringTone( String ringTone){
        this.ringTone = ringTone;
    }

    public String getringTone(){
        return ringTone;
    }

    public void setbatteryPercentage( Integer batteryPercentage){
        this.batteryPercentage = batteryPercentage;
    }

    public Integer getbatteryPercentage(){
        return batteryPercentage;
    }

}

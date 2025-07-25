public class Date{
    private int day,month,year;

    public Date(int D,int month,int year){
        day = D;
        this.month = month;
        this.year = year;
    }
    
    public void setDay(int day){
        if(day>=1 && day<=31){
            this.day = day;
        }
    }

    public void setMonth(int month){
        if(month>=1 && month<=12){
            this.month = month;
        }
    }

    public void setYear(int year){
        this.year = year+543;
    }

    public int getDay(){
        setDay(this.day);
        return this.day;
    }

    public int getMonth(){
        setMonth(this.month);
        return this.month;
    }

    public int getYear(){
        setYear(year);
        return this.year;
    }
}
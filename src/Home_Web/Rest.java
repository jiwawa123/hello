package Home_Web;

public class Rest {
    public String business_id;
    public String city;
    public String state;

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Rest(){

    }
    public String toString(){
        return this.business_id+","+this.city+","+this.state;
    }
}


package pojo;


public class Student {
  private   int stdId;
 private    String stdName;
  private   String stdFather;
   private  String stdBlood;
   private  long stdPhone;
    private String stdCity;
    private  int stdclass;
     

    public Student( int stdId,String stdName,String stdFather,String stdBlood,long stdPhone,String stdCity,int stdclass){
        this.stdId=stdId;
        this.stdName=stdName;
        this.stdFather=stdFather;
        this.stdBlood=stdBlood;
        this.stdPhone=stdPhone;
        this.stdCity=stdCity;
        this.stdclass=stdclass;
    }


    public Student(int stdId) {
        this.stdId=stdId;
    }

    public Student() {
      
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdFather() {
        return stdFather;
    }

    public void setStdFather(String stdFather) {
        this.stdFather = stdFather;
    }

    public String getStdBlood() {
        return stdBlood;
    }

    public void setStdBlood(String stdBlood) {
        this.stdBlood = stdBlood;
    }

    public long getStdPhone() {
        return stdPhone;
    }

    public void setStdPhone(long stdPhone) {
        this.stdPhone = stdPhone;
    }

    public String getStdCity() {
        return stdCity;
    }

    public void setStdCity(String stdCity) {
        this.stdCity = stdCity;
    }

    public int getStdclass() {
        return stdclass;
    }

    public void setStdclass(int stdclass) {
        this.stdclass = stdclass;
    }
}

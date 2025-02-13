
package pojo;



public class Admin {
            private  int stdId;
         private   String name;
       private     String mail;
        private    String pass;
            
       


    public Admin(int stdId, String name, String mail, String pass) {
              this.stdId=stdId;
            this.name=name;
            this.mail=mail;
            this.pass=pass;
        }

    public Admin(int stdId){
        this.stdId=stdId;
    }

    public Admin() {
      
    }
    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}

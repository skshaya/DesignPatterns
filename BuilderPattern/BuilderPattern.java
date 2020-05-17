package builder.pattern;

class User {

    private int nic;
    private String fname;
    private String lname;
    private String mobile;

    public User(Builder builder) {
        this.nic = builder.nic;
        this.fname = builder.fname;
        this.lname = builder.lname;
        this.mobile = builder.mobile;
    }

    public int getNic() {
        return nic;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMobile() {
        return mobile;
    }

    static class Builder {

        private int nic;
        private String fname;
        private String lname;
        private String mobile;

        public Builder(int nic, String fname) {
            this.nic = nic;
            this.fname = fname;
        }

        public Builder setLname(String lname) {
            this.lname = lname;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }
}

public class BuilderPattern {

    public static void main(String[] args) {
        User.Builder builder = new User.Builder(123, "Kamal");
        builder.setLname("Perera")
                .setMobile("0716877567");

        User user = builder.build();
        System.out.println(user.getNic());
        System.out.println(user.getFname());
        System.out.println(user.getLname());
        System.out.println(user.getMobile());
    }
}

package JavaCore_interview.Spring.Inversion_Of_Control.DataBase_Demo;

class WithOut_IoC_DI {
    class User {
        MySqlDatabase database;

        public User() {
            database = new MySqlDatabase();
        }

        public void add(String data) {
            database.persist(data);
        }
    }

    static class MySqlDatabase {
        public void persist(String data) {
            System.out.println("MySQL has persisted: " + data);
        }
    }

    public static void main(String[] args) {
        WithOut_IoC_DI container = new WithOut_IoC_DI();
        User user = container.new User();
        user.add("This is some data!");
    }
}
/*
    Now the issue here is twofold(双重), the first issue is that if we wanted to write unit test
    for this User class. It would be nearly impossible because we rely on internally on a MySQL
    instance.  So it's going to be really hard to test the internals of this code because
    we can't pass in a mock instance of a database. second if we wanted to actually rip ourselves
    away from the internal implementation of connecting to mySql and utilize another database. We
    can't do that because hard-coded our Association of this user to a mySql database instance.
 */
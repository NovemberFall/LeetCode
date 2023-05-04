package JavaCore_interview.Spring.Inversion_Of_Control.DataBase_Demo;

class With_IoC_DI_v2 {
    class User {
        Database database;

        public User(Database database) {
            this.database = database;
        }

        public void add(String data) {
            database.persist(data);
        }
    }

    interface Database {
        void persist(String data);
    }

    class MySqlDatabase implements Database{
        public void persist(String data) {
            System.out.println("MySQL has persisted: " + data);
        }
    }

    class OracleDatabase implements Database{
        public void persist(String data) {
            System.out.println("Oracle has persisted: " + data);
        }
    }

    public static void main(String[] args) {
        With_IoC_DI_v2 container = new With_IoC_DI_v2();
        User user = container.new User(container.new OracleDatabase());
        user.add("This is some data!");
    }
}
/*
    Dependency Inversion Principle:
    Rely on abstractions rather than concrete implementations

    Typically, to follow suit this principle we need to create an interface in between this
    dependency.
 */

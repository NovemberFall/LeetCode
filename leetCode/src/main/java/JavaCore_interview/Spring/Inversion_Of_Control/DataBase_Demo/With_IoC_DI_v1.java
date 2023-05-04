package JavaCore_interview.Spring.Inversion_Of_Control.DataBase_Demo;

class With_IoC_DI_v1 {
    class User {
        MySqlDatabase database;

        public User(MySqlDatabase database) {
            this.database = database;
        }

        public void add(String data) {
            database.persist(data);
        }
    }

    class MySqlDatabase {
        public void persist(String data) {
            System.out.println("MySQL has persisted: " + data);
        }
    }

    public static void main(String[] args) {
        With_IoC_DI_v1 container = new With_IoC_DI_v1();
        User user = container.new User(container.new MySqlDatabase());
        user.add("This is some data!");
    }
}
/*
    1)
    what we need to do is to actually invert the control flow to say instead of
    me handling the creation and lifecycle of this database object. I'm just going to
    have somebody else do it for me, and they're just going to pass it in to my method.
    Therefore, I don't care about it anymore. I just do what I was told to do, and
    I use this instance of a database that was given to me.
    2)
    Now we get the benefit of testability we can write a unit test actually mocks the
    instance of this database, and then we can simulate this persistence call but still test
    the internals of this class. So this is one huge benefit.

    Unfortunately, the customer comes in, and they say I want to use an Oracle database or a
    PostgresSQL database.
 */

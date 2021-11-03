package on.annotations;

@DBTable(name = "member")
public class Member {
    @SQLString(value = 30, name = "firstName") String firstName;
    @SQLString(value = 50, name = "lastName") String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String reference;
    static int memberCount;

    public String getReference() {
        return reference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
}

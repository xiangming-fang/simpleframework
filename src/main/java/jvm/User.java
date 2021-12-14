package jvm;

/**
 * @ProjectName: simpleframework
 * @Package: jvm
 * @ClassName: User
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/12/14 14:06
 */
public class User {
    private String userId;
    User(String userId){
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("now finalize userId == " + userId);
    }
}

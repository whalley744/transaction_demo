package whalley;

import whalley.client.UserClient;

import java.math.BigDecimal;

/**
 * Created by Whalley on 2018/7/30.
 */
public class UserTest {
    public static void main(String[] args) {
        UserClient userClient = new UserClient();
        try {
            userClient.transfer(1000, 1001, BigDecimal.valueOf(999.99));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

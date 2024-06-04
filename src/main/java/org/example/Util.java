package org.example;

import net.datafaker.Faker;
import org.example.model.EmailAddress;
import org.example.model.MobileNumber;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<User> createALotOfUsers() {
        var result = new ArrayList<User>();
        var faker = new Faker();

        for (int i = 0; i < 10000; i++) {
            var emailAddresses = new ArrayList<>(List.of(
                    new EmailAddress("qwe" + i + "@gmail.com"),
                    new EmailAddress("qwe" + i + 1 + "@gmail.com")
            ));

            String fullName = faker.name().fullName();

            var mobileNumbers = new ArrayList<>(List.of(
                    new MobileNumber(faker.phoneNumber().phoneNumber()),
                    new MobileNumber(faker.phoneNumber().phoneNumber()),
                    new MobileNumber(faker.phoneNumber().phoneNumber())
            ));

            var user = new User(emailAddresses, fullName, mobileNumbers);

            for (EmailAddress emailAddress : emailAddresses) {
                emailAddress.setUser(user);
            }

            for (MobileNumber mobileNumber : mobileNumbers) {
                mobileNumber.setUser(user);
            }

            result.add(user);
        }

        return result;
    }
}

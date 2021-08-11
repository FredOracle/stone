package com.example.demo.java.predicate;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

public class Test {

  public static void main(String[] args) {

    List<User> users = new ArrayList<>();
    User user1 = User.builder().username("Fred").age(10).dept("A")
        .permissions(Lists.newArrayList("ab,c,dd,af".split(","))).build();
    User user2 = User.builder().username("Hu").age(35).dept("B")
        .permissions(Lists.newArrayList("ab,c,dd,af".split(","))).build();
    User user3 = User.builder().username("Miao").age(73).dept("C")
        .permissions(Lists.newArrayList("ab,c,dd,af".split(","))).build();

    users.add(user1);
    users.add(user2);
    users.add(user3);

    Predicate<User> filterFredUserPredicate = new Predicate<User>() {
      @Override
      public boolean test(User user) {
        return user.getUsername().equals("Fred");
      }
    };

    Predicate<User> filterDeptUserPredicate = new Predicate<User>() {
      @Override
      public boolean test(User user) {
        return user.getDept().equals("B");
      }
    };

    List<User> res = users.stream().filter(user -> filterFredUserPredicate.test(user))
        .filter(user -> filterDeptUserPredicate.test(user)).collect(Collectors.toList());

    System.out.println(res);

  }


}

@Data
@Builder
class User {

  private String username;

  private String dept;

  private Integer age;

  private List<String> permissions;

}
package com.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.test.UserDO;
import com.test.UserVO;

public class SortUserList {

	public static void main(String[] args) {
		
		List<UserDO> userList = buildUser();
		Predicate<UserDO> agePredicate = (UserDO p) -> p.getAge() >35;
		Predicate<UserDO> statusPredicate = (UserDO p) -> p.getGender().equals("M");
		
		System.out.println("Print all the Mail genders who have more then 35 years old  ");
		
		Function<UserDO , UserVO> userFunction  =  new Function<UserDO , UserVO>(){
			 public UserVO apply(UserDO t) {
				UserVO uservo = new UserVO();
				uservo.setEmail(t.getEmail());
				uservo.setName(t.getName());
				return uservo;
			 }
		};
		
		List<UserVO> statusMUsers = userList.stream().filter(statusPredicate).filter(agePredicate).map(userFunction).collect(Collectors.<UserVO> toList());
		printUser(statusMUsers);
	}
	
	public static void printUser (List<UserVO> printUsers){
		printUsers.stream().forEach(e -> System.out.println( "User Name : "+ e.getName() +" Email : "+e.getEmail() ));
	}
	
	public static List<UserDO >buildUser(){
		List<UserDO> userlist = new ArrayList<>();
		UserDO user1 = new UserDO();
		user1.setAge(20);
		user1.setName("Test1");
		user1.setStatus("UM");
		user1.setGender("M");
		user1.setEmail("Test1@gmail.com");
		userlist.add(user1);
		
		UserDO user2 = new UserDO();
		user2.setAge(30);
		user2.setName("Test2");
		user2.setStatus("UM");
		user2.setGender("M");
		user2.setEmail("Test2@gmail.com");
		userlist.add(user2);
		
		UserDO user3 = new UserDO();
		user3.setAge(40);
		user3.setName("Test3");
		user3.setStatus("M");
		user3.setGender("M");
		user3.setEmail("Test3@gmail.com");
		userlist.add(user3);
		
		UserDO user4 = new UserDO();
		user4.setAge(30);
		user4.setName("Test4");
		user4.setStatus("M");
		user4.setGender("W");
		user4.setEmail("user4@gmail.com");
		userlist.add(user4);
		
		return userlist;
		
	}

}

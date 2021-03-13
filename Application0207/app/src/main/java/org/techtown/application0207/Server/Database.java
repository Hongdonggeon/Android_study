package org.techtown.application0207.Server;

import android.util.Log;

import org.techtown.application0207.VO.User;

import java.util.HashMap;

// 실제로 사용할 DB가 아닌 실습용으로 만든 DB
public class Database {
    public static HashMap<String, User> userlist = new HashMap<>();

    public static void add(User user){
        userlist.put(user.getId(), user);
        // 로그 출력
        Log.d("User ADD","add\n"+user);
    }

    public static boolean checkID(String id){
        return !userlist.containsKey(id);
    }

    // 로그인 검사
    public static User checkLogin(String id, String pw){
        User user = userlist.get(id);
        if(user == null) return null;

        //등록된 회원의 pw와 입력된 pw와 같으면
        return user.getPw().equals(pw) ? user : null;
    }
}


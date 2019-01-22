package my.chanweixiongcom.chanweixiong;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface userDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> loadAllUsers();

    //':'== input parameter
    @Query("SELECT * FROM user WHERE IC=:IC")
    List<User> findUserByIC(String IC);

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

}

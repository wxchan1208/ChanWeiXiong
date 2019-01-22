package my.chanweixiongcom.chanweixiong;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class UserRepository {
    private userDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        //create instance of a database
        AppDatabase db = AppDatabase.getDatabase(application);

        userDao = db.userDao();
        //load all records to the livedata
        allUsers = userDao.loadAllUsers();
    }

    LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    public void insertUser(User user){
        new insertAsyncTask(userDao).execute(user);
    }

    //<Param, Progress, Results>
    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {
        private userDao userDao;

        public insertAsyncTask(userDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insertUser(users[0]);
            return null;
        }
    }
}



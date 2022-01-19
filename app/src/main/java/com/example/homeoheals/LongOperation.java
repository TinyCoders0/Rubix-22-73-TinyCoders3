package com.example.homeoheals;

import android.os.AsyncTask;
import android.util.Log;
class LongOperation extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        try {
            GMailSender sender = new GMailSender("adventteam3@gmail.com", "AdventTeam.003");
            sender.sendMail("HomeoHeals Appointment",
                    "Please check Database","adventteam3@gmail.com",
                    "chaudharishruti13@gmail.com")                   ;
        } catch (Exception e) {
            Log.e("error", e.getMessage(), e);
            return "Email Not Sent";
        }
        return "Email Sent";
    }
    @Override
    protected void onPostExecute(String result) {
        Log.e("LongOperation",result+"");
    }
    @Override
    protected void onPreExecute() {
    }
    @Override
    protected void onProgressUpdate(Void... values) {
    }
}

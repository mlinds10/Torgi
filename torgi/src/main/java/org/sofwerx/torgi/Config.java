package org.sofwerx.torgi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;

import java.io.File;

public class Config {
    public final static String PREFS_SAVE_DIR = "savedir";
    public final static String PREFS_PROCESS_EW = "processew";

    private static Config instance = null;
    private String savedDir = null;
    private boolean processEWonboard = false;
    private SharedPreferences prefs = null;
    private Context context;

    private Config(Context context) {
        this.context = context;
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        processEWonboard = prefs.getBoolean(PREFS_PROCESS_EW,false);
    }

    public static Config getInstance(Context context) {
        if (instance == null)
            instance = new Config(context);
        return instance;
    }

    public void setProcessEWonboard(boolean processEWonboard) {
        this.processEWonboard = processEWonboard;
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(PREFS_PROCESS_EW,processEWonboard);
        edit.commit();
    }

    public boolean processEWOnboard() {
        return processEWonboard;
    }

    public String getSavedDir() {
        if (savedDir == null) {
            /*savedDir = prefs.getString(PREFS_SAVE_DIR, null);
            if (savedDir != null) {
                try {
                    Uri savedDirUri = Uri.parse(savedDir);
                    if (savedDirUri != null) {
                        context.getContentResolver().takePersistableUriPermission(savedDirUri,
                                Intent.FLAG_GRANT_READ_URI_PERMISSION |
                                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION); //Keep the permissions to access this location up to date across reboots
                    }
                } catch (NullPointerException ignore) {}
            }
            if (savedDir == null)
                savedDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();*/
            if (savedDir == null) {
                File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "TORGI");
                folder.mkdirs();
                savedDir = folder.getAbsolutePath();
            }
        }
        return savedDir;
    }

    public void setSavedDir(String savedDir) {
        SharedPreferences.Editor edit = prefs.edit();
            if (savedDir == null)
                edit.remove(PREFS_SAVE_DIR);
            else
                edit.putString(PREFS_SAVE_DIR,savedDir);
        edit.commit();
    }
}

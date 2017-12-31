package  yacov.sapiashvili.viewpager.utilities;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yaacovs on 28/12/2017.
 */

public class Utils {
    public static String loadMockupData(Context context){
        AssetManager assetManager = context.getAssets();
        InputStream input;
        String result = null;
        try {
            input = assetManager.open("jsonObject.json");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            // byte buffer into a string
            result = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}

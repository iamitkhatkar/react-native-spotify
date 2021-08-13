package com.lufinkey.react.spotify;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;

public class RNSpotifyPackage implements ReactPackage {
    ReactApplicationContext mContext;
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        mContext = reactContext;
      return Arrays.<NativeModule>asList(new RNSpotifyModule(reactContext));
    }

    // Deprecated from RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
      return Collections.emptyList();
    }

    public void onDestroy(){
        new RNSpotifyModule(mContext).onCatalystInstanceDestroy();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
      return Collections.emptyList();
    }
}

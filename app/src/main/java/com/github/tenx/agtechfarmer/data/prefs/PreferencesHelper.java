package com.github.tenx.agtechfarmer.data.prefs;

public interface PreferencesHelper {
    String getAccessToken();

    void setAccessToken(String token);

    void setEmail(String email);

    String getEmail();


    void setUserId(String userId);

    String getUserId();


}

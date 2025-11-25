package com.scm.forms;

import com.scm.entities.Providers;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class UserForm {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String about;
    private String phoneNumber;

    //chatgpt se pucha kyu ki erro aa raha tha
    // yawala C:\Users\Sandip\Downloads\scm2.0\src\main\java\com\scm\controllers\PageController.java:100:33
    //java: cannot find symbol
    //  symbol:   method isEnabled()
    //  location: variable userForm of type com.scm.forms.UserForm

    private boolean enabled;
    private boolean emailVerified;
    private boolean phoneVerified;
    private Providers provider;
    private String providerUserId;

}

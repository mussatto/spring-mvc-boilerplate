package com.curupira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/social/facebook")
@Controller
public class SocialAuthController {

    private static final String SCOPE = "email,offline_access,user_about_me,user_birthday,read_friendlists";
    private static final String REDIRECT_URI = "http://localhost:8080/spring-mvc-boilerplate/social/facebook/callback";
    private static final String CLIENT_ID = "";
    private static final String APP_SECRET = "";
    private static final String DIALOG_OAUTH = "https://www.facebook.com/dialog/oauth";
    private static final String ACCESS_TOKEN = "https://graph.facebook.com/oauth/access_token";

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public void signin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            //TODO: if already have a valid access token, no need to redirect, just login
            response.sendRedirect(DIALOG_OAUTH+"?client_id="+CLIENT_ID+
                    "&redirect_uri="+REDIRECT_URI+
                            "&scope="+SCOPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/callback", params = "code", method = RequestMethod.GET)
    @ResponseBody
    public void accessCode(@RequestParam("code") String code,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        try {
            response.setContentType("text/html");
            String responseString = "";
            response.getWriter().write(responseString);
            response.flushBuffer();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/callback", params = "error_reason", method = RequestMethod.GET)
    @ResponseBody
    public void error(@RequestParam("error_reason") String errorReason,
                      @RequestParam("error") String error,
                      @RequestParam("error_description") String description,
                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, description);
            System.out.println(errorReason);
            System.out.println(error);
            System.out.println(description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.annotation.PostConstruct;
import org.smslib.CService;

public class messageController {

    String apikey;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    @PostConstruct
    public void init() {
        try {
            URL url = new URL("http://www.envoyersms.biz/api/v1/?method=credit&apikey=" + URLEncoder.encode(getApikey(), "ISO-8859-1"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer results = new StringBuffer();
            String solde = br.readLine();
            br.close();

        } catch (Exception exception) {
            System.out.println("dog");
        }
    }


    public void sms() {
        CService srv = new CService("COM10", 110, "huawei", "e303");
        System.out.println();
        System.out.println("SendMessage(): Send a message.");
        System.out.println("  Using " + CService._name + " " + CService._version);
        System.out.println();

        try {
            srv.setSimPin("");
            srv.setSimPin2("0000");
            srv.setSmscNumber("");
            srv.connect();
            System.out.println("c connec");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erreur :"+e.getMessage());
        }

    }
}

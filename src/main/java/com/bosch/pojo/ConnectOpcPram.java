package com.bosch.pojo;

public class ConnectOpcPram {
    private int id;
    private String host;// server
    private String kk;
    private String domain;
    private String progId;//"Softing.OPC.DF.Configuration1.DA";
    private String clsiId;//"DA771DCC-3C2C-4687-81F2-FF79C0355D20";
    private String user;//"Opcuser";// server上的访问用户
    private String password;//"123456";// 访问用户的密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProgId() {
        return progId;
    }

    public void setProgId(String progId) {
        this.progId = progId;
    }

    public String getClsiId() {
        return clsiId;
    }

    public void setClsiId(String clsiId) {
        this.clsiId = clsiId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ConnectOpcPram{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", domain='" + domain + '\'' +
                ", progId='" + progId + '\'' +
                ", clsiId='" + clsiId + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
